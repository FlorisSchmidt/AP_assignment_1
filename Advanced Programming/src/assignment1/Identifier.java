package assignment1;

public interface Identifier {
    /*
    Elements: characters of type char (Sla op in stringbuffer!)
    Structure: Linear
    Domain: Only alphanumeric characters, identifier begins with a letter,
            identifier has length of at least 1 character

     constructors

        * Identifier(); *
        PRE  -
        *   POST -A new Identifier has been made and contains the character x *
        *
        Identifie
        PRE  -  *
         POST - A new NumberStack-object has been made and contains a copy of src.

    */
    void init(char c);
    // empties array and places chracter c

    String get();

    int size();

    boolean equals();



}
