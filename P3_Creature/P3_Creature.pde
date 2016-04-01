size(200,200); //set size of screen

background(20, 100, 200); //set background colour (Red, Green, Blue) 
//vals can range between 0 and 255

strokeWeight(4); //determine thickness of stroke lines

// ANTENNAE
line(50, 20, 70, 40);
line(120, 20, 100, 40);

//HEAD
ellipse(85, 60, 70, 50);

// EYES
ellipse(75, 50, 20, 20);
ellipse(95, 50, 20, 20);

// MOUTHs
triangle(75, 70, 95, 70, 85, 85);

// BODY
rect(60, 80, 50, 60);

// ARMS
line(60, 90, 30, 110);
line(110,90, 140, 110);

// LEGS
triangle(60, 140, 85, 140, 72.5, 165);
triangle(85, 140, 110, 140, 97.5, 165);