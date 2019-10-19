import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
import java.util.*;

class Face extends JPanel
{
    private ArrayList<Face> FaceList = new ArrayList<>();
    Random generator = new Random();
    int facetype;
    int facecolor;
    int panelHeight;
    int panelWidth;

    public Face(int panelWidth, int panelHeight) {
        Random generator = new Random();
        this.facetype = generator.nextInt(3);
        this.facecolor = generator.nextInt(6);
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;


    } 

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (facecolor == 5) { g.setColor( Color.red);}
        if (facecolor == 4) { g.setColor( Color.blue);}
        if (facecolor == 3) { g.setColor( Color.yellow);}
        if (facecolor == 1) { g.setColor( Color.green);}
        if (facecolor == 2) { g.setColor( Color.orange);}
        if (facecolor == 0) { g.setColor( Color.cyan);}
        g.fillArc(10, 10, panelWidth/2, panelHeight - 10, 0, 360);
                
        g.setColor( Color.black);
        g.drawArc(10, 10, panelWidth/2, panelHeight - 10, 0, 360);

        g.setColor(Color.black);
        g.fillArc(20,20,10,10,0,360);
        g.fillArc(40,20,10,10,0,360);

        if (facetype == 2) { g.drawArc( 25, 35, 20, 10, 0, -180 );}
        if (facetype == 1) { g.drawArc( 25, 35, 20, 10, 0, 180 );}
        if (facetype == 0) { g.drawLine( 20, 40, 50, 40);}
    }

    }

