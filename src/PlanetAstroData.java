
/**
 * The Class PlanetAstroData.
 */
public class PlanetAstroData {

    /** The planet radius. */
    private int planetRadius;

    /** The orbit width. */
    private int orbitWidth;

    /** The planet start x. */
    private int planetStartX;

    /** The planet start y. */
    private int planetStartY;

    /** The angle. */
    private double angle;

    /**
     * Gets the planet radius.
     * 
     * @return the planet radius
     */
    public int getPlanetRadius() {
        return planetRadius;
    }

    /**
     * Sets the planet radius.
     * 
     * @param planetRadius the new planet radius
     */
    public void setPlanetRadius(int planetRadius) {
        this.planetRadius = planetRadius;
    }

    /**
     * Gets the orbit width.
     * 
     * @return the orbit width
     */
    public int getOrbitWidth() {
        return orbitWidth;
    }

    /**
     * Sets the orbit width.
     * 
     * @param orbitWidth the new orbit width
     */
    public void setOrbitWidth(int orbitWidth) {
        this.orbitWidth = orbitWidth;
    }

    /**
     * Gets the planet start x.
     * 
     * @return the planet start x
     */
    public int getPlanetStartX() {
        return planetStartX;
    }

    /**
     * Sets the planet start x.
     * 
     * @param planetStartX the new planet start x
     */
    public void setPlanetStartX(int planetStartX) {
        this.planetStartX = planetStartX;
    }

    /**
     * Gets the planet start y.
     * 
     * @return the planet start y
     */
    public int getPlanetStartY() {
        return planetStartY;
    }

    /**
     * Sets the planet start y.
     * 
     * @param planetStartY the new planet start y
     */
    public void setPlanetStartY(int planetStartY) {
        this.planetStartY = planetStartY;
    }

    /**
     * Gets the angle.
     * 
     * @return the angle
     */
    public double getAngle() {
        return angle;
    }

    /**
     * Sets the angle.
     * 
     * @param angle the new angle
     */
    public void setAngle(double angle) {
        this.angle = angle;
    }

    /**
     * Constructs a <code>String</code> with all attributes
     * in name = value format.
     *
     * @return a <code>String</code> representation 
     * of this object.
     */
    public String toString() {
        final String SEPARATOR = ", ";
        StringBuilder retValue = new StringBuilder();
        retValue.append("PlanetAstroData ( ")
            .append(super.toString()).append(SEPARATOR)
            .append("planetRadius = ").append(this.planetRadius).append(SEPARATOR)
            .append("orbitWidth = ").append(this.orbitWidth).append(SEPARATOR)
            .append("planetStartX = ").append(this.planetStartX).append(SEPARATOR)
            .append("planetStartY = ").append(this.planetStartY).append(SEPARATOR)
            .append("angle = ").append(this.angle).append(SEPARATOR)
            .append(" )\n");
        return retValue.toString();
    }

}
