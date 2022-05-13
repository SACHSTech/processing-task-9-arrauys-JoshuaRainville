import processing.core.PApplet;

public class Sketch extends PApplet {
  
  float playerX = 250;
  float playerY = 250;
  int playerLives = 3;
	float[] circleY = new float[25];
  boolean[] SnowAppearance = new boolean[25];
  
  public void settings() {
	
    size(500, 500);
    for (int i = 0; i < circleY.length; i++) {
    circleY[i] = random(height);
    SnowAppearance[i] = true;
  }
  }

  public void setup() {
    background(0);
  }

  public void draw() {

    //Makes player appear to the center of the screen
    background(255);
    fill(0, 0, 255);
    ellipse(playerX, playerY, 25, 25);
    for (int i = 0; i < circleY.length; i++) {
    float circleX = width * i / circleY.length;
    if (SnowAppearance[i]) {
      fill(0);
      ellipse(circleX, circleY[i], 25, 25);
    }

    circleY[i]++;

    if (circleY[i] > height) {
      circleY[i] = 0;
    }

    //Life System - When player hits "snow", lose a life      
    if (playerX >= circleX - 15 && playerX <= circleX + 15 && playerY >= circleY[i] - 15 && playerY <= circleY[i] + 15 && SnowAppearance[i])
    {
      playerLives = playerLives - 1;
      SnowAppearance[i] = false;
    }

    //When the cursor is on the snow and clicked, the snow disappears 
    if (mouseX >= circleX - 15 && mouseX <= circleX + 15 && mouseY >= circleY[i] - 15 && mouseY <= circleY[i] + 15 && SnowAppearance[i] && mousePressed == true){
      SnowAppearance[i] = false;
    }

    //When up arrow is pressed, stop snow.  When down arrow is pressed, speed up snow
    if (keyPressed) {
      
      if (keyCode == UP){
        circleY[i] = circleY[i] - 1;
      }
      if (keyCode == DOWN){
        circleY[i] = circleY[i] + 3;
      }
    }
  }

    
    //3 Lives, when hit by snow, decrease by one
    if (playerLives >= 3) {
      fill(255,0,0);
      rect(440, 15, 50, 50);
      rect(380, 15, 50, 50);
      rect(320, 15, 50, 50);
    }
    if (playerLives == 2) {
      fill(255,0,0);
      rect(440, 15, 50, 50);
      rect(380, 15, 50, 50);
    }
    if (playerLives == 1) {
      fill(255,0,0);
      rect(440, 15, 50, 50);
    }
    if (playerLives < 1) {
      background(255, 255, 255);
    }
    
    
  }

  /**
  *When key is pressed 
  *Move the circle to indicated spot
  *
  *@param1 playerY moves the circle on the Y axis
  *@param2 playerX moves the circle on the X axis
  */
  public void keyPressed() {
    if (key == 'w'){
      playerY -= 5;
    }
    if (key == 's'){
      playerY += 5;
    }
    if (key == 'a'){
      playerX -= 5;
    }
    if (key == 'd'){
      playerX += 5;
    }
    
  }
  
  
}