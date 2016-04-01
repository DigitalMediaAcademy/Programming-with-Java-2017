// basic drawing app 

void setup () {
  //frameRate(12); change frame rate to demo update speed 
  background(255); // set background color to white
  size (400, 400); // set background size to 400 by 400 pixels
  strokeWeight(3); // set stroke weight to 3
}

void draw() {
  ellipse(mouseX, mouseY, 5, 5);  // draw a circle at mouse location
  //line(pmouseX, pmouseY, mouseX, mouseY);
  // code that prints out the values of mouseX and mouseY to the console.
  println("mouseX: " + mouseX + " , mouseY: " + mouseY);
}