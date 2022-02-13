package main.java.week4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointAndPlaneTest {
    PointAndPlane pointAndPlane;

    @Before
    public void setUp() throws Exception {
        pointAndPlane = new PointAndPlane();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void maxPoints() {
        int result = pointAndPlane.maxPoints(new int[][]{{1,2}, {5,5}, {1,4}, {2,3}, {3,2}, {4,1}, {3,5}});
        System.out.println(result);
    }
}