import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SimplePreorderIterator implements Iterator {
    private List<Node> nodeList;
    private int currentIndex;

    public SimplePreorderIterator(Node root) {
        currentIndex = 0;
        nodeList = new ArrayList<>();
        preorder(root);
    }

    private void preorder(Node node) {
        if (node != null) {
            nodeList.add(node);
            preorder(node.left);
            preorder(node.right);
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
