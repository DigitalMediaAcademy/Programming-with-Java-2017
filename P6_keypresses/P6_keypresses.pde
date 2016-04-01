void setup() {
  size (200, 200);
}

void draw() {
  background(168, 234, 233); // why is this in draw()?

  if (keyPressed == true) {
    fill(13, 185, 14);
    textSize(20);
    text("Key Pressed!", 40, 100);
  }
}