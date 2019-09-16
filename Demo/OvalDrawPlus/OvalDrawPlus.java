// Assignment: OvalDrawPlus - Drawing an oval and blue rectangle.
// Name: Jocelyn Murray
// Date: 9/14/19
// Notes: My favorite color is Chartreuse (Green/Yellow)

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Container; 
import java.awt.Color;

class Oval extends JPanel {
    private Color myColor;

    // Setter for type Color.
    public void setColor(int red, int green, int blue) {
        myColor = new Color(red,green,blue);
    }

    // Getter for type Color.
    public Color getColor() {
        return myColor;
    }

    // Default Constructor for Oval.
    Oval() {
        setColor(151, 240, 67);
    }

    // Parametertized Constructor for Oval.
    Oval(int red, int green, int blue) {
        setColor(red,green,blue);       
    }


    // Paints both the Rectangle and Oval shapes.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // The below segment builds a Blue Rectangle background.
        g.setColor(Color.BLUE);
        g.fillRect(0,0,panelWidth,panelHeight);

        // The below segment builds a Chartreuse Oval.
        g.setColor(myColor);
        g.fillOval(0,0,panelWidth,panelHeight);

    }
}

class OvalFrame extends JFrame {
    OvalFrame() {

        // The below segment sets up the frame, titled "OvalDraw", dimensions, and visibility.
        setTitle("OvalDraw");
        setBounds(200,200,300,400); 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Builds new Oval Object in color Green (Neon-ish Green/Yellow).
        Oval myOval = new Oval(151, 240, 67);

        // Builds a Content Pane to display the Oval within.
        Container contentPane = getContentPane(); 

        // Adds the Oval to the Content Pane.
        contentPane.add(myOval); 
             
    }
}

public class OvalDrawPlus {
    public static void main(String[] args) {
        System.out.println("OvalDraw Starting...");

        //Builds new object OvalFrame to display the Oval.
        OvalFrame myFrame = new OvalFrame();
    }
}