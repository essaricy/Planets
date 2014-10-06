import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class CircularMotion extends Applet implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    int angle;

    Shape circleR;
    Thread frequency = null;

    public void init() {

    }// end of init

    public void paint(Graphics g) {

        Graphics2D ga = (Graphics2D) g;

        //int c = (100 + (200 / 2));
        double degrees = angle * Math.PI * 2 / 360.0; // convert degree into
                                                      // radians

        circleR = new Ellipse2D.Float(400, 100, 200, 200);

        // find X and Y on the circle
        int X = (int) (500 + (100) * java.lang.Math.cos(-degrees));
        int Y = (int) (200 + (100) * java.lang.Math.sin(-degrees));

        int X1 = (int) (500 + (100) * java.lang.Math.cos(degrees));
        int Y1 = (int) (200 + (100) * java.lang.Math.sin(degrees));

        // create a line
        Shape Fa = new Line2D.Float(500, 200, X, Y);
        Shape Fb = new Line2D.Float(500, 200, X1, Y1);

        // draw shape
        ga.draw(circleR);
        ga.draw(Fa);
        ga.draw(Fb);

    }// end of paint

    /*
     * public void update(Graphics g) { System.out.println("Paint"); paint(g); }
     */

    public void start() {
        System.out.println("Inside run method");
        if (frequency == null) {
            // radar= new Thread(this, "DemoRadar");
            frequency = new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        try {

                            if (angle > 360) {
                                angle = 0;
                            } else {
                                angle += 1;
                            }
                            Thread.sleep(100);
                            repaint();
                        }// end of try
                        catch (InterruptedException e) {
                        }
                    }// end of while
                } // end run
            }); // end class
            frequency.start();
        }// end of if
    }// end of start

    public void actionPerformed(ActionEvent evt) {
    }// end of actionPerformed

}// end of main

