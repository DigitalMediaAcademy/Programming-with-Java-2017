import java.util.*;
PGraphics pen, colors;
ArrayList<Streamer> streamers;
int pmX, pmY;
int density = 2;
int maxlife = 200;
int hue = 127;
int brt = 127;

boolean menu;
boolean rainbow;

PImage hb;

public void setup() {
  //size(displayWidth, displayHeight);
  fullScreen();
  
  streamers = new ArrayList<Streamer>();
  pen = createGraphics(width, height);
  colors = createGraphics(width, height);
  pen.beginDraw();
   pen.background(0);
   pen.stroke(255);
   pen.strokeWeight(3);
  pen.endDraw();
  colors.beginDraw();
   colors.background(255);
   colors.strokeWeight(2);
  colors.endDraw();
  colorMode(HSB, 255, 255, 255);
  
  hb = createImage(256,256,RGB);
  hb.loadPixels();
  for (int b = 0; b < 256; b++) {
    for (int h = 0; h < 256; h++) {
      int ind = h + b*256;
      hb.pixels[ind] = color(h,255,b);
    }
  }
  hb.updatePixels();
  
}

public void draw() {
  background(0);
  drawImg();
  
  if (menu) drawPenSelect();
  //if (frameCount % 3 == 0 ) saveFrame("######.jpg");
}

public void drawImg() {
  colors.beginDraw();
  colors.blendMode(MULTIPLY);
  if (streamers.size() > 0) { 
    Iterator<Streamer> it = streamers.listIterator();
    while (it.hasNext()) {
      Streamer s = it.next();
      s.update(colors);
      if (s.done) it.remove();
    }
  }
  colors.endDraw();
  image(colors,0,0);
  
  blendMode(SUBTRACT);
  image(pen,0,0);
}

public void drawPenSelect() {
  int left = width/2 - 127;
  int top = height/2 - 127;
  blendMode(NORMAL);
  
  strokeWeight(2);
  stroke(0);
  fill(getahue(),255,getabright());
  rect(left-20,top-20,hb.width+40,hb.height+40);
  image(hb, left, top);
}

public int getalife() {
  return (int)(random(maxlife)*random(1))+5;
}
public int getahue() {
  if (rainbow) return (int)(sin(frameCount*0.01)*127+127);
  return hue;
  
}
public int getabright() {
  if (rainbow) return 255;
  return brt;
}

public void keyPressed() {
  if (key == CODED && keyCode == SHIFT) {
    menu =true;
  }
}

public void keyReleased() {
  if (key == CODED && keyCode == SHIFT) {
    menu =false;
  }
  if (key == ' ') {
    pen.beginDraw();
    pen.background(0);
    pen.endDraw();
    colors.beginDraw();
    colors.background(255);
    colors.endDraw();
    streamers.clear();
  }
  
  if (key == 's' || key == 'S')  {
    saveFrame();
    println("saved");
  }
}


public class Streamer {
  float dx, dy, px, py;
  int col;
  float life, maxlife;
  boolean done = false;
  float rate;
  public Streamer(float x, float y, float vx, float vy, int hue, int brt, int life) {
    rate = random(1.0)*0.5+0.1;
    dx = vx*rate;
    dy = vy*rate;
    px = x;
    py = y;
    
    col = color(hue,255,random(255-brt)*(brt/255.0)+brt);
    
    this.life = life;
    maxlife =life;
  }
  public void update(PGraphics graph) {
    if (life <= 0) done = true;
    if (done) return;
    life--;
    graph.stroke(col, life/maxlife*100);
    graph.point(px, py);
    px+=dx;
    py+=dy;
  }
}

public void mouseReleased() {
  if (!menu) return;
  if (mouseButton == LEFT) {
  int left = width/2 - 127;
  int top = height/2 - 127;
  int mx = (mouseX - left);
  int my = (mouseY - top);
  if (mx < 0 || mx > 255 || my < 0 || my > 255) return;
  hue = mx;
  brt = my;
  } else {
    rainbow = !rainbow;
  }
}

public void mouseDragged() {
  if (menu) return;
  liner(pmouseX, pmouseY, mouseX, mouseY);
}

public void liner(float x0, float y0, float x1, float y1) {
  pen.beginDraw();
   pen.line(x0, y0, x1, y1);
  pen.endDraw();
  
  float dx = x1-x0;
  float dy = y1-y0;
  float dd = sqrt(dx*dx + dy*dy);
  dx/=dd;
  dy/=dd;

  int cnt = (int)(dd*density);
  for (int i = 0; i < cnt; i++) {
    float m = (float)i/density;
    streamers.add(new Streamer(dx*m+x0, dy*m+y0, dy, -dx, getahue(), getabright(), getalife()));
  }
  
}