import peasy.*;
import ddf.minim.*;
import ddf.minim.analysis.*;

PeasyCam cam;

Minim minim;
AudioPlayer player;
AudioInput input;
FFT fft;

/* G: gravitational constant */
float G = 0.0001;

/* N: number of particles */
int N = 1000;

/* positions: particles' positions */
ArrayList<PVector> positions;

/* velocities: particles' velocities */
ArrayList<PVector> velocities;

void setup()
{
  //size(600,600,P3D);
  fullScreen(P3D);
  /* hue/saturation/value color mode because the particles' hues are determined by their velocities */
  colorMode(HSB,1,1,1);
  
  frameRate(12);
  
  cam = new PeasyCam(this,100);
  
  initialize();
  
  minim = new Minim(this); // initialize minim object
  player = minim.loadFile("Adrianna_Krikl_-_02_-_Glitch.mp3"); // create audioplayer object from audio file
  player.play(); // play audio file
  input = minim.getLineIn(); // create audioinput object from the pc audio input (microphone)
  fft = new FFT(player.bufferSize(), player.sampleRate()); // create fft (fast fourier transform) object from 'player' audioplayer object
}

void draw()
{
  background(0,0,100);
  
  fft.forward(player.mix); // perform a fast fourier transform on the player's "mix" buffer, which is the average of the "left" and "right" buffers (stereo sound)
  
  for(int i = 0; i < positions.size(); i++)
  {
    int li;
    float mi;
    
    boolean SPATIAL_DOMAIN = false;
    
    if(SPATIAL_DOMAIN)
    {
      li = i*(player.bufferSize()-1)/positions.size();
      
      mi = 1 + abs(player.mix.get(li));
    }
    else
    {
      li = i*(fft.specSize()-1)/positions.size();
      
      mi = 1 + abs(fft.getBand(li));
    }
    
    PVector p = positions.get(i);
    PVector v = velocities.get(i);
    
    pushMatrix();
      strokeWeight(pow(mi,0.8));
      stroke(0.4*v.mag(),1,1);
      point(p.x,p.y,p.z);
    popMatrix();
  }
  
  updatePositions();
  
  // save frames in a folder if you want to create a video of the execution afterwards
  saveFrame("frames/#####.png");
}

void initialize()
{
  int n = (int)sqrt(N);
  
  positions = new ArrayList<PVector>();
  velocities = new ArrayList<PVector>();
  
  for(float theta = 0; theta < PI;     theta  +=  (PI/n))
  for(float rho = 0;   rho   < 2*PI;   rho    +=  ((2*PI)/n))
  {
    float r = 0.05*width;
    
    float x,y,z, vx,vy,vz;
    
    x = r*sin(theta)*cos(rho);
    y = r*sin(theta)*sin(rho);
    z = r*cos(theta);
    
    /*float v = 0.001;
    vx = random(-v*r,v*r);
    vy = random(-v*r,v*r);
    vz = random(-v*r,v*r);*/
    
    vx = vy = vz = 0;
    
    positions.add(new PVector(x,y,z));
    velocities.add(new PVector(vx,vy,vz));
  }
}

void updatePositions()
{
  /* update velocities */
  for(int i = 0; i < positions.size(); i++)
  for(int j = i+1; j < positions.size(); j++)
  if(random(0,1) < 0.7)
  {
    int li,lj;
    float mi,mj;
    
    boolean SPATIAL_DOMAIN = false;
    
    if(SPATIAL_DOMAIN)
    {
      li = i*(player.bufferSize()-1)/positions.size();
      lj = i*(player.bufferSize()-1)/positions.size();
      
      mi = 1 + abs(player.mix.get(li));
      mj = 1 + abs(player.mix.get(lj));
    }
    else
    {
      li = i*(fft.specSize()-1)/positions.size();
      lj = j*(fft.specSize()-1)/positions.size();
      
      mi = 1 + abs(fft.getBand(li));
      mj = 1 + abs(fft.getBand(lj));
    }
    
    PVector delta = PVector.sub(positions.get(j),positions.get(i));
    
    if(delta.mag() < pow(10,-5)) continue;
    
    PVector vi = PVector.mult(delta,mi*mj*G*pow(delta.mag(),-2));
    
    (velocities.get(i)).add(vi);
    (velocities.get(j)).sub(vi);
  }
  
  /* update positions */
  for(int i = 0; i < positions.size(); i++)
  {
    (positions.get(i)).add(velocities.get(i));
  }
}