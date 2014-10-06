import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class PlanetsLauncher extends JFrame {

    private static final long serialVersionUID = 1L;

    private static Dimension SCREEN_SIZE;

    private static Dimension APP_SIZE;// = new Dimension(1000, 600);

    private static final int APP_TOP_PADDING = 60;

    public PlanetsLauncher() {
        SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
        APP_SIZE = new Dimension((int)SCREEN_SIZE.getWidth()-50, (int)SCREEN_SIZE.getHeight()-100);
        setSize(APP_SIZE);
        setVisible(true);
        setTitle("Planet Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        centreWindow();
        setResizable(false);
        setBackground(Color.BLACK);

        Dimension centerPoint = new Dimension(APP_SIZE.width / 2, (APP_SIZE.height-APP_TOP_PADDING) / 2);

        SolarSystemPanel solarSystemPanel = new SolarSystemPanel(this, centerPoint);
        add(solarSystemPanel);
    }

    public static void main(String[] args) {
        PlanetsLauncher planetsLauncher = new PlanetsLauncher();
        System.out.println(planetsLauncher);
    }

    public void centreWindow() {
        int x = (int) ((SCREEN_SIZE.getWidth() - this.getWidth()) / 2);
        int y = (int) ((SCREEN_SIZE.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
    }

}
