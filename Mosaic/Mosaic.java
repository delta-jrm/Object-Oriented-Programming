/**
* The mosaic program randomly generates a mosaic with random colored shapes and random colored letters in a grid setup.
* When space is clicked or the Randomized Button is clicked, the board should randomize and reprint information to console.
* To change a grid member to a smile, just click on it!
*
* @author  Jocelyn Murray
* @version 1.0
* @since   2019-10-19 
*/

// Imports: In order of appearance. 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Container; 
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import java.util.ArrayList;


class Tile extends JPanel implements MouseListener {
    private int red, green, blue; // Sets RGB
    private String letter; // For the random letter
    public boolean drawface; // Causes the drawface
    public Face myFace; // Our Face
    private int rectorcirc; // Whether the shape is rectangle or circle
    public String shapetype; // For the toString saying rectangle or circle
    int facecolor;
    int facetype;

    // Setters
    public void setLetter(String newletter) { this.letter = newletter;}
    public void setDrawFace(boolean newdrawface) {this.drawface = newdrawface;}
    public void setRed(int newred) {this.red = newred;}
    public void setGreen(int newgreen) {this.green = newgreen;}
    public void setBlue(int newblue) {this.blue = newblue;}
    public void setRectorCirc(int newrectorcirc) {this.rectorcirc = newrectorcirc;}
    public void setShapetype(String newst) {this.shapetype = newst;}
    public void setFaceColor(int newfacecolor) {this.facecolor = newfacecolor;}
    public void setFaceType(int newfacetype) {this.facetype = newfacetype;}

    // Getters
    public String getLetter() { return letter;}
    public boolean getDrawFace() { return drawface;}
    public int getRed() { return red;}
    public int getGreen() { return green;}
    public int getBlue() { return blue;}
    public int getRectorCirc() { return rectorcirc;}
    public String getShapetype() { return shapetype;}
    public int getFaceColor() { return facecolor;}
    public int getFaceType() { return facetype;}


    // ToString for Tile
    public String toString(){
        return "Letter: " + letter + "\n Red, Green Blue: " + red + ", " + green + ", " + blue + "\n Shape: " + shapetype;
    }

    //Default Tile Constructor
    Tile() {
        super();
        SetRandomValues();
        drawface = false;
        Face myFace = new Face(getWidth(), getHeight());
        addMouseListener(this);
        this.rectorcirc = GetNumberBetween(0,1);
        this.facecolor = GetNumberBetween(0,5);
        this.facetype = GetNumberBetween(0,2);

    }

    //Non default tile constructor that can change the default drawface value.
    Tile(boolean newdrawface) {
        super();
        SetRandomValues();
        this.drawface = newdrawface;
        Face myFace = new Face(getWidth(), getHeight());
        addMouseListener(this);
        this.rectorcirc = GetNumberBetween(0,1);
        this.facecolor = GetNumberBetween(0,5);
        this.facetype = GetNumberBetween(0,2);

    }

    // Set values for the random colors as well as the letters contained in the tile.
    final public void SetRandomValues() {
        red = GetNumberBetween(0,255);
        green = GetNumberBetween(0,255);
        blue = GetNumberBetween(0,255);

        ArrayList<String> letters = new ArrayList<>();
        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");
        letters.add("F");
        letters.add("G");
        letters.add("H");
        letters.add("I");
        letters.add("J");
        letters.add("K");
        letters.add("L");
        letters.add("M");
        letters.add("N");
        letters.add("O");
        letters.add("P");
        letters.add("Q");
        letters.add("R");
        letters.add("S");
        letters.add("T");
        letters.add("U");
        letters.add("V");
        letters.add("W");
        letters.add("X");
        letters.add("Y");
        letters.add("Z");

        int randletter = GetNumberBetween(0,25);
        letter = letters.get(randletter);     
                
    }

    //Random number generator.
    private static int GetNumberBetween(int min, int max) {
        Random myRandom = new Random();
        return min + myRandom.nextInt(max-min+1);
    }   

     public void paintComponent(Graphics g) {
        super.paintComponent(g); 

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // Will Draw Face if true
        if(drawface == true) {
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
        
        else {
    
            g.setColor(new Color(red,green,blue));

            if(rectorcirc == 0) {
                g.fillRect (10, 10, panelWidth, panelHeight);
                shapetype = "Rectangle";
                }

            else {
                g.fillOval (10, 10, panelWidth - 35, panelHeight - 10);
                shapetype = "Circle";
                }

            g.setColor(new Color(GetContrastingColor(red),GetContrastingColor(green),GetContrastingColor(blue)));

            final int fontSize=25;
            g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
            int stringX = (panelWidth/2)-15;
            int stringY = (panelHeight/2)+15;
            g.drawString(letter,stringX,stringY);
            System.out.println(this);
    }

    }

    private static int GetContrastingColor(int colorIn) {
        return ((colorIn+128)%256);
    }

    public void mousePressed(MouseEvent e) {System.out.println("Mouse pressed");}
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {drawface = true; repaint();}
    public void mouseExited(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
}

class MosaicLiteFrame extends JFrame implements ActionListener {
    private ArrayList<Tile> tileList;

    public MosaicLiteFrame() {
        setBounds(200,200,1200,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JButton randomize = new JButton("Randomize");
        buttonPanel.add(randomize);
        randomize.addActionListener(this);

        JPanel tileGridPanel = new JPanel();
        contentPane.add(tileGridPanel, BorderLayout.CENTER);
        tileGridPanel.setLayout(new GridLayout(12,12));

        tileList = new ArrayList<Tile>();
        for(int i=1; i<144; i++) {
            Tile tile = new Tile();
            tileList.add(tile);
            tileGridPanel.add(tile);
        }
    }

    public void actionPerformed(ActionEvent e) {
        for(Tile tile : tileList) {
            tile.SetRandomValues();
        }
        repaint();
    }
}

public class Mosaic {
    public static void main(String[] args) {
        System.out.println("MosaicLite Starting...");
        MosaicLiteFrame myMosaicLiteFrame = new MosaicLiteFrame();
        myMosaicLiteFrame.setVisible(true);
    }
}