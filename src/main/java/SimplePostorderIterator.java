import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SimplePostorderIterator implements Iterator {
    private List<Node> nodeList;
    private int currentIndex;

    public SimplePostorderIterator(Node root) {
        currentIndex = 0;
        nodeList = new ArrayList<>();
        postorder(root);
    }

    private void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            nodeList.add(node);
        }
    }

    public Node next() {
        if (!hasNext()) {
            throw new NoSuchElementException("There are no more nodes to iterate");
        }
        return nodeList.get(currentIndex++);
    }

    public boolean hasNext() {
        return currentIndex < nodeList.size();
    }
}
