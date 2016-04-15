ArrayList<PVector> points;
color[] colors;

int numRects = 100;

void setup(){
  size(1080, 620);
  background(255);
  rectMode(CENTER);
  noStroke();
  
  points = new ArrayList<PVector>();
  colors = new color[numRects];
  for(int i = 0; i < numRects; i++){
    points.add(new PVector(random(width),random(height)));
    colors[i] = color(random(256),random(256),random(256));
  }
}

void draw(){
  background(255);
  for(int i = 0; i < numRects; i++){
    float d = 400 - dist(points.get(i).x, points.get(i).y, mouseX, mouseY);
    color c = colors[i];
    if(d > 0){
      fill(c, 100);
      rect(points.get(i).x, points.get(i).y, d/4,d/4);
    }
    
  }
}
  