import processing.core.PApplet;

public class CheckForUnderstanding extends PApplet{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("CheckForUnderstanding");
	}
	
	public void settings(){
		size(500,500);
	}
	
	public void setup(){
		background(0);
	}
	
	public void draw(){
		stroke(mouseX/2, mouseY/2, 150);
		if(mousePressed == true){
			face(mouseX,mouseY);
		}
	}
	
	public void face(float x, float y){
		fill(250,200,190);
	    ellipse(x,y,100,100);
		fill(45,210,90);
	    ellipse(x-20,y-20,15,15);
	    ellipse(x+20,y-20,15,15);
		fill(0,0,0,100);
	    ellipse(x,y+20,40,15);
	}
	
	
}
