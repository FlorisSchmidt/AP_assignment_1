package assignment1;

public class Set implements SetInterface {

    private Identifier[] setArray;
    private int index;

    public Set() {
        setArray = new Identifier[20];
    }

    Set(Set src) {
        Set setCopy = new Set();
        for (Identifier i : src.setArray) {
            setCopy.add(i);
        }
        index = src.index;
    }

    @Override
    public void init() {
        setArray = new Identifier[setArray.length];
    }

    @Override
    public boolean add(Identifier e) {
        if (size() < 20 && !(contains(e))) {
            setArray[index] = e;
            index++;
            return true;
        }
        return false;
    }

    @Override
    public Identifier get() {
        Identifier element = setArray[size()-1];
        setArray[size()-1] = null;
        return element;
    }

    @Override
    public boolean contains(Identifier e) {
        for (Identifier i : setArray) {
            if (i == e) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < setArray.length; i++) {
            if (setArray[i] != null) {
                counter++;
            }
            else {
                break; }
        }
        return counter;
    }


    @Override
    public boolean equals(Set s) {
        if (!(size() == s.size())) {
            return false;
        }
        for (Identifier i : setArray) {
            if (!s.contains(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Set union(Set s) {
        Set setCopy = new Set(this);
        return null;
    }

    @Override
    public Set difference(Set s) {
        return null;
    }

    @Override
    public Set intersection(Set s) {
        return null;
    }

    @Override
    public Set symDifference(Set s) {
        return null;
    }
}
