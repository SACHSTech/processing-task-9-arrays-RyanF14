import processing.core.PApplet;


public class Sketch extends PApplet {
float PLRcircleX = 150;
float PLRcirclevelX;	
float PLRcircleY = 200;
float PLRcirclevelY;
boolean up = false;
boolean down = false;
boolean left = false;
boolean right = false;
	float[] circleY = new float[25];
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(300, 300);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
 
    
      for (int i = 0; i < circleY.length; i++) {
        circleY[i] = random(height);

    }
  }

  
  public void draw() {
    
    background(50);
    ellipse(PLRcircleX, PLRcircleY, 10, 10);
    movement();

  for (int i = 0; i < circleY.length; i++) {
    float circleX = width * i / circleY.length;
    ellipse(circleX, circleY[i], 25, 25);

    circleY[i] ++;

    if (circleY[i] > height) {
      circleY[i] = 0;
    }
    }
  }
  
      public void keyPressed() {
        if (keyCode == UP) {
          up = true;
        }
        else if (keyCode == DOWN) {
          down = true;
        }
        else if (keyCode == LEFT) {
          left = true;
        }
        else if (keyCode == RIGHT) {
          right = true;
        }
      }
      public void keyReleased() {
        if (keyCode == UP) {
          up = false;
        }
        else if (keyCode == DOWN) {
          down = false;
        }
        else if (keyCode == LEFT) {
          left = false;
        }
        else if (keyCode == RIGHT) {
          right = false;
        }
    }
    public void movement(){
      if (up) {
        PLRcircleY--;
      }
    
      
      if (down) {
        PLRcircleY++;
      }
      
      if (left) {
        PLRcircleX--;
      }
      
      if (right) {
        PLRcircleX++;
      }
    }
  }

