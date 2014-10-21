static final int count = 100;
Particle[] suzy = new Particle[count];
void setup() {
	size(600,600);
	background(0);
	
	for (int i = 0; i<count; i++) {
		suzy[i] = new NormalParticle();
	}
	suzy[0] = new OddballParticle();
	suzy[1] = new JumboParticle();

	
}
void draw() {
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
		angle+=0.02;

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


