import java.awt.*;

public class Food {
    private int x;
    private int y;
    
    public Food() {
        generateNewPosition();
    }
    
    public void generateNewPosition() {
        x = (int) (Math.random() * (GamePanel.SCREEN_WIDTH / GamePanel.UNIT_SIZE)) * GamePanel.UNIT_SIZE;
        y = (int) (Math.random() * (GamePanel.SCREEN_HEIGHT / GamePanel.UNIT_SIZE)) * GamePanel.UNIT_SIZE;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x, y, GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
    }
    
    // Getters
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}