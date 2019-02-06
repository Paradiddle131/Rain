import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Rain extends PApplet {

//138,43,226
//230,230,250

Drop[] drops = new Drop[1200];

public void settings() {  
	size(1420, 1080);   
	  //fullScreen(P2D);
}

public void setup() {

  for (int i=0; i<drops.length; i++) {
    drops[i]=new Drop();
  }
}


public void draw() {
  background(230, 230, 250);
  for (int i=0; i<drops.length; i++) {
    drops[i].show();
    drops[i].fall();
  }
}
class Drop {
  float x = random(width);
  float y = random(-500, -50);
  float z = random(0, 17);
  float len = map(z, 0, 20, 10, 20); 
  //map the z value arrange btw 10-20,length bt 10-20
  //longer if it's closer, shorter if it's further
  float yspeed = map(z, 0, 20, 1, 20); 
  //closer is faster

  public void fall() {
    y = y + yspeed;
    float gravity = map(z, 0, 20, 0, 0.2f);
    yspeed = yspeed + gravity;

    if (y>height) {
      y=random(-99, -25);
      yspeed = map(z, 0, 20, 4, 10);
    }
  }

  public void show() {
    float thick = map(z, 0, 20, 1, 3);
    strokeWeight(thick);
    stroke(138, 43, 226); //purple
    line(x, y, x, y+len); //xa, xb, ya, yb (coords)
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Rain" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
