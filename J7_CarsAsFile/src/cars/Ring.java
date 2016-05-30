package cars;

import java.awt.Color;

import processing.core.PApplet;

//An expanding Ring
public class Ring {
    private Color c;
	private float x;
	private float y;
	private float diam;
	PApplet p;
	
	public Ring(PApplet p, Color newC, float newX, float newY){
		c = newC;
		x = newX;
		y = newY;
		diam = 10;
	}
	
	public void update(){
		diam = diam + 1;
	}
	
	public void display(){
		p.strokeWeight(10);
		p.noFill();
		p.stroke(c.getRed(), c.getGreen(), c.getBlue(), 50f);
		p.ellipse(x,y,diam,diam);
	}
	
  //public void setDiameter(float newD){
  // 	diam = newD;
  //}
	
 	public float getDiam(){
 		return diam;
 	}
	
}
