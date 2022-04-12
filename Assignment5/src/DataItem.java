//author: Usman Khan
//This class represents the data items that will be stored in the internal nodes of the binary search
//tree implementing the ordered dictionary. Each object of this class will have two instance variables:
//Key theKey and String content.

public class DataItem {
    Key theKey;
    String content;

    public DataItem(Key k, String data) {
        this.theKey = k;
        this.content = data;
    }

    public Key getKey()
    {
        return theKey;
    }
    public String getContent()
    {
        return content;
    }

    @Override
    public String toString() {
        Key key = theKey;
        return key.getName() + "," + key.getKind() + "," + content;
    }
}
