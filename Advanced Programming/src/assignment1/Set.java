package assignment1;
import java.util.List;

import java.util.Iterator;

public class Set implements SetInterface {

    private char[] setArray;
    public int size;

    UtilSet() {
        setArray = new char[10];
        size = 0;
    }

    private boolean contains(char[] array, int v) {
        boolean result = false;
        for (int i : array) {
            if (i == v) {
                result = true;
                break;
            }
        }

        return result;
    }
    public boolean add(char e) {
        if (!contains(setArray, e)) {
            setArray[size] = e;
            size += 1;
            return true; }

        return false;
        }

    char[] getValues() {
        return setArray;
    }

    void clear() {
        setArray = null;
    }

    boolean isEmpty() {
        for (Object ob : setArray) {
            if (ob != null) {
                return false;
            }
        }
        return true;
    }

    boolean remove(Character c) {
        return set.remove(c);
    }

    public Iterator<Character> iterator() {
        return set.iterator();
    }
}
