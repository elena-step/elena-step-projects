package javasummer2017.LinkedList;

public class ListMain {


    public static void main(String[] args) {
//        testAddToTail();
//        testAddIncorrectIndex();
//        testAddIndexBounds();
//        testAddInside();
//        testAddToHead();
//        testDeleteFromHead();
//        testDeleteFromTail();
        testDeleteInside();
//        testReplace();
//        testGet();
    }


    private static void testGet(){
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addToTail(1);
        myLinkedList.addToTail(2);
        myLinkedList.addToTail(3);
        myLinkedList.addToTail(4);
        myLinkedList.addToTail(5);
        System.out.println(myLinkedList.get(1L));
        System.out.println(myLinkedList.get(4L));
        System.out.println(myLinkedList.get(100L));
        System.out.println("testGet passed.");
    }

    private static void testReplace() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addToTail(1);
        myLinkedList.addToTail(2);
        myLinkedList.addToTail(3);
        myLinkedList.addToTail(4);
        myLinkedList.addToTail(5);
        System.out.println(myLinkedList);
        myLinkedList.replace(30, 2L);
        System.out.println(myLinkedList);
        myLinkedList.replace(10, 0);
        System.out.println(myLinkedList);
        myLinkedList.replace(40, 3L);
        System.out.println(myLinkedList);
        myLinkedList.replace(50, 4L);
        System.out.println(myLinkedList);
        myLinkedList.replace(101, 7L);
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
        myLinkedList.delete(1L);
        System.out.println(myLinkedList);
        myLinkedList.delete(2L);
        System.out.println(myLinkedList);
        myLinkedList.delete(0);
        System.out.println(myLinkedList);
        myLinkedList.delete(2L);
        System.out.println(myLinkedList);
        myLinkedList.delete(5L);
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
        myLinkedList.add(50, 2L);
        myLinkedList.add(60, 4L);
        myLinkedList.add(101, 6L);
        myLinkedList.add(102, 0);
        System.out.println(myLinkedList);
        System.out.println("testAddInside passed.");
    }

    private static void testAddIndexBounds() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(0, 0);
        myLinkedList.add(2, 1L);
        myLinkedList.add(4, 2L);
        myLinkedList.add(-2, 0);
        System.out.println(myLinkedList);
        System.out.println("testAddIndexBounds  passed.");

    }

    private static void testAddIncorrectIndex() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(5, -2L);
        myLinkedList.add(6, 3L);
        System.out.println("testAddIncorrectIndex passed.");
    }


}



