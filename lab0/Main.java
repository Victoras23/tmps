package lab1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Cub cub1 = new Cub(2.35);
        Cub cub2 = new Cub(32.4);
        Cub cub3 = new Cub(48.2);
        Sphere sphere1 = new Sphere(11.25);
        Sphere sphere2 = new Sphere(4.23);
        Sphere sphere3 = new Sphere(19.534);
        Parallelepiped parallelepiped1 = new Parallelepiped(15, 17.5, 18);
        Parallelepiped parallelepiped2 = new Parallelepiped(13, 1.5, 12);
        Parallelepiped parallelepiped3 = new Parallelepiped(23, 48.3, 18.5);
        Map<GeometricBody, String> Body = new HashMap<GeometricBody, String>();
        Body.put(cub1, " cub 1 ");
        Body.put(cub2, " cub 2 ");
        Body.put(cub3, " cub 3 ");
        Body.put(sphere1, " sphere 1 ");
        Body.put(sphere2, " sphere 2 ");
        Body.put(sphere3, " sphere 3 ");
        Body.put(parallelepiped1, " parallelepiped 1 ");
        Body.put(parallelepiped2, " parallelepiped 2 ");
        Body.put(parallelepiped3, " parallelepiped 3 ");
        System.out.println("The biggest surface : " + GeometricBodyController.getMaximumSurface(Body));
        System.out.println("The biggest volume : " + GeometricBodyController.getMaximumVolume(Body));
    }
}
