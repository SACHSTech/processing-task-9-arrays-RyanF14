import processing.core.PApplet;


public class Sketch extends PApplet {
int snowamount = 15;
float PLRcircleX = -5;
float PLRcirclevelX;	
float PLRcircleY = 280;
int snowCount = 15;
float PLRcirclevelY;
float[] circleSPEED = new float[15];
float[] circleX = new float[15];
float[] circleY = new float[15];
boolean[] snowhide = new boolean[15];
int health = 3;
boolean up = false;
boolean down = false;
boolean left = false;
boolean right = false;
boolean speedup = false;
boolean collision = false;
	
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
        circleX[i] = random(width);
        circleSPEED[i] = random(1,2);
        


    
    for ( i = 0; i < snowCount; i++) {
      circleY[i] = random(height);
      circleX[i] = random(width);
      circleSPEED[i] = random(1,2);
      snowhide[i] = false;


  }
}
 
  }

  /**
   * Main process which handles what is drawn to the screen, also determines collision detection with objects on screen and the number of lives remaining
   */
  public void draw() {
   
    
    background(50);
    printLives();
    fill(0, 150, 150);
    ellipse(PLRcircleX, PLRcircleY, 10, 10);
    movement();

  for (int i = 0; i < circleY.length; i++) {
    
    
    
     
    if(!snowhide[i]){
      mouseClicked();
      fill(255, 255, 255);
      ellipse(circleX[i], circleY[i], 20, 20);
      

// Check if player collides with snowflakes
if(dist(PLRcircleX, PLRcircleY, circleX[i], circleY[i]) < 20 && !collision){
  

  
    if(health > 0){
      health --;
      resetPlayer();
      collision = true;
    }
  }

}

      circleY[i] += circleSPEED[i];
      circleY[i] += circleSPEED[i];
      if(circleY[i] > 400){
        circleY[i] = 0;
        circleX[i] = random(width);
        
      }
      if(collision){
        collision = false;
      }
      if(health <= 0){
        background(0,0,0);
        textSize(50);
        text(":(", 150, 150);
        break;
      }
      
      
    }
    }
  
  /**
   * Determines if a usable key is pressed
   */
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
        if(keyCode == DOWN){
          for(int i = 0; i < snowamount; i++){
            circleSPEED[i] *= 2;
            
          }
        }
          else if(keyCode == UP){
             for(int i = 0; i < snowamount; i++){
            circleSPEED[i] /= 2;
          }
          }
    }
      /**
       * determines if a usable key is released
       */
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
    /**
     * using the values defined by keypressed and keyreleased, this method handles the player movement
     */
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
    /**
     * Resets the position of the player character to its starting value after death, or at the start of the game
     */
    public void resetPlayer(){
     PLRcircleX = -5;
    
    PLRcircleY = 280;
    }
    /**
     * This method handles mouse input, specifically making the snowballs dissappear when the item is clicked on by the user
     */
    public void mouseClicked(){
      for(int i = 0; i < snowamount; i++){
       
          if(!snowhide[i] && dist(mouseX, mouseY, circleX[i], circleY[i]) < 10){
                if(mousePressed){
                  snowhide[i] = true;
                }
  }
  
  }      
    }
    /**
     * prints the number of lives remaining to the top right of the screena
     */
    public void printLives(){
      for(int i = 0; i < health; i++){
        fill(255, 23,23);
        textSize(20);
        text(health, width - 20, 20);
      }
    }
}

