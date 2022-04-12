//author: Usman Khan
//This class represents the key attribute of the data items that will be stored in the internal nodes of
//the binary search tree implementing the ordered dictionary. Each object of this class will have two
//String instance variables: name and kind.

public class Key {
    String name;
    String kind;

    public Key(String word, String type) {
        word = word.toLowerCase();

        this.name = word;
        this.kind = type;
    }

    public String getName() { return this.name; }
    public String getKind() { return this.kind; }

    public int compareTo(Key k) {
        // name == k.name
        if (name.compareTo(k.getName()) == 0) {
            if (kind.equals(k.kind)) return 0;
            if (kind.compareTo(k.kind) < 0) return -1;
            else return 1;
        }

        // name < k.name:
        if (name.compareTo((k.getName())) < 0)
            return -1;

        // name > k.name:
        return 1;
    }
}

	
