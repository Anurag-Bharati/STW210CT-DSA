package main.java.week1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EvalExpressionTest {
    EvalExpression ex;

    @Before
    public void setUp() throws Exception {
         ex = new EvalExpression();
    }

    @After
    public void tearDown() throws Exception {
        ex = null;
    }

    @Test
    public void addOperators() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        List<String> result = ex.getExpression(integerList, 6);
//        System.out.println(result);
        assertEquals("[1+2+3, 1*2*3]", result.toString());
    }
}