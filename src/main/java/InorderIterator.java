import java.util.NoSuchElementException;

public class InorderIterator implements Iterator {
    private Node next;

    InorderIterator(Node root) {
        next = root;
        if (next == null)
            return;

        while (next.left != null)
            next = next.left;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public Node next() {
        if (!hasNext()) throw new NoSuchElementException();
        Node r = next;

        if (next.right != null) {
            next = next.right;
            while (next.left != null)
                next = next.left;
            return r;
        }

        while (true) {
            if (next.parent == null) {
                next = null;
                return r;
            }
            if (next.parent.left == next) {
                next = next.parent;
                return r;
            }
            next = next.parent;
        }
    }
}

