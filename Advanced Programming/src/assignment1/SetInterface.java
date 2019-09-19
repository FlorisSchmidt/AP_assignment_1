package assignment1;

public interface SetInterface {
    /*
    * Elements: identifiers of the type Identifier
    * Structure: none
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

    boolean add(Identifier e);
    /*  PRE - The size of the set is less than 20
        POST - A copy of the element has been added to the set
     */

    Identifier get();
    /*  PRE - The set is not empty
        POST - Returns and removes an Identifier element from the set
     */

    boolean contains(Identifier e);
    /*  PRE -
        POST -  true: The set contains the specified element
                false: The set does not contain the specified element
     */

    int size();
    /*  PRE -
        POST - The amount of elements in the set has been returned
     */

    boolean equals(Set s);
    /*  PRE -
        POST -  true: Argument set and this set are the same size and contain the same elements
                false: Argument set and this set are not the same size or do not contain the same elements
     */

    Set union(Set s);
    /*  PRE -
        POST - A set containing the union of the argument set and this.
     */

    Set difference(Set s);
    /*  PRE -
        POST - A set containing the difference of the argument and this.
     */

    Set intersection(Set s);
    /*  PRE -
        POST - A set containing the intersection of the argument and this.
     */

    Set symDifference(Set s);
    /*  PRE -
        POST - A set containing the symmetric difference between the argument set
     */
}