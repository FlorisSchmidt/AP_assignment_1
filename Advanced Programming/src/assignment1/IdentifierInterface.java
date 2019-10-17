package assignment1;

public interface IdentifierInterface {
    /*
    Elements: characters of type char saved in a stingbuffer
    Structure: Linear
    Domain: Only alphanumeric characters, identifier begins with a letter,
            identifier has length of at least 1 character

     constructors

        * Identifier(); *
    *   PRE  -
    *   POST -A new Identifier has been made and contains the character x *
    *
    *  Identifier
    *   PRE  -  *
    *       POST - A new Identifier-object has been made and contains a copy of src.
    *
    */

    void init();
    /* PRE  -
       POST - Identifier has one char
     */

    boolean add(char c);
    /* PRE  -
       POST - true: the char falls inside the domain and is added.
       		  false: the char falls outside of the domain and is not added.
     */

    String get();
    /* PRE  -
       POST - A concatenation of al chars in the identifier has been returned.
     */

    int size();
    /* PRE  -
       POST - the number of chars in the identifier has been returned.
     */

    boolean equals(Identifier comparand);
    /* PRE  -
       POST - true: The value of this identifier is equal to the value of the argument identifier.
       		  false: The value of this identifier is not equal to the value of the argument identifier.
     */

}
