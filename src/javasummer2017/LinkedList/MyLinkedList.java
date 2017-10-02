package javasummer2017.LinkedList;

public class MyLinkedList {
    /**
     * Дописать класс MyLinkedList и протестировать его.
     */

    private Element _head;
    private Element _tail;
    private long _size;

    public MyLinkedList() {
        _head = null;
        _tail = null;
        _size = 0;
    }


    private void addToEmptyList(Element newElement) {
        newElement.next = null;
        newElement.prev = null;
        _tail = newElement;
        _head = newElement;
        _size++;
    }

    public void addToTail(int data) {
        Element newElement = new Element(data);
        if (_size == 0) {
            addToEmptyList(newElement);
        } else {
            newElement.prev = _tail;
            _tail.next = newElement;
            _tail = newElement;
            _size++;
        }
    }

    public void addToHead(int data) {
        Element newElement = new Element(data);
        if (_size == 0) {
            addToEmptyList(newElement);
        } else {
            newElement.next = _head;
            _head.prev = newElement;
            _head = newElement;
            _size++;
        }
    }

    public void add(int data, long index) {
        Element newElement = new Element(data);
        if (index < 0 || index > _size) {
            System.err.println("Выход за границы списка.");
            return;
        }
        if (index == 0) {
            addToHead(data);
            return;
        }
        if (index == _size) {
            addToTail(data);
            return;
        }

        Element prevElement = getElement(index - 1);
        Element nextElement = prevElement.next;
        newElement.prev = prevElement;
        prevElement.next = newElement;
        newElement.next = nextElement;
        nextElement.prev = newElement;
        _size++;
    }


    public void replace(int newData, long index) {
        if (index < 0 || index > _size) {
            System.err.println("Выход за границы списка.");
            return;
        }
        if (index == 0) {
            deleteFromHead();
            addToHead(newData);
            return;
        }
        if (index == _size - 1) {
            deleteFromTail();
            addToTail(newData);
            return;
        }
        Element newElement = new Element(newData);
        Element element = getElement(index);
        Element prevElement = element.prev;
        Element nextElement = element.next;
        newElement.prev = prevElement;
        prevElement.next = newElement;
        element.prev = null;
        newElement.next = nextElement;
        nextElement.prev = newElement;
        element.next = null;
    }


    public void deleteFromTail() {
        if (_size == 0) {
            System.err.println("Linked list is empty.");
            return;
        }
        if (_size == 1) {
            _head = null;
            _tail = null;
            _size = 0;
        } else {
            Element element = _tail;
            _tail = _tail.prev;
            element.prev = null;
            _tail.next = null;
            _size--;
        }
    }

    public void deleteFromHead() {
        if (_size == 0) {
            System.err.println("Linked list is empty.");
            return;
        }
        if (_size == 1) {
            _head = null;
            _tail = null;
            _size = 0;
        } else {
            Element element = _head;
            _head = _head.next;
            element.next = null;
            _head.prev = null;
            _size--;
        }
    }

    public void delete(long index) {
        if (index < 0 || index > _size) {
            System.err.println("Выход за границы списка.");
            return;
        }
        if (index == 0) {
            deleteFromHead();
            return;
        }
        if (index == _size - 1) {
            deleteFromTail();
            return;
        }

        Element element = getElement(index);
        Element prevElement = element.prev;
        Element nextElement = element.next;
        prevElement.next = nextElement;
        element.prev = null;
        nextElement.prev = prevElement;
        element.next = null;
        _size--;
    }

    public long size() {                    //написать метод
        return _size;
    }

    private Element getElement(long index) {
        long middle = _size / 2;
        if (index <= middle) {
            return searchFromHead(index);
        }

        return searchFromTail(index);
    }

    private Element searchFromTail(long index) {
        Element result = _tail;
        long steps = _size - 1 - index;
        for (long i = 0; i < steps; ++i) {
            result = result.prev;
        }

        return result;
    }

    private Element searchFromHead(long index) {
        Element result = _head;
        for (long i = 0; i < index; ++i) {
            result = result.next;
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Element currentElement = _head;
        for (int i = 0; i < _size - 1; ++i) {
            stringBuilder.append(currentElement.content).append(", ");
            currentElement = currentElement.next;
        }
        if (currentElement != null) {
            stringBuilder.append(currentElement.content);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


    private static class Element {
        Element prev;
        int content;
        Element next;

        Element(int content) {
            this.content = content;
        }
    }


}



