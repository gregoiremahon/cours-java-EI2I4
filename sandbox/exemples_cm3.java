import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

class MaPremiereFenetre{
    public static void main(String[] args){
        /*JFrame maFenetre = new JFrame("Hello World !");
        maFenetre.setBounds(100, // abs
                            400, // ord
                            300, // larg
                            150); // long 
        maFenetre.getContentPane().add(new JLabel("Hello, World!"));
        maFenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize);
        maFenetre.setLocation(screenSize.width/2 - maFenetre.getWidth()/2, screenSize.height/2 - maFenetre.getHeight()/2);
        maFenetre.setLocationRelativeTo(null);
        maFenetre.setVisible(true);*/


        // make a screenshot of the screen
        try {
            Robot robot = new Robot();
            BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(screenShot, "JPG", new File("screenshot.jpg"));
        } catch (Exception ex) {
            System.err.println(ex);
        }

        // display the screenshot in a window
        JFrame screenshotFrame = new JFrame("Screenshot");
        screenshotFrame.getContentPane().add(new JLabel(new ImageIcon("screenshot.jpg")));
        screenshotFrame.pack();
        screenshotFrame.setVisible(true);

        // make a webcam shot
        try {
            Webcam webcam = Webcam.getDefault();
            webcam.open();
            ImageIO.write(webcam.getImage(), "JPG", new File("webcam.jpg"));
            webcam.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }


    }
}