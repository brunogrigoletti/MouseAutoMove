import java.awt.*;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MouseAutoMove {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Cheese");
        ImageIcon icon = new ImageIcon("Cheese.png");
        frame.setIconImage(icon.getImage());

        JLabel label = new JLabel("Mouse will move every 2 minutes!", SwingConstants.CENTER);
        frame.add(label);

        frame.setVisible(true);

        try {
            Robot robot = new Robot();

            while (true) {
                Point currentPosition = MouseInfo.getPointerInfo().getLocation();
                int newX = currentPosition.x + 10;
                int newY = currentPosition.y + 10;

                robot.mouseMove(newX, newY);
                
                TimeUnit.MINUTES.sleep(2);
            }
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}