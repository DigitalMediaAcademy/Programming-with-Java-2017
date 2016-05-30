import processing.core.PApplet;

public class UsingProcessing extends PApplet{

	//PApplet is NOT an applet, so you must run as an Application, using main()
	public static void main(String[] args) {
		//Simply call the main() of PApplet, using this class name as a parameter
		PApplet.main("UsingProcessing");
	}
	
	// To use the size() function, create a function called settings(), and call size() within it
	public void settings(){
		size(500,500);
	}
	
	//setup() and draw() now work the same as they did in the Processing IDE
	public void setup(){
		stroke(255);
		background(0);
	}
	
	// As an example, we can draw an ellipse with the diameters equal to the current second of the
	// currant time. Or, draw a line from pmouseX/Y to mouseX/Y
	public void draw(){
		//ellipse(width/2,height/2,second(),second());
		if(mousePressed){
			line(pmouseX,pmouseY,mouseX,mouseY);
		}
		
	}

}