package main.java.week3;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MissingSmallestPositiveTest {

    @Test
    public void getMissingSmallestPositive() {
        int ans = MissingSmallestPositive.getMissingSmallestPositive("4567289");
        assertEquals(1,ans);
    }
}