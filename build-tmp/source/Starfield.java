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

public class Starfield extends PApplet {

static final int count = 100;
Particle[] suzy = new Particle[count];
public void setup() {
	size(600,600);
	background(0);
	
	for (int i = 0; i<count; i++) {
		suzy[i] = new NormalParticle();
	}
	suzy[0] = new OddballParticle();
	suzy[1] = new JumboParticle();

	
}
public void draw() {
	noStroke();
	fill(0,10);
	rect(0,0,600,600);
	for (int i = 0; i< count; i++) {
		suzy[i].show();
		suzy[i].move();
	}
}
class NormalParticle implements Particle{
	double myX, myY, speed, angle;
	int bleep, mySize;

	NormalParticle() {
		myX = 300;
		myY = 300;
		mySize = 6;
		bleep = color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255),75);
		speed = Math.random()*5;
		angle = Math.random()*7;
	}

	public void show() {
		noStroke();
		fill(bleep);
		ellipse((int)myX, (int)myY, mySize, mySize);
	}

	public void move() {
		myX+= Math.cos(angle)*speed;
		myY+= Math.sin(angle)*speed;
		angle+=0.02f;

	}
}

interface Particle {
	public void show();
	public void move();
}

class OddballParticle implements Particle {
	double myX, myY, speed, angle;
	int bleep;
	
	OddballParticle() {
		myX = 0;
		myY = 300;
		speed = 4;
		angle = (Math.random()*3);
		bleep = color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255), 80);
	}

	public void show() {
		bleep = color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*25)+25);
		noStroke();
		fill(bleep);
		ellipse((int)myX, (int)myY, 10, 10);
	}
	public void move() {
		myX += speed;
		myY += angle;
		if (myX > 600) {
			speed = -2;
		} else if (myX<0) {
			speed = 2;
		}

		if (myY> 600) {
			angle  = (Math.random()*3)-2;
		} else if (myY<0) {
			angle = (Math.random()*3)+2;
		}
	}
}

class JumboParticle extends NormalParticle {

	JumboParticle() {
		mySize = 60;	
	}
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
