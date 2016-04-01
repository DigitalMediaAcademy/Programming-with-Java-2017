void setup() {
  size (200, 200);
  rectMode(CENTER);
  ellipseMode(CENTER);
  //noStroke();
}

void draw() {
  background(168, 234, 233); // why is this in draw()?

  if (keyPressed == true) {
    fill(13, 185, 14);
    textSize(20); 
    text("You pressed: ", 40, 100); //place text starting at (40, 100)
    textSize(40); // change the text sixe to 40 pixels
    text(key, 90, 150); // display the key value at position (90, 150)
    
    if(key == 'a' || key == 'A'){
      fill(100, 0, 0);
      ellipse(100, 40, 30, 30);
    }
    
    if(key =='w' || key == 'W'){
      fill(0, 100, 0);
      rect(100, 40, 30, 30);
    }
    //... add more key presses as necessary
  }
}