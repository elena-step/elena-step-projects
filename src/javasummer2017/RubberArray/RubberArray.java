package javasummer2017.RubberArray;


import java.util.Arrays;

/**
 * Создать класс резинового массива,
 * который умеет расширяться или сужаться по необходимости.
 */

public class RubberArray {
    private static final int INCREASE_OF_ARRAY = 10;

    private int _size;
    private int[] _rubberArray;
    private int _counter = 0;


    RubberArray() {
        this(1);
    }

    RubberArray(int size) {
        _rubberArray = new int[size];
        _size = size;
    }

    RubberArray(int[] someArray) {
        setRubberArray(someArray);
    }


    public int getSize() {
        return _size;
    }

    public int[] getRubberArray() {
        return _rubberArray.clone();
    }

    public int getCounter() {
        return _counter;
    }


    public void setRubberArray(int[] someArray) {
        if (someArray.length != _size) {
            _size = someArray.length;
        }
        _rubberArray = someArray.clone();
        _counter = _size;

    }

    public void replaceOneValue(int value, int index) {
        if (isIndexValid(index)) {
            _rubberArray[index] = value;
        } else printIndexOutOfBounds();
    }

    public void addOneValue(int value) {
        if (_counter == _size) {
            increaseArray();
        }
        _rubberArray[_counter] = value;
        _counter++;
    }


    public void addOneValueWithIndex(int value, int index) {
        if (index >= _size) {
            increaseArray();
        }
        if (index == _size - 1) {
            replaceOneValue(value, index);
        } else {
            shiftRight(index);
            replaceOneValue(value, index);
        }
        _counter++;
    }


    public void deleteOneValue(int index) {
        if (index == _size - 1) {
            cutArrayLastElement();
        } else {
            shiftLeft(index);
            cutArrayLastElement();
        }

    }


    public void cutArray(int cutCapacity) {
        int newCapacity = _size - cutCapacity;
        int[] temp = Arrays.copyOf(_rubberArray, newCapacity);
        _size = _size - cutCapacity;
        _counter = _counter - cutCapacity;
        _rubberArray = temp;
    }


    public int getElement(int index) {
        int result = 0;
        if (isIndexValid(index)) {
            result = _rubberArray[index];
            return result;
        } else printIndexOutOfBounds();
        return Integer.MIN_VALUE;
    }


    public int getIndexFirstMatch(int value) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < _size; i++) {
            if (_rubberArray[i] == value) {
                result = i;
                break;
            }
        }
        if (result == Integer.MIN_VALUE) {
            System.out.println("No matches.");

        }
        return result;
    }


    public int getIndexLastMatch(int value) {
        int result = Integer.MIN_VALUE;
        for (int i = _size - 1; i >= 0; i--) {
            if (_rubberArray[i] == value) {
                result = i;
                break;
            }
        }
        if (result == Integer.MIN_VALUE) {
            System.out.println("No matches.");

        }
        return result;
    }

    private void shiftRight(int index) {
        if (isIndexValid(index)) {
            for (int i = _size - 1; i > index; i--) {
                _rubberArray[i] = _rubberArray[i - 1];
            }
        } else printIndexOutOfBounds();
    }


    private void shiftLeft(int index) {
        if (isIndexValid(index)) {
            for (int i = index + 1; i < _size; i++) {
                _rubberArray[i - 1] = _rubberArray[i];
            }
        } else printIndexOutOfBounds();
    }


    private void increaseArray() {
        int[] temp = new int[_size + INCREASE_OF_ARRAY];
        temp = Arrays.copyOf(_rubberArray, _size + INCREASE_OF_ARRAY);
        _size = _size + INCREASE_OF_ARRAY;
        _rubberArray = temp;
    }

    private void cutArrayLastElement() {
        int[] temp = Arrays.copyOf(_rubberArray, _size - 1);
        _size--;
        _counter--;
        _rubberArray = temp;
    }


    private boolean isIndexValid(int index) {

        return index >= 0 && index < _size;
    }

    private void printIndexOutOfBounds() {
        System.err.println("Error: index out of bound.");
    }


    @Override
    public String toString() {
        return Arrays.toString(_rubberArray);
    }


}



