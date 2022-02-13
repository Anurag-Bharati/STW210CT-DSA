package main.java.week4;

import java.util.HashMap;
import java.util.Map;


public class PointAndPlane {

    // Calculate slopes of different coordinate
    // Compare and if equal the point is on a same line.

    public int maxPoints(int[][] points) {
        int length = points.length;
        if (length <= 1) return length;
        int max = 1;

        for (int i = 0; i < length; i++) {
            int[] a = points[i];
            int same = 0;
            Map<Double, Integer> map = new HashMap<>();
            int localMax = 1;

            for (int j = i + 1; j < length; j++) {
                // check if point are same
                if (isSame(a, points[j])) {
                    same++;
                    continue;
                }
                double slope = getSlope(a, points[j]);
                // put  slope = slope and increment by 1 if not set 1 and increment by 1
                map.put(slope, map.getOrDefault(slope, 1) + 1);
                localMax = Math.max(localMax, map.get(slope));
            }
            // in case of localMax + same < max return 1
            max = Math.max(max, localMax + same);
        }
        return max;
    }

    private boolean isSame(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }

    private double getSlope(int[] a, int[] b) {
        // if vertical line then slope = infinity
        if (a[0] == b[0]) return Double.MAX_VALUE;
        // if horizontal line then slope = 0
        if (a[1] == b[1]) return 0;
        // else slope formula
        return (double) (b[0] - a[0]) / (b[1] - a[1]);
    }

    // TODO STORE COORDINATES WITH EQUAL SLOPE IN A HASHMAP
}
