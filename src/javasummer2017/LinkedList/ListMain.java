package javasummer2017.LinkedList;

public class ListMain {


    public static void main(String[] args) {
        testAddToTail();
        testAddIncorrectIndex();
        testAddIndexBounds();
        testAddInside();
        testAddToHead();
        testDeleteFromHead();
        testDeleteFromTail();
        testDeleteInside();
        testReplace();
    }


    private static void testReplace() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addToTail(1);
        myLinkedList.addToTail(2);
        myLinkedList.addToTail(3);
        myLinkedList.addToTail(4);
        myLinkedList.addToTail(5);
        System.out.println(myLinkedList);
        myLinkedList.replace(30, 2);
        System.out.println(myLinkedList);
        myLinkedList.replace(10, 0);
        System.out.println(myLinkedList);
        myLinkedList.replace(40, 3);
        System.out.println(myLinkedList);
        myLinkedList.replace(50, 4);
        System.out.println(myLinkedList);
        System.out.println("testReplace passed.");
    }

    private static void testDeleteInside() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addToTail(1);
        myLinkedList.addToTail(2);
        myLinkedList.addToTail(3);
        myLinkedList.addToTail(4);
        myLinkedList.addToTail(5);
        myLinkedList.addToHead(-1);
        System.out.println(myLinkedList);
        myLinkedList.delete(1);
        System.out.println(myLinkedList);
        myLinkedList.delete(2);
        System.out.println(myLinkedList);
        myLinkedList.delete(0);
        System.out.println(myLinkedList);
        myLinkedList.delete(2);
        System.out.println(myLinkedList);
        System.out.println("testDeleteInside passed.");
    }

    private static void testDeleteFromTail() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addToHead(4);
        myLinkedList.addToHead(3);
        myLinkedList.addToHead(2);
        myLinkedList.addToHead(1);
        System.out.println(myLinkedList);
        myLinkedList.deleteFromTail();
        System.out.println(myLinkedList);
        myLinkedList.deleteFromTail();
        System.out.println(myLinkedList);
        myLinkedList.deleteFromTail();
        System.out.println(myLinkedList);
        myLinkedList.deleteFromTail();
        System.out.println(myLinkedList);
        myLinkedList.deleteFromTail();
        System.out.println(myLinkedList);
        System.out.println("testDeleteFromTail passed.");
    }

    private static void testDeleteFromHead() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addToHead(4);
        myLinkedList.addToHead(3);
        myLinkedList.addToHead(2);
        myLinkedList.addToHead(1);
        System.out.println(myLinkedList);
        myLinkedList.deleteFromHead();
        System.out.println(myLinkedList);
        myLinkedList.deleteFromHead();
        System.out.println(myLinkedList);
        myLinkedList.deleteFromHead();
        System.out.println(myLinkedList);
        myLinkedList.deleteFromHead();
        System.out.println(myLinkedList);
        myLinkedList.deleteFromHead();
        System.out.println(myLinkedList);
        myLinkedList.deleteFromHead();
        System.out.println(myLinkedList);
        System.out.println("testDeleteFromHead passed.");
    }

    private static void testAddToHead() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addToHead(4);
        myLinkedList.addToHead(3);
        myLinkedList.addToHead(2);
        myLinkedList.addToHead(1);
        System.out.println(myLinkedList);
        System.out.println("testAddToHead passed.");
    }

    private static void testAddToTail() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addToTail(5);
        myLinkedList.addToTail(6);
        myLinkedList.addToTail(7);
        myLinkedList.addToTail(8);
        System.out.println(myLinkedList);
        System.out.println("testAddToTail passed.");
    }

    private static void testAddInside() {
        MyLinkedList myLinkedList = new MyLinkedList();
        System.out.println(myLinkedList);
        myLinkedList.addToTail(1);
        myLinkedList.addToTail(2);
        myLinkedList.addToTail(3);
        myLinkedList.addToTail(4);
        myLinkedList.add(50, 2);
        myLinkedList.add(60, 4);
        System.out.println(myLinkedList);
        System.out.println("testAddInside passed.");
    }

    private static void testAddIndexBounds() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(0, 0);
        myLinkedList.add(2, 1);
        myLinkedList.add(4, 2);
        myLinkedList.add(-2, 0);
        System.out.println(myLinkedList);
        System.out.println("testAddIndexBounds  passed.");

    }

    private static void testAddIncorrectIndex() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(5, -2);
        myLinkedList.add(6, 3);
        System.out.println("testAddIncorrectIndex passed.");
    }


}



