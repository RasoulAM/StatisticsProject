import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class SavePaint extends JPanel
{

    JFrame frame = new JFrame("TheFrame");
    Component component;


    public SavePaint(){
        init();
    }

    public SavePaint(JComponent component){
        this.component = component;
        frame.add(component);
        init();
    }

    void init(){
//        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);

        try
        {
            BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = image.createGraphics();
            System.out.println("Here " + frame.getComponent(0).getName());
            frame.paint(graphics2D);
            ImageIO.write(image,"jpeg", new File("jmemPractice.jpeg"));
        }
        catch(Exception exception)
        {
            System.out.println(exception.toString());
            //code
        }
    }

//    protected void paintComponent(Graphics g)
//    {
//        g.drawRect(50,50,50,50);
//    }

    public static void main(String[] args)
    {
        new SavePaint();
    }
}