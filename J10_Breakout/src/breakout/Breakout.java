package breakout;

import java.awt.Color;
import java.util.ArrayList;

import processing.core.PApplet;


public class Breakout extends PApplet {
    
	public static void main(String[] args){
		PApplet.main("breakout.Breakout");
	}
	
	public ArrayList<Rectangle> bricks = new ArrayList<Rectangle>();
	public Ball ball;
	public Rectangle paddle;
	
	public void settings(){
		size(400,600);
	}
	
	public void setup() {
		background(0);
		ball = new Ball(this, 200,300,20,Color.GREEN);
		addBricks();
		paddle = new Rectangle(this, 200, 550, 60, 20);
	}

	public void draw() {
		fill(0,0,0,15);
		rect(0,0,width,height);
		drawBricks();
		ball.update();
		ball.paint();
		updatePaddle();
		updateGame();
	}
	
	private void addBricks(){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				bricks.add(new Rectangle(this, 40*i, 100+15*j, 40, 15));
			}
		}
	}
	
	private void drawBricks(){
		for(int i = 0; i < bricks.size(); i++){
			bricks.get(i).paint();
		}
	}
	
	private void updatePaddle(){
		paddle.setX(mouseX - 30);
		paddle.paint();
	}
	
	private void updateGame(){
		//check if ball hits paddle
		if(ball.getX() > paddle.getX()  
		  && ball.getX() < paddle.getX() + 60 
		  && ball.getY() + ball.getSize()/2 > paddle.getY()){
				
			ball.setVelocity(ball.getVX(), -ball.getVY());
		}
		
		//check if ball hits a brick
		for(int i = 0; i < bricks.size(); i++){
			Rectangle b = bricks.get(i);
			if((ball.getX()+(ball.getSize()/2)) > b.getX()  
			  && (ball.getX()+(ball.getSize()/2)) < b.getX() + b.getWidth()
			  && ball.getY() < (b.getY()+b.getHeight())){
				ball.setVelocity(ball.getVX(), -ball.getVY());
				bricks.remove(b);
			}
			//ADVANCED: Add another if to check the bottom of the ball
		}
		
		//check if you lost
		if(ball.getY() > height -10){
			background(0); //erase everything
			text("you lost", width/2, height/2);
			ball.setVelocity(0, 0); //stop the ball so the game will stop
		}
	}
}