package lab1;

public class Parallelepiped implements GeometricBody {
    double l1, l2, l3;

    Parallelepiped(double x, double y, double z) {
        this.l1 = x;
        this.l2 = y;
        this.l3 = z;
    }

    @Override
    public double getSurface() {
        double surface;
        surface = 2 * ((l1 * l2) + (l2 * l3) + (l1 + l3));
        return surface;
    }

    @Override
    public double getVolume() {
        double volume;
        volume = l1 * l2 * l3;
        return volume;
    }
}
