import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
import java.util.*;

class FaceFrame extends JPanel {
    int numberfaces;
    ArrayList<Face> faces;
    FaceFrame() {
        Random generator = new Random();
        this.numberfaces = generator.nextInt(10);
        faces = new ArrayList<>();
    }

    public void addFaces() {
        
        if(numberfaces < 3) {
            numberfaces = 3;
        }

        for(int i = numberfaces; i > 0; i--) {
            faces.add(new Face());
        }
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        addFaces();
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
    int facecolor;
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
        this.facecolor = generator.nextInt(5);
        this.facex = generator.nextInt(1200);
        this.facey = generator.nextInt(500);
        this.facewidth = generator.nextInt(400) + 70;
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
        g.fillArc(eyex1,eyeline,10,15,0,360);
        g.fillArc(eyex2,eyeline,10,15,0,360);
        //g.drawArc( eyex1, eyeline, 14, 14, 0, 360);
        //g.drawArc( eyex2, eyeline, 14, 14, 0, 360);

        if (facetype == 2) {
       
        g.drawArc(eyex1 - 5, eyeline - 10, 20, 20, 0, 180);
        g.drawArc(eyex2 - 5 , eyeline - 10, 20, 20, 0, 180);

    }

    if (facetype == 0) {
       
        g.drawLine(eyex1 - 8, eyeline - 8, eyex1 + 14, eyeline);
        g.drawLine(eyex2 + 10 , eyeline - 8, eyex2 - 12, eyeline);

    }

    if (facetype == 1) {
       
        g.drawLine(eyex1 - 8, eyeline - 4, eyex1 + 14, eyeline - 10);
        g.drawLine(eyex2 - 8 , eyeline - 10, eyex2 + 14, eyeline - 4);

    }
}

    public void drawFaceShape(Graphics g) {
        
        if (facecolor == 5) {
            g.setColor( Color.red);
            g.fillArc( facex, facey, facewidth, faceheight, 0, 360);

            
            g.setColor( Color.black);
            g.drawArc(facex, facey, facewidth, faceheight, 0, 360);
        
        }

        if (facecolor == 4) {
            g.setColor( Color.blue);
            g.fillArc(facex, facey, facewidth, faceheight, 0, 360);

            
            g.setColor( Color.black);
            g.drawArc(facex, facey, facewidth, faceheight, 0, 360);
        
        }

        if (facecolor == 3) {
            g.setColor( Color.yellow);
            g.fillArc(facex, facey, facewidth, faceheight, 0, 360);
            
            g.setColor( Color.black);
            g.drawArc(facex, facey, facewidth, faceheight, 0, 360);
        
        }
        if (facecolor == 1) {
            g.setColor( Color.green);
            g.fillArc(facex, facey, facewidth, faceheight, 0, 360);
            
            g.setColor( Color.black);
            g.drawArc(facex, facey, facewidth, faceheight, 0, 360);
        
        }

        if (facecolor == 2) {
            g.setColor( Color.orange);
            g.fillArc(facex, facey, facewidth, faceheight, 0, 360 );
            
            g.setColor( Color.black);
            g.drawArc(facex, facey, facewidth, faceheight, 0, 360);
        }

        if (facecolor == 0) {
            g.setColor( Color.pink);
            g.fillArc(facex, facey, facewidth, faceheight, 0, 360);
            
            g.setColor( Color.black);
            g.drawArc(facex, facey, facewidth, faceheight, 0, 360);

    }
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
        drawFaceShape(g);
        drawEyes(g);
        drawMouth(g);
        }
    }


public class FaceDraw extends JFrame {

    public static void main(String[] args) {
        System.out.println("FaceDraw Starting..."); 
        JFrame frame = new JFrame();
        frame.setSize(5000,5000);
        frame.setTitle("FaceDraw");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new FaceFrame());
        frame.setVisible(true);

      }
    }