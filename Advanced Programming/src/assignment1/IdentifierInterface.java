package assignment1;

public interface IdentifierInterface {
    /*
    Elements: characters of type char saved in a stingbuffer
    Structure: Linear
    Domain: Only alphanumeric characters, identifier begins with a letter,
            identifier has length of at least 1 character

     constructors

        * Identifier(); *
        PRE  -
        *   POST -A new Identifier has been made and contains the character x *
        *
        Identifier
        PRE  -  *
        POST - A new Identifier-object has been made and contains a copy of src.

    */
	
    void init(char c);
    /*
     * PRE - 
     * POST - Identifier has one char
     */

    String get();
    /*
     * PRE - 
     * POST - The string that makes up the identifier has been returned
     */

    int size();
    /*
     * PRE - 
     * POST - the size of the Identifier is returned
     */

    boolean equals();
    /*
     * PRE - the identifiers need to have the same size
     * POST - true: The identifier is the same as the identifier passed
     * 		  false: The identifier is not the same as the identifier passed
     */

}
