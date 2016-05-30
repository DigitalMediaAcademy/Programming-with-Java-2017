package mania;

import java.awt.Color;
import java.util.ArrayList;
import processing.core.PApplet;

public class BallMania extends PApplet {

	public static void main(String[] args){
		PApplet.main("mania.BallMania");
	}
    
	//Ball[] b;
	ArrayList<Ball> b = new ArrayList<Ball>();
	
	public void settings(){
		size(400,400);
	}
	
	public void setup() {
		background(0);

		//b= new Ball[20];
		//for(int i =0; i < b.length; i++){
			//b[i] = new Ball(this, 200,200,10, Color.GREEN );
		for(int i =0; i < 20; i++){
			b.add(new Ball(this, 200,200,10, Color.GREEN ));
		}
	}

	public void draw() {
		fill(0,0,0,15);
		noStroke();
		rect(0,0,width,height);
		//for(int i =0; i < b.length; i++){
		for(int i = 0; i < b.size(); i++){
			b.get(i).update();
			b.get(i).paint();
		}
		if(mousePressed == true){
		    b.add(new Ball(this, 200,200,10, Color.GREEN ));
		}
	}
}
