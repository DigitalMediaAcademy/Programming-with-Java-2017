
ArrayList<PVector> allVectors;
 
float wanderSpeed = 0.5;
int numSteps = 10; 
 
float lineHue = 231.0/255.0;
float lineSat = 66.0/100.0;
float lineBright = 61.0/100.0;
float colorTrigger = 0.99;
 
boolean autoplay = false;
boolean paused = false;
 
void setup()
{
  size(2880, 1800);
  colorMode(HSB, 1.0, 1.0, 1.0, 1.0);
  background(0.0);
  noFill();
 
  createLine();
  //randomizeColor();
}
 
void draw()
{
  if(paused) return;
  strokeWeight(3);
  // randomize color if neccesary
  if (random(0, 1) > colorTrigger) randomizeColor();
 
  stroke(lineHue, lineSat, lineBright, 0.10);
  fill(255);
 
  // draw top line
  beginShape();
 
  for (int i=0; i<allVectors.size (); i++)
  {
    PVector vector = allVectors.get(i);
    if (i == 0) curveVertex(vector.x, vector.y);
    curveVertex(vector.x, vector.y);
    if (i == allVectors.size()-1) curveVertex(vector.x, vector.y);
  }
  endShape();
 
  // draw bottom line
  beginShape();
  for (int i=0; i<allVectors.size (); i++)
  {
    PVector vector = allVectors.get(i);
    if (i == 0)curveVertex(vector.x, height-vector.y);
    curveVertex(vector.x, height-vector.y);
    if (i == allVectors.size()-1) curveVertex(vector.x, height-vector.y);
 
    vector.x += random(-wanderSpeed, wanderSpeed);
    vector.y += random(-wanderSpeed, wanderSpeed);
    vector.y += 0.3;
 
    if (i == 0) vector.x = 0;
    if (i == allVectors.size()-1) vector.x = width;
  }
  endShape();
 
  checkAutoplay();
  //saveImage();
}
 
void checkAutoplay()
{
  if (autoplay)
  {
    // reset if line has left screen
    for (int i=0; i<allVectors.size (); i++)
    {
      PVector vector = allVectors.get(i);
      if (vector.y < height) return;
    }
    // reset if boundary check didn't exit functiion
    reset();
  }
}

void saveImage()
{
    // check if line has left screen
    //for (int i=0; i<allVectors.size (); i++)
    //{
    //  PVector vector = allVectors.get(i);
    //  if (vector.y < height) return;
    //}
    // save and reset if boundary check didn't exit functiion
    save("/Users/shanewhite/Pictures/lines.png");
    //reset();
  
}
 
void createLine()
{
  allVectors = new ArrayList<PVector>();
 
  for (int i=0; i<=numSteps; i++)
  {
    PVector vector = new PVector(i * width/numSteps, height/2);
    allVectors.add(vector);
  }
}
 
void randomizeColor()
{
  lineHue = random(lineHue-0.09, lineHue+0.09);
  lineSat = random(lineSat-0.09, lineSat+0.09);
}
 
void reset()
{
  background(0.0);
  createLine();
  randomizeColor();
  wanderSpeed = random(0.3, 2.0);
  numSteps = (int)random(1, 20);
  colorTrigger = random(0.99, 0.9999);
}

void pause()
{
  paused = !paused;
}
 
void mousePressed()
{
  reset();
}
 
void keyPressed()
{
  if (key == 'c')
  {
    randomizeColor();
  }
 
  if (key == 'r')
  {
    lineHue = 1.0;
    lineSat = 0.0;
    lineBright = 1.0;
  }
 
  if (key == 'a')
  {
    autoplay = !autoplay;
  }
  
  if (key == 's')
  {
    saveImage();
    pause();
  }
  
  if ( key == 'p')
  {
    pause();
  }
}