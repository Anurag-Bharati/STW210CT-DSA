package main.java.week7;

import java.util.*;

public class NodeFire {
    static int count = 2;
    static class Node
    {
        int val;
        Node left;
        Node right;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int burnTree(Node root, Node target) {
        if (target.val == root.val && target.left == root.left && target.right == root.right) return 99999;
        if (target.left!=null) count++;
        if (target.right!=null) count++;
        return count;
    }
}
