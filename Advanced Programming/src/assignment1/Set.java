package assignment1;

public class Set implements SetInterface {

    private Identifier[] setArray;
    private static int MAX_NUMBER_OF_ELEMENTS = 20;
    private int size;

    Set() {
        setArray = new Identifier[MAX_NUMBER_OF_ELEMENTS];
        size = 0;
    }

    private Set(Set src) {
        setArray = new Identifier[20];
        for (int i = 0; i < src.size(); i++) {
            Identifier idt  = new Identifier(src.setArray[i]);
            setArray[i] = idt;
        }
        size = src.size;
    }

    @Override
    public void init() {
        setArray = new Identifier[MAX_NUMBER_OF_ELEMENTS];
        size = 0;
    }

    @Override
    public boolean add(Identifier e) {
        if (size < 20 && !(contains(e))) {
            setArray[size] = e;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public Identifier get() {
        if (size == 0) return null;
        Identifier element = setArray[size() - 1];
        setArray[size() - 1] = null;
        size--;
        return element;
    }

    @Override
    public boolean contains(Identifier e) {
        if (size == 0) return false;
        for (int i = 0; i < size; i++) {
            if (setArray[i].get().equals(e.get())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean equals(Set s) {
        if (!(size == s.size())) {
            return false;
        }
        for (int i = 0; i < size; i++) {
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
        for (int i = 0; i < size; i++) {
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
        for (int i = 0; i < size; i++) {
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
        for (int i = 0; i < size; i++) {
            String idx = Integer.toString(i);
            Identifier subIdt = subject.get();
            String str = subIdt.get();
            if (!s.contains(subIdt)) {
                symDif.add(subIdt);
            }
        }
        for (int j = 0; j < s.size; j++) {
            Identifier comIdt = comparand.get();
            if (!contains(comIdt)) {
                symDif.add(comIdt);
                }
            }
        return symDif;
    }
}
