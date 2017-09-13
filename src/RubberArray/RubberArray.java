package RubberArray;

public class RubberArray {

    private static final int DEFAULT_NUMBER = 1;
    private static final int DEFAULT_INDEX = 0;

    private int _number;
    private int _index;
    private int[] _rubberArray;

    RubberArray() {
        _number = DEFAULT_NUMBER;
        _index = DEFAULT_INDEX;
        RubberArray[] _rubberArray = new RubberArray[DEFAULT_NUMBER];
    }

    RubberArray(int number) {
        _number = number;
        _index = number - 1;
    }

}
