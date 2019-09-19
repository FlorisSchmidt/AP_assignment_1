package assignment1;

public class Set implements SetInterface {

    private Identifier[] setArray;
    private int index;

    public Set() {
        this.setArray = new Identifier[20]
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
        if (setArray.length < 20 && !(this.contains(e))) {
            setArray[index] = e;
            index++;
            return true;
        }
        return false;
    }

    @Override
    public Identifier get() {
        Identifier element = this.setArray[this.size()];
        this.setArray[this.size()] = null;
        return element;
    }

    @Override
    public boolean contains(Identifier e) {
        for (Identifier i : this.setArray) {
            if (i == e) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < this.setArray.length; i++) {
            if (this.setArray[i] != null) {
                counter++;
            }
            else {
                break; }
        }
        return counter;
    }


    @Override
    public boolean equals(Set s) {
        if (!(this.size() == s.size())) {
            return false;
        }
        for (Identifier i : this.setArray) {
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
