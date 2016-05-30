import processing.core.PApplet;

public class CarsStart extends PApplet{

	public static void main(String[] args) {
		PApplet.main("CarsStart");
	}
	
	public void settings(){
		size(200,200);
	}
	
	float x = 100;
	float y = 100;
	float speed = 1;
	int color = 200;
	
	public void setup(){
		background(255);
	}
	
	public void draw(){
		background(255);
		display();
		move();
	}
	
	public void display(){
		fill(color);
		rect(x,y,30,10);
	}
	
	public void move(){
		x = x + speed;
		if(x > width){
			x = -30;  //You CAN set locations to be negative!
		}		
	}

}
