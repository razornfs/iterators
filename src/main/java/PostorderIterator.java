import java.util.NoSuchElementException;

public class PostorderIterator implements Iterator {

    private Node next;

    public PostorderIterator(Node root) {
        next = root;
        if (root == null) {
            return;
        }
        while (next.left != null) {
            next = next.left;
        }
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
        if (next.parent == null) {
            next = null;
        } else if (next.parent.left == next && next.parent.right != null) {
            next = next.parent.right;
            while (next.left != null || next.right != null) {
                next = next.left == null ? next.right : next.left;
            }
        } else {
            next = next.parent;
        }
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
