Point[] pts = new Point[100];
void setup(){
  //size(500,500);
  fullScreen();
  background(0);
  for (int i = 0; i < pts.length; i++){
    pts[i] = new Point(random(width),random(height));
  }
}

void draw(){
  fill(0,10);
  rect(0,0,width,height);
  for (int i = 0; i < pts.length; i++){
    pts[i].update();
    pts[i].render();
  }
}