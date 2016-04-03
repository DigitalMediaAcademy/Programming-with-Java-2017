
In order to use the Processing library to create our graphics while coding in Eclipse, we need to do a couple things. The first thing we need to do is import the Processing core as a library for our project, and the second is to set up our client class to take into consideration some of the processes (pun intended) that the Processing IDE does for us in the background. 

This guide is written for Processing 3+, with the intended audience of someone who has already downloaded [Eclipse](http://www.eclipse.org/), but may have never used it before. If you are experienced with Java and Eclipse, you can jump to the bottom for a quick summary of the steps involved.

### Create a new Project

First create a new project. It just needs to be a regular Java Project. 

*File > New > Java Project*  

Let's name it '**Hello Processing**'. Leave all the default settings and click *Finish*.

Next, create a new class.

*File > New > Class*

Let's name it '*UsingProcessing*'. You can choose to **include public static void main**.

![Creating a new Class](https://lh6.googleusercontent.com/g-96GDmlwXcrgt4RD1bnEtQ4Tnix5MNctJrhxAf5ssKOJxzO-nevUqAxrCfoX4r7GtTdT6qgWO_irn9uwncQcXqZdoAyPnZmfWH4JKaVgCMDp9f5sPnBfX1eHwDU_KTbUsiaZ5wK)

We should now have a new class that probably looks like this:
```
public class UsingProcessing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
```
Now that we have our project and client class ready to go, we need to get the Processing core as a library.

###The idea of Libraries
One of the most important aspects of Java (or nearly any programming environment) is the idea of a **Library**. A Library is a collection of code that performs related tasks. They can be one class, or many. Some Libraries are so powerful and robust that they can almost be considered a "Language" themselves. When you combine the Processing library with the Processing IDE, you end up with something that most people refer to as the Processing 'Language', but *technically*, at it's heart, it's a collection of Java code.

To make it work, the Processing IDE does a lot of stuff for us in the background 'Java' environment in order to make it really easy for us as programmers to create sketches. However, to make full use of all the Java awesomeness at our disposal, it's helpful to use a more robust IDE, which is why we are jumping into Eclipse. So let's get Eclipse to use Processing as a Library.

###Import the Processing Core
In order for Eclipse to see the code that makes up Processing, we need to import it into our project.

*File > Import > General > File System* 

Click next. On Windows, click "Browse..." and select the Processing jar files inside PATH_TO_PROCESSING/core/library/. On OS X, do not use the "Browse..." button. Instead, use the "From directory:" field to manually enter the path to Processing's jar files, which is typically /Applications/Processing 3.app/Contents/Java/core/library/. At minimum, select the "core.jar" file inside the "library" folder.

![Importing the Processing Core](https://lh3.googleusercontent.com/WNEgH6J2tmGGaJLPu7447zguphMPAs9VnPWNPWHTT_scwXQOOZbVMvduqLKZhpmhc4fO3ohTe9657QMsGhKHmIOFJp-ua4K4c6l_BiE4vjLto_Zo2wWgDRrDyvbdg1vDEqbVjjxM) 

A .jar file is a compiled collection of Java code. The core.jar is the core of the Processing libraries, it has all the code that does the stuff that we are used to doing in Processing, like drawing shapes. Once we have it, we can make use of all the normal Processing commands that are found on the [reference page](https://processing.org/reference/).

Click Finish. If you look at the Package Explorer, you'll notice that there is a new file in our project, called 'core.jar'.

![A new file in our project!](https://lh3.googleusercontent.com/vI2NXJ8QcKdKB4tWRgKouCwKh5SatSCsleNhGFTB60cfoc-N61J6_zTTQKoIz79YFsbxeNqHO0tDael2HFpRYT6yJVJqW21DcaN6t9yxJUwGU_NANCrHe2bJ6cOsTqyCF8PpjiI1)

Now that we have the file in our project, we need to tell Eclipse that this file is part of the code base that is used to build, or compile and run, this project. Do this by right clicking on the core.jar, going to *Build Path*, and then *Add to Build Path*

![Adding the core.jar to the build path](https://lh5.googleusercontent.com/q5FntSptm_LieD4BR5gha47DE9FFKe1bgtUq1bYEu-b-8zC62PZYD6KM5gWI05rMkQfunu-3o6mXeBZl3tpjtgZw8cwP2Nx8FiuOqWjhFD7UeYZLekFsmEA3Tu04tgGDEU0OyUUk)

You'll notice the project will expand to have a new section called 'Referenced Libraries', where there is a new core.jar file. You can expand this to see a hierarchy of it's contents, if you are really interested.

![A successful add to build path](https://lh4.googleusercontent.com/QAx5CoiNskouGcckM2juqPkv4Ju3-eA7xTXs4n-bZOqapKQ5qhbSMalZckhU3z4mAVkmkYQTwEZFqbOGLQi75wltGoY6LE99m-dwzGenQiXOXkxJWbR64t4nVhsEdmJSE60nrNTa)

We are finally ready to set up our client class (the class with our **main** function, where the program starts), to run the project like a Processing sketch. 

###Setting up the Client Class

A Processing window is a special type of Java program called a PApplet. This is technically a Java Class, which has its own main function (or method) and does all kinds of fancy stuff that we don't need to worry about to create a new window and draw graphics onto it. In order for us to make use of the PApplet class, we want our program to BE a PApplet. To make this happen, we use the keyword **extends** in our class declaration. This will allow our class to 'inherit' all the PApplet class' functions and variables. Change the first line of code to be:
```
public class UsingProcessing extends PApplet{
```
You'll notice this will give you an error. This occurs because, although we have included the core.jar to our project, we still have to link to the library in the code. We do this by using an import statement, at the top of the Java file. Anytime we are going to reference a function, variable, or class outside of the Java file we are writing in, we need to tell Java where it is by *importing* it. Eclipse will help you by suggesting to do this. Hover over the error (where it's underlined in red) and choose from the options "Import 'PApplet' (processing.core)".

![Import PApplet](https://lh5.googleusercontent.com/NkrxHJiG3i3WMWyggiv3jPwiPPYOS8u21MTUBCWL-XD1v3eXGuMoBmjmS4bi5GCmoEoy0w-XRUUfeIKF3FPHfNjTQoi1KEBHrlawCOSHmYNNqISeMk2V0CdnsxI9anvahphuqmSm)

This will auto add a new line of code to the top of the file: `import processing.core.PApplet;` You can also type this in yourself if you choose. This will allow Java to see all the public parts of the PApplet class.

The next step is to simply start a PApplet application, and tell it to use *this* class, `UsingProcessing`, as the program to run. This is done by calling PApplet's main method and giving it the name of this class as a parameter.

Add the following line to the main function (method), and if the TODO comment is still there, you can delete/replace it.
```
PApplet.main("UsingProcessing");
```
Your entire Java file should now look like:
```
import processing.core.PApplet;

public class UsingProcessing extends PApplet{

	public static void main(String[] args) {
		PApplet.main("UsingProcessing");

	}

}
```
At this point, you can run the program. If Eclipse asks, choose to run the program as a **Java Application**. Processing no longer extends the Applet class, so you can't run it as an Applet! 

This will run a PApplet as if you had run an empty sketch. You will get a new 100x100 window open with a blank canvas!

Now we are ready to add the final touches to be ready to program like we were before. After main(), add three new functions: `settings()`, `setup()`, and `draw()`. It's just like we did in Processing, but you will also need to include the `public` declaration before the `void` declaration. Now we have this:
```
import processing.core.PApplet;

public class UsingProcessing extends PApplet{

	public static void main(String[] args) {
		PApplet.main("UsingProcessing");
	}
	
	public void settings(){
		
	}
	
	public void setup(){
		
	}
	
	public void draw(){
		
	}

}
```
`setup()` and `draw()` should look familiar, and they work exactly the same way as they did in the Processing IDE. The only new concession we have to make is that when we use the `size()` function to set the size of the screen, we put that in `settings()`, and we put it first. `settings()` runs before anything else happens, so we can't use any other Processing functions in it, except to set the size of the screen. More information [here](https://processing.org/reference/settings_.html).

Let's try it. Set a size in `settings()`, set a color in `setup()`, and draw some stuff in `draw()`. For example:
```
import processing.core.PApplet;

public class UsingProcessing extends PApplet{

	public static void main(String[] args) {
		PApplet.main("UsingProcessing");
	}
	
	public void settings(){
		size(300,300);
	}
	
	public void setup(){
		fill(120,50,240);
	}
	
	public void draw(){
		ellipse(width/2,height/2,second(),second());
	}

}
```
We did it! We have a Processing application running from Eclipse, and now we can take advantage of all the powerful tools that Eclipse has to offer. From here, you can develop your processing sketch to your heart's content.

### TL:DR

The quick break down of what we did here:  
  
1. Create a new Java Project  
2. Import the Processing core.jar from where your Processing is installed. Add it to the build path.  
3. Create a new class, and extend PApplet. Import the PApplet from `processing.core.PApplet`  
4. In `main()`, call `PApplet.main("YouClassName");`  
5. Add a `public void settings()`, `public void setup()`, and `public void draw()`.   
6. Use the `size()` call inside of `settings()`, and other than that, use `setup()` and `draw()` like normal!  
  

![It runs!](https://lh4.googleusercontent.com/Pvh6AMgApjVED0T67EwRo1cLXfgYv1Zf7RzXzJby3Y0ZZyztDTby-DvM_cmsoQ4x0rN_41CSiQuQRg-spcS3SEOa6kkwcD7S6BXs4f9QBVaBCbcBoLXmQ6CA9MMuIEs-e0E_FUmF)
