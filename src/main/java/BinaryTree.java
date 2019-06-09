public class BinaryTree {

    Node root;
    private int size;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            size++;
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
            current.left.parent = current;
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
            current.right.parent = current;
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    static BinaryTree createBinaryTree() {
        BinaryTree bt = new BinaryTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        return bt;
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
               ? containsNodeRecursive(current.left, value)
               : containsNodeRecursive(current.right, value);
    }

    public int size() {
        return size;
    }
}
