import java.awt.*;

public class Snake {
    private final int[] x = new int[GamePanel.GAME_UNITS];
    private final int[] y = new int[GamePanel.GAME_UNITS];
    private int bodyParts = 6;
    private char direction = 'R';
    
    public Snake() {
        // Initialize snake position
        for (int i = 0; i < bodyParts; i++) {
            x[i] = 100 - i * GamePanel.UNIT_SIZE;
            y[i] = 100;
        }
    }
    
    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        
        switch (direction) {
            case 'U':
                y[0] = y[0] - GamePanel.UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + GamePanel.UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - GamePanel.UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + GamePanel.UNIT_SIZE;
                break;
        }
    }
    
    public void grow() {
        bodyParts++;
    }
    
    public void draw(Graphics g) {
        for (int i = 0; i < bodyParts; i++) {
            if (i == 0) {
                g.setColor(Color.green);
            } else {
                g.setColor(new Color(45, 180, 0));
            }
            g.fillRect(x[i], y[i], GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
        }
    }
    
    public boolean checkSelfCollision() {
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkWallCollision(int screenWidth, int screenHeight) {
        return x[0] < 0 || x[0] >= screenWidth || y[0] < 0 || y[0] >= screenHeight;
    }
    
    public boolean eatApple(int appleX, int appleY) {
        return (x[0] == appleX) && (y[0] == appleY);
    }
    
    // Getters and Setters
    public int[] getX() {
        return x;
    }
    
    public int[] getY() {
        return y;
    }
    
    public int getBodyParts() {
        return bodyParts;
    }
    
    public void setDirection(char direction) {
        this.direction = direction;
    }
    
    public char getDirection() {
        return direction;
    }
}