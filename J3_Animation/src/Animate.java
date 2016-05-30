import processing.core.PApplet;

public class Animate extends PApplet {

	public static void main(String[] args){
		PApplet.main("Animate");
	}
	
	float x = 100;
	float y = 100;
	float speed = 1;
	int c = 0;
	
	public void settings(){
		size(200,200);
	}
	
	public void setup(){
		
	}
	
	public void draw(){
		background(255);
		move();
		display();
	}
	
	public void display(){
		fill(c);
		rect(x,y,30,10);
	}
	
	public void move(){
		if(x > width){
			x = -30;
		}
		x=x+speed;
	}
		
}
