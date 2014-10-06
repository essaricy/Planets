import java.awt.Color;


/**
 * The Enum Planet.
 */
public enum Planetinfo {

    /** The MERCURY. */
    MERCURY(Color.GRAY, 0.382, 0.31, 0.24, 58.64, 0, false),

    VENUS(Color.ORANGE, 0.949, 0.72, 0.62, -243.02, 0, false),

    EARTH(Color.BLUE, 1.000, 1.00, 1.00, 1.00, 1, false),

    MARS(Color.RED, 0.532, 1.52, 1.88, 1.03, 2, false),

    JUPITER(Color.DARK_GRAY, 11.209, 5.20, 11.86, 0.41, 67, true),

    SATURN(Color.GRAY, 9.449, 9.54, 29.46, 0.43, 62, true),

    URENUS(Color.PINK, 4.007, 19.22, 84.01, -0.72, 27, true),

    NEPTUNE(Color.GREEN, 3.883, 30.06, 164.80, 0.67, 14, true);

    /** The equatorial diameter. */
    private double equatorialDiameter;
    
    /** The orbital radius. */
    private double orbitalRadius;
    
    /** The orbital period in years. */
    private double orbitalPeriodInYears;
    
    /** The rotation period. */
    private double rotationPeriod;
    
    /** The number of moons. */
    private int numberOfMoons;
    
    /** The rings. */
    private boolean rings;

    private Color color;

    /**
     * Instantiates a new planet.
     * 
     * @param equatorialDiameter the equatorial diameter
     * @param orbitalRadius the orbital radius
     * @param orbitalPeriodInYears the orbital period in years
     * @param rotationPeriod the rotation period
     * @param numbeOfMoons the numbe of moons
     * @param rings the rings
     */
    private Planetinfo(Color color, double equatorialDiameter, double orbitalRadius,
            double orbitalPeriodInYears, double rotationPeriod,
            int numberOfMoons, boolean rings) {
        this.color=color;
        this.equatorialDiameter=equatorialDiameter;
        this.numberOfMoons=numberOfMoons;
        this.orbitalPeriodInYears=orbitalPeriodInYears;
        this.orbitalRadius=orbitalRadius;
        this.rings=rings;
        this.rotationPeriod=rotationPeriod;
    }

    public Color getColor() {
        return color;
    }

    /**
     * Gets the equatorial diameter.
     * 
     * @return the equatorial diameter
     */
    public double getEquatorialDiameter() {
        return equatorialDiameter;
    }

    /**
     * Gets the orbital radius.
     * 
     * @return the orbital radius
     */
    public double getOrbitalRadius() {
        return orbitalRadius;
    }

    /**
     * Gets the orbital period in years.
     * 
     * @return the orbital period in years
     */
    public double getOrbitalPeriodInYears() {
        return orbitalPeriodInYears;
    }

    /**
     * Gets the rotation period.
     * 
     * @return the rotation period
     */
    public double getRotationPeriod() {
        return rotationPeriod;
    }

    public int getNumberOfMoons() {
        return numberOfMoons;
    }

    /**
     * Checks if is rings.
     * 
     * @return true, if is rings
     */
    public boolean isRings() {
        return rings;
    }

}
