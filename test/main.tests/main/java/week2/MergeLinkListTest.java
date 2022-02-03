package main.java.week2;

import main.java.model.CustomLinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;


public class MergeLinkListTest {
    CustomLinkedList[] linkedLists;
    Random random = new Random();
    int n = 3;
    int max = 20;

    @Before
    public void setUp() throws Exception {
        linkedLists = new CustomLinkedList[n];
        for (int i = 0; i < n; i++) {
            linkedLists[i] = new CustomLinkedList();
            linkedLists[i].addNode(random.nextInt(max + 1));
            linkedLists[i].addNode(random.nextInt(max + 1));
            linkedLists[i].addNode(random.nextInt(max + 1)*-1);
            linkedLists[i].addNode(random.nextInt(max + 1)*-1);
        }
    }

    @After
    public void tearDown() throws Exception {
        linkedLists = null;
        random = null;
    }

    @Test
    public void mergeKLists() {
        MergeLinkList.mergeLinkList(linkedLists).printList();
    }
}