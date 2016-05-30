
package breakout;

import java.awt.Color;
import processing.core.PApplet;

public class Rectangle {

    PApplet p;
	private float x;
	private float y;
	private float width;
	private float height;
	private Color innerColor;
	
	public Rectangle(PApplet tempP, float tempX, float tempY, float tempW, float tempH){
		p = tempP;
		x = tempX;
		y = tempY;
		width = tempW;
		height = tempH;
		innerColor = new Color(255,255,255);
	}
	
	public void paint(){
		p.stroke(0);
		p.strokeWeight(3);
	    p.fill(innerColor.getRed(),innerColor.getGreen(),innerColor.getBlue()); // set the color before we draw...
	    p.rect(x,y,width,height); // use the parameters we are storing! 
	}
	
	public void setX(float newX){
	    x = newX;
	}
	
	public void setY(float newY){
	    y = newY;
	}
	
	public void setWidth(float newW){
	    width = newW;
	}
	
	public void setHeight(float newH){
	    height = newH;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public float getWidth(){
		return width;
	}
	
	public float getHeight(){
		return height;
	}
	
	public Color getColor(){
		return innerColor;
	}
}


