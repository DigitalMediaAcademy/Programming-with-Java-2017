import processing.core.PApplet;

import java.util.ArrayList;

import ddf.minim.*;
import ddf.minim.analysis.*;

public class Analyze extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Analyze");
	}
	
	Minim minim;
	AudioPlayer groove;
	FFT fft;
	boolean go = true;
	String windowName;
	ArrayList<Integer> maxes = new ArrayList<Integer>();

	public void settings(){
		size(1024, 200);
	}
	
	public void setup()
	{
	  windowName = "Rectangular Window";
	  minim = new Minim(this);
	  groove = minim.loadFile("assets/Adrianna_Krikl_-_03_-_Wednesday.mp3", 1024);
	  groove.loop();
	  fft = new FFT(groove.mix.size(),44100);
	  fft.window( FFT.HAMMING );
	  println(fft.specSize());
	}

	public void draw()
	{
	  background(0);
	  text("The window being used is: " + windowName, 5, 20);
	  stroke( 255 );
	  
	  // draw the waveforms
	  // the values returned by left.get() and right.get() will be between -1 and 1,
	  // so we need to scale them up to see the waveform
	  // note that if the file is MONO, left.get() and right.get() will return the same value
	  for(int i = 0; i < groove.bufferSize() - 1; i++)
	  {
	    float x1 = map( i, 0, groove.bufferSize(), 0, width );
	    float x2 = map( i+1, 0, groove.bufferSize(), 0, width );
	    line( x1, 50 + groove.left.get(i)*50, x2, 50 + groove.left.get(i+1)*50 );
	    line( x1, 150 + groove.right.get(i)*50, x2, 150 + groove.right.get(i+1)*50 );
	  }
	  fft.forward(groove.left);
	  //findMaxes();
	  for (int i = 0; i < fft.timeSize(); i++)
	 {
	   //int n = maxes.get(i).intValue();
	   println(fft.getBand(i));
	   // draw the line for frequency band i, scaling it by 4 so we can see it a bit better
	   line(i*2, height, i*2, height - fft.getBand(i) * 4);
	 }
	  
	  noStroke();
	  fill( 255, 128 );
	  
	  // the value returned by the level method is the RMS (root-mean-square) 
	  // value of the current buffer of audio.
	  // see: http://en.wikipedia.org/wiki/Root_mean_square
	  rect( 0, 0, groove.left.level()*width, 100 );
	  rect( 0, 100, groove.right.level()*width, 100 );
	}

	void findMaxes(){
	  
	  maxes.clear();
	  float diff;
	  boolean upTrend = true;
	  
	  for (int i = 0; i < fft.specSize()-1; i++)
	  {
	    diff = fft.getBand(i+1) - fft.getBand(i);
	    if(diff > 0){
	      upTrend = true;
	    }
	    else if(diff < 0 && upTrend == true){
	      if(fft.getBand(i) > 0.25){
	        maxes.add(new Integer(i));
	      }
	      upTrend = false;
	    }
	    
	  }
	}

	public void mousePressed(){
	  if(go){
	    noLoop();
	    groove.pause();
	    
	  }
	  else{
	    loop();
	    groove.play();
	  }
	  go = !go;
	}
	
	public void keyReleased()
	{
	  WindowFunction newWindow = FFT.NONE;
	  
	  if ( key == '1' ) 
	  {
	    newWindow = FFT.BARTLETT;
	  }
	  else if ( key == '2' )
	  {
	    newWindow = FFT.BARTLETTHANN;
	  }
	  else if ( key == '3' )
	  {
	    newWindow = FFT.BLACKMAN;
	  }
	  else if ( key == '4' )
	  {
	    newWindow = FFT.COSINE;
	  }
	  else if ( key == '5' )
	  {
	    newWindow = FFT.GAUSS;
	  }
	  else if ( key == '6' )
	  {
	    newWindow = FFT.HAMMING;
	  }
	  else if ( key == '7' )
	  {
	    newWindow = FFT.HANN;
	  }
	  else if ( key == '8' )
	  {
	    newWindow = FFT.LANCZOS;
	  }
	  else if ( key == '9' )
	  {
	    newWindow = FFT.TRIANGULAR;
	  }

	  fft.window( newWindow );
	  windowName = newWindow.toString();
	}

}
