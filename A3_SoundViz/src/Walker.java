
import ddf.minim.*;
import ddf.minim.analysis.*;

import processing.core.PApplet;

public class Walker extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Walker");
	}




	int density = 20; //How close together grid points are.
	int numLines = 50;

	Minim minim;
	AudioPlayer player;


	Point[][] grid;
	Line[] lines;

	public void settings(){
		size(800,600);
	}
	
	public void setup(){
		//size(1500,900);
		
		background(0);

		//createGUI(); 

		createGrid();
		createLines();

		minim = new Minim(this);
		player = minim.loadFile("assets/Divinity Roxx -We Are.mp3",numLines*4);
		player.play();
	}

	public void draw(){
		//fade();
		//background(0);

		updateLines();
		updateCircle();


		//strokeWeight(millis()/2000);
	}


	public void createGrid(){
		grid = new Point[width/density][height/density];

		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				grid[i][j] = new Point((density/2)+i*density,(density/2)+j*density);
			}
		}
	}

	public void createLines(){
		lines = new Line[numLines];
		for(int n = 0; n < lines.length; n++){
			lines[n] = new Line(grid);
		}
	}

	public void fade(){
		fill(0,50);
		noStroke();
		rect(-1,-1, width+5, height+5);
	}

	public void updateLines(){
		for(int i = 0; i < player.bufferSize()/4 - 1; i++)
		{
			float weight = (player.mix.get(i)+1)*20;
			strokeWeight(weight);
			lines[i].paint();
			if(weight > 25){
				lines[i].nextStop();
			}
			//println(player.mix.level());
		}

		float t = map(millis(), 0, 197000, 0, 255);
		for(int n = 0; n < lines.length; n++){
			lines[n].darken(t);
		}
	}

	public void updateCircle(){
		float d = map(player.mix.level(), 0, 1, 0, 300) + millis()/250; 

		fill((millis()/20)%255,120,256-(millis()/20)%255,75);
		noStroke();
		ellipse(width/2,height/2,d,d);
	}

	class Line{
		Point loc1;
		Point loc2;
		int r, c;
		Point[][] world;
		int col; //original color
		int drawCol; //color to be drawn

		Line(Point[][] grid){
			world = grid;
			r = (int)random(0,grid.length-1);
			c = (int)random(0,grid[0].length-1);
			loc1 = world[r][c];
			r = r+(int)random(-1,2);
			c = c+(int)random(-1,2);
			loc2 = world[r][c];
			col = color(random(256),random(256),random(256));

		}

		void nextStop(){
			loc1 = loc2;
			r = r+(int)random(-2,2);
			c = c+(int)random(-2,2);
			if(r >= world.length) r--;
			if(c >= world[0].length) c--;
			if(r < 0) r++;
			if(c < 0) c++;
			loc2 = world[r][c];
		}

		void paint(){
			stroke(drawCol);
			line(loc1.getX(),loc1.getY(),loc2.getX(),loc2.getY());
		}

		void setColor(int newCol){
			col = newCol;
		}

		void darken(float time){

			float red = red(col)-time;
			if(red < 0) red = 0;
			float green = green(col)-time;
			if(green < 0) green = 0;
			float blue = blue(col)-time;
			if(blue < 0) blue = 0;

			drawCol = color(red, green, blue);
		}

	}

	class Point{

		int x;
		int y;

		Point(int nx, int ny){
			x = nx;
			y = ny;
		}

		int getX(){
			return x;
		}

		int getY(){
			return y;
		}


	}
}
