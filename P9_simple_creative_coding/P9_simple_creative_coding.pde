float x,y;
float size;

void setup(){
  size(500,500);
  background(0);
  noFill();
  strokeWeight(2);
  x = 0;
  y = 0;
  size = 30;
  
}

void draw(){
  stroke(12,250,180,10);
  ellipse(x,y,size,size);
  
  x = x + random(0.6)-0.2;
  y = y + random(0.6)-0.2;
  size = size + random(0.5)-0.2;
}
  