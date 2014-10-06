import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.JFrame;


public class Planet extends JComponent {

    private static final long serialVersionUID = 1L;

    //private JFrame parent;

    private Planetinfo planetInfo;

    private int sunRadius;

    private Dimension centerPoint;

    public Planet(JFrame parent, Dimension centerPoint, Planetinfo planetInfo, int sunRadius) {
        //this.parent=parent;
        this.centerPoint=centerPoint;
        this.planetInfo=planetInfo;
        this.sunRadius=sunRadius;

        /*Thread animationThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println("repaint()");
                    repaint();
                    try {
                        Thread.sleep(10);
                    } catch (Exception ex) {
                    }
                }
            }
        });
        animationThread.start();*/
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw orbit
        double adjustedRadius = (sunRadius*2)+planetInfo.getOrbitalRadius()*20;
        //System.out.println(planetInfo + " adjustedRadius = " + adjustedRadius);
        Dimension elasticity = new Dimension(3, 1);
        drawOrbit(g2d, adjustedRadius, elasticity, planetInfo.getColor());

        // Place planet
        int planetRadius=20;
        int orbitWidth = (int) (adjustedRadius*elasticity.getWidth());
        int planetStartX = (int)(centerPoint.getWidth()+(orbitWidth/2)-planetRadius/2);
        int planetStartY = (int)centerPoint.getHeight();
        g2d.fillOval(planetStartX, planetStartY, planetRadius, planetRadius);
    }

    private void drawOrbit(Graphics2D g2d, double radius, Dimension elasticity, Color color) {
        int orbitWidth = (int) (radius*elasticity.getWidth());
        int orbitHeight = (int) (radius*elasticity.getHeight());
        g2d.setColor(color);
        g2d.drawOval((int)(centerPoint.getWidth()-orbitWidth/2),
                (int) centerPoint.getHeight()-orbitHeight/2,
                orbitWidth, orbitHeight);
    }

}
