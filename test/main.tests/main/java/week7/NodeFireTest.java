package main.java.week7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class NodeFireTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test(){
        NodeFire.Node root = new NodeFire.Node(1);
        root.left = new NodeFire.Node(2);
        root.right = new NodeFire.Node(3);
        root.right.left = new NodeFire.Node(4);
        root.right.right = new NodeFire.Node(5);
        NodeFire.Node left = root.right.left;
        NodeFire.Node right = root.right.right;
        left.left = new NodeFire.Node(6);
        left.right = new NodeFire.Node(7);
        right.left = new NodeFire.Node(8);
        right.right = new NodeFire.Node(9);
        System.out.println(NodeFire.burnTree(root,left));

    }
}