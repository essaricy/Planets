import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class SolarSystemPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private Dimension centerPoint;

    private Timer timer;

    private Map<Planetinfo, PlanetAstroData> PLANETS_DATA;

    private double theta = 45;

    private double angle = 0.1;

    Dimension elasticity = new Dimension(2, 1);

    public SolarSystemPanel(JFrame parent, Dimension centerPoint) {
        //this.parent=parent;
        this.centerPoint = centerPoint;
        setBackground(Color.BLACK);
        PLANETS_DATA= new HashMap<Planetinfo, PlanetAstroData>();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int sunRadius=50;
        int sunX=(int)centerPoint.getWidth();
        int sunY=(int) centerPoint.getHeight();
        try {
            if (timer == null) {
                g2d.setStroke(new BasicStroke(2));
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                drawSun(g2d, sunRadius, Color.RED);
                for (Planetinfo planetInfo : Planetinfo.values()) {
                    acivatePlanet(g2d, planetInfo, sunRadius);
                }
                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        repaint();
                    }
                });
                timer.start();
            } else {
                for (Planetinfo planetInfo : Planetinfo.values()) {
                    g2d.setColor(planetInfo.getColor());
                    PlanetAstroData planetAstroData = PLANETS_DATA.get(planetInfo);

                    double rotationPeriod = planetInfo.getRotationPeriod();
                    double angle = planetAstroData.getAngle();
                    angle=angle+360/rotationPeriod;
                    if (planetInfo == Planetinfo.NEPTUNE) {
                        System.out.println(angle);
                    }
                    planetAstroData.setAngle(angle);

                    int planetRadius = planetAstroData.getPlanetRadius();
                    double orbitalRadius = planetInfo.getOrbitalRadius();
                    double adjustedRadius = ((sunRadius*2)+orbitalRadius*18)/2;
                    double x = (sunX/2 + adjustedRadius * Math.sin(angle))-planetRadius/4;
                    double y = (sunY + adjustedRadius * Math.cos(angle))-planetRadius/2;
                    int adjustedWidth = (int) (x*elasticity.getWidth());
                    int adjustedHeight = (int) (y*elasticity.getHeight());
                    g2d.fillOval(adjustedWidth, adjustedHeight, planetRadius, planetRadius);
                    //break;
                }
                //angle++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void acivatePlanet(Graphics2D g2d, Planetinfo planet, int sunRadius) {
        // Draw orbit
        double adjustedRadius = (sunRadius*2)+planet.getOrbitalRadius()*18;

        g2d.setStroke(new BasicStroke(1));
        drawOrbit(g2d, adjustedRadius, elasticity, planet.getColor());

        // Place planet
        int planetRadius=(int) (planet.getEquatorialDiameter()*4);
        int orbitWidth = (int) (adjustedRadius*elasticity.getWidth());
        int planetStartX = (int)(centerPoint.getWidth()+(orbitWidth/2)-planetRadius/2);
        int planetStartY = (int)centerPoint.getHeight()-planetRadius/2;
        g2d.fillOval(planetStartX, planetStartY, planetRadius, planetRadius);

        PlanetAstroData planetAstroData = new PlanetAstroData();
        planetAstroData.setOrbitWidth(orbitWidth);
        planetAstroData.setPlanetRadius(planetRadius);
        planetAstroData.setPlanetStartX(planetStartX);
        planetAstroData.setPlanetStartY(planetStartY);
        PLANETS_DATA.put(planet, planetAstroData);
    }

    private void drawOrbit(Graphics2D g2d, double radius, Dimension elasticity, Color color) {
        int orbitWidth = (int) (radius*elasticity.getWidth());
        int orbitHeight = (int) (radius*elasticity.getHeight());
        g2d.setColor(color);
        g2d.drawOval((int)(centerPoint.getWidth()-orbitWidth/2),
                (int) centerPoint.getHeight()-orbitHeight/2,
                orbitWidth, orbitHeight);
    }

    private void drawSun(Graphics2D g2d, int radius, Color color) {
        g2d.setColor(color);

        //g2d.fill(new Ellipse2D.Double((int)centerPoint.getWidth()-radius, (int) centerPoint.getHeight()-radius, radius*2, radius*2));
        g2d.fillOval((int)centerPoint.getWidth()-radius, (int) centerPoint.getHeight()-radius, radius*2, radius*2);
    }

}
