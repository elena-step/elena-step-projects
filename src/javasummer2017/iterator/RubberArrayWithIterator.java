package javasummer2017.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Релизовать интерфейс Iterable для класса резинового массива,
 * который был написан в одном из предыдущих ДЗ.
 */

public class RubberArrayWithIterator implements Iterable<Integer> {

    private int _size;
    private Integer[] _rubberArray;


    RubberArrayWithIterator() {
        this(1);
    }

    RubberArrayWithIterator(int size) {
        setSize(size);
        _rubberArray = new Integer[size];
    }

    RubberArrayWithIterator(Integer[] someArray) {
        setSize(someArray.length);
        setRubberArray(someArray);
    }


    public int getSize() {
        return _size;
    }

    public void setSize(int size) {
        _size = size;
    }


    public Integer[] getRubberArray() {
        return _rubberArray.clone();
    }

    public void setRubberArray(Integer[] someArray) {
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
        Integer[] temp = new Integer[_size + 1];
        temp = Arrays.copyOf(_rubberArray, _size + 1);
        _size = _size + 1;
        _rubberArray = temp;
    }

    private void cutArrayLastElement() {
        Integer[] temp = new Integer[_size - 1];
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

    @Override
    public Iterator<Integer> iterator() {
        return new RubberArrayIterator(this);
    }


    private static class RubberArrayIterator implements Iterator<Integer> {

        private RubberArrayWithIterator _rubberArrayWithIterator;
        private int _cursor = 0;

        RubberArrayIterator(RubberArrayWithIterator someRubberArray) {
            _rubberArrayWithIterator = someRubberArray;
        }

        @Override
        public boolean hasNext() {
            System.out.println("hasNext");
           /* if (_cursor == 0) {
                return _rubberArrayWithIterator._size > 0;
            }

            return _cursor < _rubberArrayWithIterator._size ;*/
            return _cursor < _rubberArrayWithIterator._size - 1;
        }

        @Override
        public Integer next() {
            System.out.println("next");
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
           // if (_cursor == 0) {
            //    return;
           // }
            return null;
        }
    }
}
