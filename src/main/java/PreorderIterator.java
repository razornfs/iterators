import java.util.NoSuchElementException;

public class PreorderIterator implements Iterator {

    private Node next;

    public PreorderIterator(Node root) {
        next = root;
    }

    @Override
    public Node next() {
        if (!hasNext()) {
            throw new NoSuchElementException("There are no more nodes to iterate");
        }
        Node tmp = next;
        setNextNode();
        return tmp;
    }

    private void setNextNode() {
        if (next.left != null) {
            next = next.left;
        } else if (next.right != null) {
            next = next.right;
        } else {
            while (true) {
                if (next.parent == null) {
                    next = null;
                    break;
                }
                if (next.parent.left == next && next.parent.right != null) {
                    next = next.parent.right;
                    break;
                }
                next = next.parent;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
