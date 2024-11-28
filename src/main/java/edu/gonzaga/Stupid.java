import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.*;

public class Stupid{

    public static void main(String[] args) {

        JFrame mainWindowFrame = new JFrame("Button Example with Listener");
        mainWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon apple  = new ImageIcon("./apple.png");
        mainWindowFrame.setIconImage(apple.getImage());

        BufferedImage applePic;
        JLabel picLabel = null;
        try {
            applePic = ImageIO.read(new File("./apple.png"));
            picLabel = new JLabel(new ImageIcon(applePic));
            picLabel.setBounds(50, 130, 100, 150);                 
            picLabel.setVisible(false);
        } catch(IOException e) {
            e.printStackTrace();
        }

        mainWindowFrame.setVisible(true);
        mainWindowFrame.setSize(400, 400);
        mainWindowFrame.setLayout(null);
    }
}