package javasummer2017.iterator;


import java.util.Arrays;

public class MainRubberArrayWithIterator {


        public static void main(String[] args) {

            testMakeRubberArray();
            //testAddOneValue();
            //testDeleteOneValue();
            //testGetElement();
            //testIncorrectIndex();
            //testGetIndexFirstMatch();
            //testGetIndexLastMatch();
        }


        private static void testMakeRubberArray() {
            System.out.println("Созданы и инициализированы объекты типа RubberArrayWithIterator");
            System.out.println("(с использованием различных конструкторов):");

            RubberArrayWithIterator rubberArray1 = new RubberArrayWithIterator();
            rubberArray1.replaceOneValue(10, 0);
            System.out.println(rubberArray1);

            Integer[] arr3 = {9, 8, 7};
            RubberArrayWithIterator rubberArray3 = new RubberArrayWithIterator(arr3.length);
            rubberArray3.setRubberArray(arr3);
            System.out.println(rubberArray3);

            RubberArrayWithIterator rubberArray5 = new RubberArrayWithIterator(5);
            rubberArray5.setRubberArray(arr3);
            Integer[] arr5 = {1, 2, 3, 4, 5};
            rubberArray5.setRubberArray(arr5);
            System.out.println(rubberArray5);

            Integer[] arr7 = {1, 2, 3, 4, 5, 6, 7};
            RubberArrayWithIterator rubberArray7 = new RubberArrayWithIterator(arr7);
            System.out.println(rubberArray7);
        }

        private static void testAddOneValue() {
            Integer[] arr = {11, 22};
            RubberArrayWithIterator rubberArray = new RubberArrayWithIterator(arr);
            System.out.println(rubberArray);
            rubberArray.addOneValue(33, 2);
            System.out.println(rubberArray);
            rubberArray.addOneValue(-11, 0);
            System.out.println(rubberArray);
            rubberArray.addOneValue(55, 4);
            System.out.println(rubberArray);
            rubberArray.addOneValue(44, 4);
            System.out.println(rubberArray);
            System.out.println("Test for method addOneValue passed.");
        }

        private static void testDeleteOneValue() {
            RubberArrayWithIterator rubberArray = new RubberArrayWithIterator(7);
            Integer[] arr = {11, 22, 33, 44, 55, 66, 77};
            rubberArray.setRubberArray(arr);
            System.out.println(rubberArray);
            System.out.println("size = " + rubberArray.getSize());
            rubberArray.deleteOneValue(rubberArray.getSize() - 1);
            System.out.println(rubberArray);
            rubberArray.deleteOneValue(0);
            System.out.println(rubberArray);
            rubberArray.deleteOneValue(2);
            System.out.println(rubberArray);
            System.out.println("After cut size = " + rubberArray.getSize());
            System.out.println("Test for method deleteOneValue passed.");
        }

        private static void testGetElement() {
            Integer[] arr = {1, 2, 3, 4, 5};
            RubberArrayWithIterator rubberArray = new RubberArrayWithIterator(arr);
            System.out.println(rubberArray);
            System.out.println(rubberArray.getElement(4));
            System.out.println(rubberArray.getElement(2));
            System.out.println(rubberArray.getElement(0));
            System.out.println("Test for method getElement passed.");
        }

        private static void testIncorrectIndex() {
            Integer[] arr = {1, 2, 3, 4, 5};
            RubberArrayWithIterator rubberArray = new RubberArrayWithIterator(arr);
            System.out.println(rubberArray);
            System.out.println(rubberArray.getElement(101));
            rubberArray.deleteOneValue(102);
            rubberArray.addOneValue(6, 103);
            System.out.println();
            System.out.println("Test for method incorrectIndex passed.");
        }

        private static void testGetIndexFirstMatch() {
            Integer[] arr = {1, 2, 3, 4, 5, 4, 3, 2, 1};
            RubberArrayWithIterator rubberArray = new RubberArrayWithIterator(arr);
            System.out.println(rubberArray);
            System.out.println(rubberArray.getIndexFirstMatch(1));
            System.out.println(rubberArray.getIndexFirstMatch(2));
            System.out.println(rubberArray.getIndexFirstMatch(15));
            System.out.println("Test for method getIndexFirstMatch passed.");
        }


        private static void testGetIndexLastMatch() {
            Integer[] arr = {1, 2, 3, 4, 5, 4, 3, 2, 1};
            RubberArrayWithIterator rubberArray = new RubberArrayWithIterator(arr);
            System.out.println(rubberArray);
            System.out.println(rubberArray.getIndexLastMatch(1));
            System.out.println(rubberArray.getIndexLastMatch(2));
            System.out.println(rubberArray.getIndexLastMatch(15));
            System.out.println("Test for method getIndexLasttMatch passed.");
        }
}
