import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
import java.util.*;

class FaceFrame extends JPanel {
    ArrayList<Face> faces;
    FaceFrame() {
        faces = new ArrayList<>();
        faces.add(new Face());
        faces.add(new Face());
        faces.add(new Face());
        faces.add(new Face());
        faces.add(new Face());
        faces.add(new Face());
        faces.add(new Face());
        faces.add(new Face());
        faces.add(new Face());
        faces.add(new Face());
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Face face : faces) {
            face.drawFace(g);
        }
    }
}

class Face extends JPanel
{
    private ArrayList<Face> faces = new ArrayList<>();
    Random generator = new Random();
    int facetype;
    int facex;
    int facey;
    int facewidth;
    int faceheight;
    int eyeline;
    int eyex1;
    int eyex2;
    int mouthx1;
    int mouthy1;
    int mouthx2;
    int mouthy2;    
    int mouthheight;
    int mouthwidth;

    public Face(){
        Random generator = new Random();
        this.facetype = generator.nextInt(3);
        this.facex = generator.nextInt(1200);
        this.facey = generator.nextInt(500);
        this.facewidth = generator.nextInt(500) + 25;
        this.faceheight = facewidth;
        this.eyeline = facey + (faceheight/4);
        this.eyex1 = facex + (facewidth/3);
        this.eyex2 = facex + facewidth - (facewidth/3);
        this.mouthx1 = facex + (facewidth/4);
        this.mouthy1 = eyeline + (faceheight/3);
        this.mouthx2 = facex + facewidth - (facewidth/4);
        this.mouthy2 = eyeline + (faceheight/3);    
        this.mouthheight = faceheight/3;
        this.mouthwidth = facewidth/2;

    } 

    public void drawEyes(Graphics g) {
        g.setColor(Color.black);
        g.drawArc( eyex1, eyeline, 14, 14, 0, 360);
        g.drawArc( eyex2, eyeline, 14, 14, 0, 360);
    }

    public void drawFaceShape(Graphics g) {
        g.setColor( Color.black);
        g.drawArc(facex, facey, facewidth, faceheight, 0, 360);
    }

    public void drawMouth(Graphics g) {

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
    
    public void drawFace(Graphics g) {
        drawEyes(g);
        drawFaceShape(g);
        drawMouth(g);
        }
    }


public class FaceDraw extends JFrame {

    public static void main(String[] args) {
        System.out.println("FaceDraw Starting...");
        //Builds new object OvalFrame to display the Oval.
        //for(int i=0; i <= 10; i++);
        JFrame frame = new JFrame();
        frame.setTitle("FaceDraw");
        frame.setSize(5000,5000); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new FaceFrame());
        frame.setVisible(true);

        //}

      }
    }