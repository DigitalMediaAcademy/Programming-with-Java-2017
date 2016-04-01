
  //setup
  size(200, 200);
  background(255);
  noFill();
  ellipseMode(CENTER);
  rectMode(CENTER);


  for(int i=1; i < 10; i++) {
      //rect(100, 100, 20*i, 20*i);
      ellipse(100, 100, 10*i, 20*i);
      println("value of i: " + i);
      println("width/height of ellipse: " + (20*i));
  }