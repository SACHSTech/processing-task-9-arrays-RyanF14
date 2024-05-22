import processing.core.PApplet;


public class Sketch extends PApplet {
float PLRcircleX = 150;
float PLRcirclevelX;	
float PLRcircleY = 200;
float PLRcirclevelY;
float circleX;
boolean up = false;
boolean down = false;
boolean left = false;
boolean right = false;
boolean speedup = false;
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
    circleX = width * i / circleY.length;
    ellipse(circleX, circleY[i], 25, 25);
    if(speedup == true){
      circleY[(i*2) /4 ]++;
    }
    else{
    circleY[i] ++;
    }
    if (circleY[i] > height) {
      circleY[i] = 0;
    }
    }
  }
  
      public void keyPressed() {
        if (key == 'w') {
          up = true;
        }
        else if (key == 's') {
          down = true;
        }
        else if (key == 'a') {
          left = true;
        }
        else if (key == 'd') {
          right = true;
        }
        else if (keyCode == DOWN){
          speedup = true;
        }
      }
      public void keyReleased() {
        if (key == 'w') {
          up = false;
        }
        else if (key == 's') {
          down = false;
        }
        else if (key == 'a') {
          left = false;
        }
        else if (key == 'd') {
          right = false;
        }
        else if(keyCode == DOWN){
          speedup = false;
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

