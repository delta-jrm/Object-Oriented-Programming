import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
import java.util.*;

public class FaceDraw extends JPanel
{
    protected void paintComponent(Graphics g/*, int facetype*/)
    {
        super.paintComponent(g);

        int facex = ((int)Math.random() * ( 1000 - 50)) + 50;
        int facey = ((int)Math.random() * ( 1000 - 50)) + 50; 
        int facewidth = ((int)Math.random() * (700 - 100)) + 100;
        int faceheight = ((int)Math.random() * (700 - 100)) + 100;
        int eyeline = facey + 30;
        int eyex1 = facex + 30; 
        int eyex2 = facex + 70;
        int mouthx1 = facex + 30;
        int mouthy1 = facey + 50;
        int mouthwidth = facewidth - 50;
        int mouthheight = faceheight - 50;
        
        g.setColor( Color.black);
        g.drawArc(facex, facey, facewidth, faceheight, 0, 360);

        g.setColor( Color.black);
        g.drawArc( eyex1, eyeline, 10, 10, 0, 360);
        g.drawArc( eyex2, eyeline, 10, 10, 0, 360);

        g.setColor( Color.black);
        g.drawArc( mouthx1, mouthy1, mouthwidth, mouthheight, 0, 180);

        /*
        if (facetype = 1) {
        g.setColor( Color.black);
        g.drawArc( mouthx1, mouthy1, mouthwidth, mouthheight, 0, -180 );
        }

        if (facetype = 0) {
        g.setColor( Color.black);
        g.drawArc( mouthx1, mouthy1, mouthwidth, mouthheight, 0, 180);
        }

        if (facetype = -1) {
        g.setColor( Color.black);
        g.drawLine( mouthx1, mouthy1, mouthwidth, mouthheight, 0, 180);
        }
        */
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(1000, 1000);
    }

    private static void createAndShowGUI()
    {
        JComponent face = new FaceDraw();
        face.setForeground(Color.GREEN);
//      face.setBackground(Color.YELLOW);

        JPanel contentPane = new JPanel( new BorderLayout() );
        contentPane.setBackground( Color.CYAN );
        contentPane.add( face );

        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane( contentPane );
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}
