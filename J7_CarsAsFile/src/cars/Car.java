package cars;

import processing.core.PApplet;

public class Car {
	float x;
	float y;
	int c;
	float speed;
	PApplet p;
	
	// Class Constructor
	public Car(PApplet nP, float nx, float ny, float nspeed){
		x = nx;
		y = ny;
		speed = nspeed;
		p = nP;
		c = (int)p.random(256);
	}
	
	// Display the car (functionality)
	public void display(){
		p.fill(c);
		p.rect(x,y,30,10);
	}
	
	// Move the car (functionality)
	public void move(){
		if(x > p.width){
			x = -30;
		}
		x=x+speed;
	}
}
