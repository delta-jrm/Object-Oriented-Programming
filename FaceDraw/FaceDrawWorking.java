import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
import java.util.*;

 class Face extends JPanel
{
    private int facetype;
    private int facex;
    private int facey;
    private int facewidth;
    private int faceheight;
    private int eyeline;
    private int eyex1;
    private int eyex2;
    private int mouthx1;
    private int mouthy1;
    private int mouthheight;
    private int mouthwidth;

    // Setter for type Face.
    public void setType(int facetype) {
        facetype = facetype;
    }

    // Getter for type Face.
    public int getType() {
        return facetype;
    }

    Face(){
        facetype = 1;
    }

    Face(int facetype){
        setType(facetype);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        facex = (((int)Math.random()) * (( 1000 - 50) + 1)) + 50;
        facey = (((int)Math.random()) * (( 1000 - 50) + 1)) + 50; 
        facewidth = (((int)Math.random()) * (( 700 - 100) + 1)) + 100;
        faceheight = (((int)Math.random()) * (( 700 - 100) + 1)) + 100;
        eyeline = facey + 30;
        eyex1 = facex + 30; 
        eyex2 = facex + 70;
        mouthx1 = facex + 30;
        mouthy1 = facey + 50;
        mouthwidth = facewidth - 50;
        mouthheight = faceheight - 50;
        
        g.setColor( Color.black);
        g.drawArc(facex, facey, facewidth, faceheight, 0, 360);

        g.setColor( Color.black);
        g.drawArc( eyex1, eyeline, 10, 10, 0, 360);
        g.drawArc( eyex2, eyeline, 10, 10, 0, 360);

        //g.setColor( Color.black);
        //g.drawArc( mouthx1, mouthy1, mouthwidth, mouthheight, 0, 180);

        if (facetype == 1) {
        g.setColor( Color.black);
        g.drawArc( mouthx1, mouthy1, mouthwidth, mouthheight, 0, -180 );
        }

        if (facetype == 0) {
        g.setColor( Color.black);
        g.drawArc( mouthx1, mouthy1, mouthwidth, mouthheight, 0, 180);
        
        }

        if (facetype == 2) {
        g.setColor( Color.black);
        g.drawLine( mouthx1, mouthy1, mouthwidth, mouthheight);

        }
        }
        //System.out.println("this means that the drawface method works");

}


class FaceFrame extends JFrame {

    FaceFrame() {

        
        setTitle("FaceFrame");
        setBounds(200,200,300,400); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Builds new Oval Object in color Green (Neon-ish Green/Yellow).

        Face face1 = new Face();

        // Builds a Content Pane to display the Oval within.
        Container contentPane = getContentPane(); 

        // Adds the Oval to the Content Pane.
        contentPane.add(face1); 
             
    }
}

public class FaceDraw {
    public static void main(String[] args) {
        System.out.println("FaceDraw Starting...");

        

        //Builds new object OvalFrame to display the Oval.
        FaceFrame myFrame = new FaceFrame();
        myFrame.setVisible(true);
    }
}
