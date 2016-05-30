package cars;

import processing.core.PApplet;

public class Cars extends PApplet{
	public static void main(String[] args){
		PApplet.main("cars.Cars"); // Start the parent program
	}
	
	//Create Object variables, instead of a bunch of value variables. 
	Car car1;
	Car car2;
	
	public void settings(){
		size(200,200);
	}
	
	public void setup(){
		// Initialize those Objects 
		car1 = new Car( 25, 100, 2);
		car2 = new Car( 150, 65, 3);
	}
	
	public void draw(){
		background(255);
		
		// Move EACH car object
		car1.move();
		car2.move();
		
		// Display EACH car object
		car1.display();
		car2.display();
	}
	
	public class Car {
		float x;
		float y;
		int c;
		float speed;
		//PApplet p;
		
		// Class Constructor
		public Car( float nx, float ny, float nspeed){
			x = nx;
			y = ny;
			speed = nspeed;
			//p = nP;
			c = (int)random(256);
		}
		
		// Display the car (functionality)
		public void display(){
			fill(c);
			rect(x,y,30,10);
		}
		
		// Move the car (functionality)
		public void move(){
			if(x > width){
				x = -30;
			}
			x=x+speed;
		}
	}
}
