package objects;

import java.util.Random;

public class Sampler {
    // dimension of the workspace
    private double width, height;
    private rand = new Random();

    public Sampler (double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Point[] getSquare (double radius, double slope) {
        // assume that the circle around the square must be contained in the workspace
        double diameter = 2 * radius;
        if (diameter > width || diameter > height) 
            return null;

        // random the center for the square
        double cx = rand.nextDouble() * (width - diameter) + radius;
        double cy = rand.nextDouble() * (height - diameter) + radius;

        double x1, y1, x2, y2;
        double tmpTerm = Math.sqrt(radius * radius / (slope * slope + 1));

        if (slope >= 0) {
            x1 = tmpTerm + cx;
            y1 = m*tmpTerm + cy;
            x2 = -tmpTerm + cx;
            y2 = -m*tmpTerm + cy;
        } else {
            x1 = tmpTerm + cx;
            y1 = -m*tmpTerm + cy;
            x2 = -tmpTerm + cx;
            y2 = m*tmpTerm + cy;
        }

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

        return new Point[] { p1, p2 };
    }
}
