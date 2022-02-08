package main.java.week6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CriticalPathTest {
    List<List<Integer>> connections;
    CriticalPath criticalPath;
    ArrayList<Integer> a, b, c, d, e, f;

    @Before
    public void setUp() throws Exception {
        criticalPath = new CriticalPath();
        connections = new ArrayList<>();
        a = new ArrayList<>();
        b = new ArrayList<>();
        c = new ArrayList<>();
        d = new ArrayList<>();
        e = new ArrayList<>();
        f = new ArrayList<>();
        a.add(0); a.add(1);
        b.add(1); b.add(6);
        c.add(0); c.add(3);
        d.add(0); d.add(2);
        e.add(2); e.add(3);
        f.add(2); f.add(5);
        connections.add(a);
        connections.add(b);
        connections.add(c);
        connections.add(d);
        connections.add(e);
        connections.add(f);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findCriticalPath() {
        int size = connections.size() +1;
        System.out.println(criticalPath.findCriticalPath(size,connections).toString());

    }
}