package cars;

import java.awt.Color;

import processing.core.PApplet;

public class Ball {
	private float x;
	private float y;
	private float vx;
	private float vy;
	private float size;
	private Color color;
	PApplet p;
	
	public Ball(PApplet np,float nx, float ny, float nsize, Color c){
		p = np;
		x = nx;
		y = ny;
		size = nsize;
		color = c;
		
		vx = p.random(-3,3);
		vy = p.random(-3,3);
	}
	
	public void update(){
		x = x + vx;
		y = y + vy;
		
		if(x > p.width || x < 0){
			vx = -vx;
		}
		
		if(y > p.height || y < 0){
			vy = -vy;
		}
	}
	
	public void paint(){
		p.noStroke();
		p.fill(color.getRed(), color.getGreen(), color.getBlue());
		p.ellipse(x, y, size, size);
	}
	
}

