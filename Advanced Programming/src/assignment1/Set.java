package assignment1;

public class Set implements SetInterface {

    private Identifier[] setArray;

    Set() {
        setArray = new Identifier[20];
    }

    private Set(Set src) {
        setArray = new Identifier[20];
        for (int i = 0; i < src.size(); i++) {
            String idtString = src.setArray[i].get();
            Identifier idt = new Identifier();
            for (char c : idtString.toCharArray()) {
                idt.add(c);
            }
            setArray[i] = idt;
        }
    }

    @Override
    public void init() {
        setArray = new Identifier[setArray.length];
    }

    @Override
    public boolean add(Identifier e) {
        if (size() < 20 && !(contains(e))) {
            setArray[size()] = e;
            return true;
        }
        return false;
    }

    @Override
    public Identifier get() {
        if (size() == 0) return null;
        Identifier element = setArray[size() - 1];
        setArray[size() - 1] = null;
        return element;
    }

    @Override
    public boolean contains(Identifier e) {
        if (size() == 0) return false;
        for (int i = 0; i < size(); i++)
            if (setArray[i].get().equals(e.get())) {
                return true;
            }
        return false;
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < setArray.length; i++) {
            if (setArray[i] == null) {
            } counter++;
        }
        return counter;
    }


    @Override
    public boolean equals(Set s) {
        if (!(size() == s.size())) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            if (!s.contains(setArray[i])) {
                System.out.println(i);
                return false;
            }
        }
        return true;
    }

    @Override
    public Set union(Set s) {
        Set union = new Set(this);
        Set subject = new Set(s);
        for (int i = 0; i < s.size(); i++) {
            Identifier idt = subject.get();
            union.add(idt);
        }
        return union;
    }

    @Override
    public Set difference(Set s) {
        Set differences = new Set();
        Set subject = new Set(this);
        for (int i = 0; i < size(); i++) {
            Identifier idt = subject.get();
            if (!s.contains(idt)) {
                differences.add(idt);
            }
        }
        return differences;
    }

    @Override
    public Set intersection(Set s) {
        Set intersect = new Set();
        Set subject = new Set(this);
        for (int i = 0; i < size(); i++) {
            Identifier idt = subject.get();
            if (s.contains(idt)) {
                intersect.add(idt);
            }
        }
        return intersect;
    }


    @Override
    public Set symDifference(Set s) {
        Set symDif = new Set();
        Set subject = new Set(this);
        Set comparand = new Set(s);
        for (int i = 0; i < size(); i++) {
            Identifier subIdt = subject.get();
            Identifier comIdt = comparand.get();
            if (!s.contains(subIdt)) {
                symDif.add(subIdt);
            }
            if (!contains(comIdt)) {
                symDif.add(comIdt);
            }
        }
        return symDif;
    }
}
