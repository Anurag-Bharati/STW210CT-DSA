package main.java.model;

import java.util.Objects;

public class CustomLinkedList {

    public static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    public void addNode(int data) {

        if (head == null) {
            Node newnode = new Node(data);
            head = newnode;
            tail = head;

        } else {
            Node newnode = new Node(data);
            tail.next = newnode;
            tail = newnode;

        }

    }

    public int getSize() {
        int size = 0;
        Node current = head;

        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void bubbleSort(String order) {
        Node current = head, index = null;
        int temp;
        if (head != null) {
            while (current != null) {
                index = current.next;
                if (Objects.equals(order, "reverse")){
                    while (index != null) {
                        if (current.data < index.data) {
                            temp = current.data;
                            current.data = index.data;
                            index.data = temp;
                        }

                        index = index.next;
                    }
                }
                else {
                    while (index != null) {
                        if (current.data > index.data) {
                            temp = current.data;
                            current.data = index.data;
                            index.data = temp;
                        }
                        index = index.next;
                    }
                }


                current = current.next;
            }
        }
    }

    public int getDataByIndex(int i) {

        if (getSize() == 0 || i > getSize()) {

            System.out.println("please enter valid input");
            return -999999999;
        } else {
            Node current = head;
            for (int j = 1; j < i; j++) {
                current = current.next;
            }
            return current.data;
        }
    }


}