package lab1;

import java.lang.Math;

public class Cub implements GeometricBody {
    double length;

    Cub(double a) {
        this.length = a;
    }

    @Override
    public double getSurface() {
        double surface;
        surface = Math.pow(length, 2) * 6;
        return surface;
    }

    @Override
    public double getVolume() {
        double volume;
        volume = Math.pow(length, 3);
        return 0;
    }

}
