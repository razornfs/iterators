import java.util.NoSuchElementException;

public class InorderIterator implements Iterator {

    private Node next;

    public InorderIterator(Node root) {
        next = root;
        if (root == null) {
            return;
        }
        while (next.left != null) {
            next = next.left;
        }
    }

    public Node next() {
        if (!hasNext()) {
            throw new NoSuchElementException("There are no more nodes to iterate");
        }
        Node tmp = next;
        setNextNode();
        return tmp;

    }

    private void setNextNode() {
        if (next.right != null) {
            next = next.right;
            while (next.left != null) {
                next = next.left;
            }
        } else {
            while (true) {
                if (next.parent == null) {
                    next = null;
                    break;
                } else if (next.parent.left == next) {
                    next = next.parent;
                    break;
                } else {
                    next = next.parent;
                }
            }
        }
    }

    public boolean hasNext() {
        return next != null;
    }
}
