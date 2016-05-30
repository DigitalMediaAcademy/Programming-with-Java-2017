import java.awt.Color;
import processing.core.PApplet;

public class Shapes extends PApplet{

	public static void main(String[] args) {
		PApplet.main("Shapes");
	}
	
	Ring r;
    Ball b;
    
    public void settings(){
    	size(400,400);
    }
    
	public void setup() {
		background(0);
		
		r = new Ring(Color.BLUE, 200,200);
		b = new Ball(200,200,10, Color.GREEN );
	}

	public void draw() {
		fill(0,0,0,15);
		noStroke();
		rect(0,0,width,height);
		r.update();
		r.display();
		b.update();
		b.paint();
		
		if(r.getDiam() > 400){ //will need to uncomment or create a getDiam() function.
			r = new Ring(new Color((int)random(0,255),(int)random(0,255),(int)random(0,255)), random(400),random(400));
		}
		else if(mousePressed == true){
			r = new Ring(new Color((int)random(0,255),(int)random(0,255),(int)random(0,255)), mouseX,mouseY);
		}
	}
    
	//A Ball Class
	public class Ball {
	    
		private float x;
		private float y;
		private float vx;
		private float vy;
		private float size;
		private Color color;
		
		public Ball(float nx, float ny, float nsize, Color c){
			x = nx;
			y = ny;
			size = nsize;
			color = c;
			
			vx = random(-3,3);
			vy = random(-3,3);
		}
		
		public void update(){
			x = x + vx;
			y = y + vy;
			
			if(x > width || x < 0){
				vx = -vx;
			}
			
			if(y > height || y < 0){
				vy = -vy;
			}
		}
		
		public void paint(){
			noStroke();
			fill(color.getRed(), color.getGreen(), color.getBlue());
			ellipse(x, y, size, size);
		}
		
	}
	
	//An expanding Ring
	public class Ring {
	    private Color c;
		private float x;
		private float y;
		private float diam;
		
		public Ring(Color newC, float newX, float newY){
			c = newC;
			x = newX;
			y = newY;
			diam = 10;
		}
		
		public void update(){
			diam = diam + 1;
		}
		
		public void display(){
			strokeWeight(10);
			noFill();
			stroke(c.getRed(), c.getGreen(), c.getBlue(), 50f);
			ellipse(x,y,diam,diam);
		}
		
	  //public void setDiameter(float newD){
	  // 	diam = newD;
	  //}
		
	 	public float getDiam(){
	 		return diam;
	 	}
		
	}

}