package geometry;

import org.ejml.simple.SimpleMatrix;


/**
 * Represent the configuration of a robot in the configuration space.
 */
public class Configuration {
    // x and y coordinates representing position vector.
    private double x, y;
    // the angle between the position vector and x-axis (from -PI to PI).
    private double angle;

    public Configuration (double x, double y, double angle) {
        this.x = x;
        this.y = y;
        this.angle = angle;
    } 

    public Configuration (double x, double y) {
        this(x, y, 0.0);
    }

    public Configuration (Configuration other) {
        this(other.x, other.y, other.angle);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getAngle() {
        return angle;
    }

    public void setX(double val) {
        x = val;
    }

    public void setY(double val) {
        y = val;
    }

    /** Returns a 3x1 vector of the form (x, y, angle). */
    public SimpleMatrix toVector() {
        double[][] vector = {{x}, {y}, {angle}};
        return new SimpleMatrix(vector);
    }

    public double distanceTo(Configuration other) {
        SimpleMatrix v1 = this.toVector();
        SimpleMatrix v2 = other.toVector();
        return v1.minus(v2).normF();
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Configuration))
            return false;

        Configuration c = (Configuration) o;

        return Double.compare(c.x, this.x) == 0 &&
               Double.compare(c.y, this.y) == 0 &&
               Double.compare(c.angle, this.angle) == 0;
    }
}
