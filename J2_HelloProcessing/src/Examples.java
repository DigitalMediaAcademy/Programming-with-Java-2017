import processing.core.PApplet;

public class Examples extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Examples");
	}
	
	public void settings(){
		size(500,500);
	}
	
//	public void setup(){
//		background(0);
//		strokeWeight(5);
//	}
//	
//
//	
//	public void draw(){
//		stroke(mouseX/2, mouseY/2, 150);
//		if(mousePressed == true){
//			line(mouseX,mouseY, width - mouseX, height - mouseY);
//		}
//	}
	
	/*  Example 2: Challenge! Uncomment this Setup function and 
	 * comment out the other setup() and Draw()!!   
	 */
	public void setup(){
		background(0);
		stroke(255);
		
		for(int i = 0; i < 50 ; i++){
			fill(i*5,255-i*5,i*12);
			ellipse(width/2, height/2, width-i*10, height - i*10);
		}
	}

}
