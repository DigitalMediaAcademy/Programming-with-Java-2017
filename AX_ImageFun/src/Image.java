import processing.core.PApplet;
import processing.core.PImage;

public class Image extends PApplet{

	public static void main(String[] args) {
		PApplet.main("Image");

	}
	
	PImage img1;
	PImage img2;
	PImage img3;
	PImage img4;
	
	public void settings(){
		size(512, 512);
	}

	public void setup(){
	  img1 = loadImage("images/tiger.png");
	  img2 = loadImage("images/tiger.png");
	  img3 = loadImage("images/tiger.png");
	  img4 = loadImage("images/tiger.png");
	  
	  int num = 0b010111010011 & 0b111100000000;
	  
	  img1.loadPixels();
	  for(int i = 0; i < img1.pixels.length-1; i++) {
	    img1.pixels[i] = img1.pixels[i] & 0xFF0000FF; //only blue
	    img2.pixels[i] = img2.pixels[i] & 0xFF00FF00; //only green
	    img3.pixels[i] = img3.pixels[i] & 0xFFFF0000; //only red
	    img4.pixels[i] = img4.pixels[i] & 0xFFFF00FF; //red and blue
	  }
	  //println(img1.pixels[0]);
	}

	public void draw(){
	  background(255);
	  image(img1,0,0);
	  image(img2,256,0);
	  image(img3,0,256);
	  image(img4,256,256);
//	  
//      float r = red(img1.pixels[0]);
//      float g = green(img1.pixels[0]);
//      float b = blue(img1.pixels[0]);
	  scramble(img1.pixels);
	  //scramble(img2.pixels);
	  //scramble(img3.pixels);
	  //scramble(img4.pixels);
	  
	  //addBlue(img1.pixels);
	  //addBlue(img2.pixels);
	  //addBlue(img3.pixels);
	  //addGreen(img4.pixels);
	 // addGreen(img4.pixels);
	  
	  img1.updatePixels();
	  img2.updatePixels();
	  img3.updatePixels();
	  img4.updatePixels();
	  //println(hex(img1.get(100,100)));
	  
	}

	public void mousePressed(){
	  bubbleSort(img1.pixels);
	  bubbleSort(img2.pixels);
	  bubbleSort(img3.pixels);
	  bubbleSort(img4.pixels);
	  
	}

	public void addBlue(int[] a){
	  for(int i=2; i < a.length-3; i++){
	    a[i]++;
	  }
	}

	void addGreen(int[] a){
	  for(int i=2; i < a.length-3; i++){
	    a[i] += 0x00000100;
	  }
	}

	void addRed(int[] a){
	  for(int i=2; i < a.length-3; i++){
	    a[i] += 0x00010000;
	  }
	}

	void addRedAndBlue(int[] a){
	  for(int i=2; i < a.length-3; i++){
	    a[i] += 0x00010001;
	  }
	}

	void scramble(int[] a){
	  int temp;
	  int j;
	  for(int i=2; i < a.length-3; i++){
	    if(random(1) > 0.95){
	      j = (int)random(i-2, i+2);
	      temp = a[i];
	      a[i] = a[j];
	      a[j] = temp;
	    }
	    //a[i]++;

	  }
	  //println(hex(a[5]));
	}

	void bubbleSort(int[] a){
	  int temp;
	  for(int i=0; i < a.length-1; i++){
	      for(int j=1; j < a.length-i; j++){
	          if(a[j-1] > a[j]){
	              temp=a[j-1];
	              a[j-1] = a[j];
	              a[j] = temp;
	          }
	      }
	  }
	  println("Sorted");
	}

}
