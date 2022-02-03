package main.java.week2;

import main.java.model.CustomLinkedList;

public class MergeLinkList {
    static CustomLinkedList result = new CustomLinkedList();
    static CustomLinkedList negatives = new CustomLinkedList();

    /**
     * <h1>Functional + BubbleSort</h1>
     * <h2>Time Complexity = TBC</h2>
     * <h2>Space Complexity = TBC</h2>
     * @param linkLists - arr of linked lists
     * @return - a merged linked list
     */
    static CustomLinkedList mergeLinkList(CustomLinkedList[] linkLists) {
        for (CustomLinkedList linkList : linkLists) {
            for (int j = 0; j < linkList.getSize(); j++){
                if(linkList.getDataByIndex(j)>=0) {
                    result.addNode(linkList.getDataByIndex(j));
                    continue;
                }
            negatives.addNode(linkList.getDataByIndex(j));
            }
        }
        result.bubbleSort("");
        negatives.bubbleSort("reverse");
        for (int i = 0; i < negatives.getSize(); i++){
                result.addNode(negatives.getDataByIndex(i));
            }
        return result;
    }
}