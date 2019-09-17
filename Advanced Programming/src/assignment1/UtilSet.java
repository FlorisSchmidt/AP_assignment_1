package assignment1;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class UtilSet {

    private Set<Character> set;

    UtilSet() {
      set = createSet();
    }

    private Set<Character> createSet() {
        Set<Character>  set = new HashSet<>();
        return set;
    }

    boolean add(Character e) {
        return set.add(e);
    }

    Object[] getValues() {
        return set.toArray();
    }

    void clear() {
        set.clear();
    }

    public boolean contains(Character c) {
        return set.contains(c);
    }

    boolean isEmpty() {
        return set.isEmpty();
    }

    boolean remove(Character c) {
        return set.remove(c);
    }

    public int size() {
        return set.size();
    }

    public Iterator<Character> iterator() {
        return set.iterator();
    }
}
