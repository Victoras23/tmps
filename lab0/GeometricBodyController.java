package lab1;

import java.util.*;

public class GeometricBodyController {
    static Map<String, Double> getMaximumVolume(Map<GeometricBody, String> m) {
        Map<String, Double> biggest = new HashMap<String, Double>();
        double biggestValue = 0, count;
        for (GeometricBody g : m.keySet()) {
            count = g.getVolume();
            if (count >= biggestValue) {
                biggest.clear();
                biggestValue = count;
                biggest.put(m.get(g), count);
            }
        }
        return biggest;
    }

    static Map<String, Double> getMaximumSurface(Map<GeometricBody, String> m) {
        Map<String, Double> biggest = new HashMap<String, Double>();
        double biggestValue = 0, count;
        for (GeometricBody g : m.keySet()) {
            count = g.getSurface();
            if (count >= biggestValue) {
                biggest.clear();
                biggestValue = count;
                biggest.put(m.get(g), count);
            }
        }
        return biggest;
    }
}
