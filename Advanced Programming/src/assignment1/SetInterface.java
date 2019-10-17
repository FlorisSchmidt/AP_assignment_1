package assignment1;

public interface SetInterface {
    /*
    * Elements: Identifiers of the type Identifier
    * Structure: None
    * Domain: All elements must be unique, contains [0-20] identifiers. Identifiers have a length of 1.
    *
    * constructors
    *
    * Set();
    *   PRE  -
    *   POST - A new Set-object has been made and contains the empty set.
    *
    * Set (Set src);
    *   PRE  -
    *   POST - A new Set-object has been made and contains a copy of src.
    */


    void init();
    /*  PRE -
        POST - The set is empty
     */

    boolean add (Identifier e);
    /*  PRE -
        POST - If Set-PRE had a size < 20 the element is present in set-POST.
               Returns true if the element has been added.
               Returns false if the element was already present in set-PRE or set size exceeded 19.
     */

    Identifier get();
    /*  PRE -
        POST - An element from the set has been returned.
               If the set was empty, null has been returned.
     */

    boolean contains(Identifier e);
    /*  PRE -
        POST -  true: The set contains the identifier passed as argument.
                false: The set does not contain identifier passed as argument.
     */

    int size();
    /*  PRE -
        POST - The amount of elements in the set has been returned.
     */

    boolean equals(Set s);
    /*  PRE -
        POST -  true: Argument set and this set are the same size and contain the same elements.
                false: Argument set and this set are not the same size or do not contain the same elements.
     */

    Set union(Set s);
    /*  PRE -
        POST - A set containing the union of the argument set and this has been returned.
     */

    Set difference(Set s);
    /*  PRE -
        POST - A set containing the difference of the argument and this has been returned.
     */

    Set intersection(Set s);
    /*  PRE -
        POST - A set containing the intersection of the argument set and this has been returned.
     */

    Set symDifference(Set s);
    /*  PRE -
        POST - A set containing the symmetric difference between the argument set and this has been returned.
     */
}