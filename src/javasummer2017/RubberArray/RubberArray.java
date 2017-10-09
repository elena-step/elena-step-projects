package javasummer2017.RubberArray;


import java.util.Arrays;

/**
 * Создать класс резинового массива,
 * который умеет расширяться или сужаться по необходимости.
 */

public class RubberArray {

    private int _size;
    private int[] _rubberArray;


    RubberArray() {
        this(1);
    }

    RubberArray(int size) {
        setSize(size);
        _rubberArray = new int[size];
    }

    RubberArray(int[] someArray) {
        setSize(someArray.length);
        setRubberArray(someArray);
    }


    public int getSize() {
        return _size;
    }

    public void setSize(int size) {
        _size = size;
    }


    public int[] getRubberArray() {
        return _rubberArray.clone();
    }

    public void setRubberArray(int[] someArray) {
        if (someArray.length == _size) {
            _rubberArray = someArray.clone();
        } else printErrorLength();

    }


    public void replaceOneValue(int value, int index) {
        if (isIndexValid(index)) {
            _rubberArray[index] = value;
        } else printIndexOutOfBounds();
    }


    public void addOneValue(int value, int index) {
        increaseArrayOneElement();
        if (index == _size - 1) {
            replaceOneValue(value, index);
        } else {
            shiftRight(index);
            replaceOneValue(value, index);
        }
    }


    public void deleteOneValue(int index) {
        if (index == _size - 1) {
            cutArrayLastElement();
        } else {
            shiftLeft(index);
            cutArrayLastElement();
        }

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
        for (int i = 0; i < _size; i++) {
            if (_rubberArray[i] == value) {
                result = i;
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


    private void increaseArrayOneElement() {
        int[] temp = new int[_size + 1];
        temp = Arrays.copyOf(_rubberArray, _size + 1);
        _size = _size + 1;
        _rubberArray = temp;
    }

    private void cutArrayLastElement() {
        int[] temp = new int[_size - 1];
        temp = Arrays.copyOf(_rubberArray, _size - 1);
        _size = _size - 1;
        _rubberArray = temp;
    }

    private boolean isIndexValid(int index) {

        return index >= 0 && index < _size;
    }

    private void printIndexOutOfBounds() {
        System.err.println("Error: index out of bound.");
    }

    private void printErrorLength() {
        System.out.println("Length of array is not correct.");
    }

    @Override
    public String toString() {
        return Arrays.toString(_rubberArray);
    }


}



