// File: OvalDrawPlus.Java
// Name: Jocelyn Murray
// Date: 9/14/19
// Usage: Made to draw an oval.
// Notes: My favorite color is Green

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Container; 
import java.awt.Color;

class Oval extends JPanel {
    private Color myColor;
    public void setColor(int red, int green, int blue) {
        myColor = new Color(red,green,blue);
    }
    public Color getColor() {
        return myColor;
    }

    Oval() {
        setColor(151, 240, 67);
    }

    Oval(int red, int green, int blue) {
        setColor(red,green,blue);       
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        g.setColor(myColor);
        g.fillOval(0,0,panelWidth,panelHeight);
    }
}

class OvalFrame extends JFrame {
    OvalFrame() {
        setTitle("OvalDraw");
        setBounds(200,200,300,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Oval myOval = new Oval(151, 240, 67);
        Container contentPane = getContentPane();
        contentPane.add(myOval);     
    }
}

public class OvalDrawPlus {
    public static void main(String[] args) {
        System.out.format("Oval Color: %f", myColor);
        System.out.println("OvalDraw Starting...");
        OvalFrame myFrame = new OvalFrame();
    }
}