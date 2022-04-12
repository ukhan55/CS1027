//author: Usman Khan
//This class implements an ordered dictionary using a binary search tree. You must use a DataItem
//object to store the data contained in each node of the tree. In your binary search tree only the
//internal nodes will store information. The leaves will be nodes storing null DataItem objects.
//The key for an internal node will be the Key object from the DataItem stored in that node.



public class OrderedDictionary implements OrderedDictionaryADT {
    BinarySearchTree dict = new BinarySearchTree();

    public DataItem get(Key k) {
        Node rootNode = dict.getRoot();
        Node findNode = dict.get(rootNode, k);
        if (findNode == null) return null;
        else return findNode.getContent();
    }

    public DataItem successor(Key k) {
        Node rootNode = dict.getRoot();
        Node findNode = dict.get(rootNode, k);
        Node findSucc = dict.successor(findNode, k);

        if (findSucc == null)
            return null;
        else
            return findSucc.getContent();
    }

    public void put(DataItem d) throws DictionaryException {
        if (dict.get(dict.getRoot(), d.getKey()) != null) {
            // Key already exists
            throw new DictionaryException("Key is already in the dictionary");
        } else {
            Node newNode = new Node();
            Node left = new Node();
            Node right = new Node();

            newNode.setContent(d);
            newNode.setLeft(left);
            newNode.setRight(right);

            dict.put(newNode);
        }
    }

    public DataItem predecessor(Key k) {
        Node rootNode = dict.getRoot();
        Node findNode = dict.get(rootNode, k);
        Node findPred = dict.predecessor(findNode, k);

        if (findPred == null)
            return null;
        else
            return findPred.getContent();
    }

    public void remove(Key k) throws DictionaryException {
        Node rootNode = dict.getRoot();
        Node findNode = dict.get(rootNode, k);

        if (findNode != null)
            dict.remove(rootNode, k);
        else
            throw new DictionaryException("DataItem is not in the dictionary");
    }

    public DataItem smallest() {
        if (dict.getRoot() == null)
            return null;

        return dict.smallest(dict.getRoot()).getContent();
    }

    public DataItem largest() {
        if (dict.getRoot() == null)
            return null;

        return dict.largest(dict.getRoot()).getContent();
    }
}
