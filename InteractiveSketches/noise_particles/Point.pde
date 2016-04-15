class Point{
  
  PVector root, loc, vel, acc;
  float size, xoff, xinc;
  color col;
  
  Point(float x, float y){
    root = new PVector(x, y);
    loc = new PVector(x, y);
    vel = new PVector(0,0);
    acc = new PVector(0,0);
    size = 10;
    xoff = random(10000);
    xinc = 0.01;
    col = color(random(256),random(256),random(256));
  }
  
  void render(){
    noFill();
    //stroke(noise(xoff)*256,noise(xoff+10000)*255,noise(xoff+20000)*256);
    stroke(col,50);
    size = map(noise(xoff),0,1,10,50);
    ellipse(loc.x, loc.y, size, size);
  }
  
  void update(){
    
    if(mousePressed){
      PVector mouse = new PVector(mouseX,mouseY);
      // Step 1: direction
      PVector dir = PVector.sub(mouse,loc);
      
      dir.mult(0.01);
      
      // Step 4: accelerate
      acc = dir;
  
      vel.add(acc);
      
      loc.add(vel);
    }
    else{
    PVector spring = PVector.sub(root,loc).div(100);
    acc = new PVector((noise(xoff)-0.5),(noise(xoff+10000)-0.5));
    acc.add(spring);
    //acc = new PVector(noise();
    vel.add(acc);
    vel.mult(0.9);
    loc.add(vel);
    }
    
    

    xoff += xinc;
    
  }
  
}