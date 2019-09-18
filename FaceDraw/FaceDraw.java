import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
import java.util.*;

 class Face extends JPanel
{
    
    Random generator = new Random();
    int facetype = generator.nextInt(3);
    int facex = generator.nextInt(200);
    int facey = generator.nextInt(200);
    int facewidth = generator.nextInt(700) + 25;
    int faceheight = facewidth;
    int eyeline = facey + (faceheight/4);
    int eyex1 = facex + (facewidth/3);
    int eyex2 = facex + facewidth - (facewidth/3);
    int mouthx1 = facex + (facewidth/4);
    int mouthy1 = eyeline + (faceheight/3);
    int mouthx2 = facex + facewidth - (facewidth/4);
    int mouthy2 = eyeline + (faceheight/3);    
    int mouthheight = faceheight/3;
    int mouthwidth = facewidth/2;

    Face(){
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor( Color.black);
        g.drawArc(facex, facey, facewidth, faceheight, 0, 360);

        g.setColor( Color.black);
        g.drawArc( eyex1, eyeline, 10, 10, 0, 360);
        g.drawArc( eyex2, eyeline, 10, 10, 0, 360);

        //g.setColor( Color.black);
        //g.drawArc( 100, 100, mouthwidth, mouthheight, 0, 180);

        if (facetype == 2) {
        g.setColor( Color.black);
        g.drawArc( mouthx1, mouthy1, mouthwidth, mouthheight, 0, -180 );
        }

        if (facetype == 1) {
        g.setColor( Color.black);
        g.drawArc( mouthx1, mouthy1, mouthwidth, mouthheight, 0, 180);
        
        }

        if (facetype == 0) {
        g.setColor( Color.black);
        g.drawLine( mouthx1, mouthy1, mouthx2, mouthy2);

        }
        }
        //System.out.println("this means that the drawface method works");
    }



class FaceFrame extends JFrame {

    FaceFrame() {

        // The below segment sets up the frame, titled "OvalDraw", dimensions, and visibility.
        setTitle("FaceDraw");
        setSize(1000,1000); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Builds new Oval Object in color Green (Neon-ish Green/Yellow).
        Face face1 = new Face();
        Face face2 = new Face();

        // Builds a Content Pane to display the Oval within.
        Container contentPane = getContentPane(); 

        // Adds the Oval to the Content Pane.
        contentPane.add(face1);
        contentPane.add(face2);
    }
}

public class FaceDraw {
    public static void main(String[] args) {
        System.out.println("FaceDraw Starting...");
        //Builds new object OvalFrame to display the Oval.
        //for(int i=0; i <= 10; i++);
        FaceFrame myFrame = new FaceFrame();
        myFrame.setVisible(true);
        //}
        

    }
}
