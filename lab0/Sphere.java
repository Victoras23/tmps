package lab1;

import java.lang.Math;

public class Sphere implements GeometricBody {
    double radius;

    Sphere(double r) {
        this.radius = r;
    }

    @Override
    public double getSurface() {
        double surface;
        surface = 4 * 3.14 * Math.pow(radius, 2);
        return surface;
    }

    @Override
    public double getVolume() {
        double volume;
        volume = 4 / 3 * 3.14 * Math.pow(radius, 3);
        return volume;
    }
}
