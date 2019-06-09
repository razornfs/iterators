import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SimpleInorderIterator implements Iterator  {
    private List<Node> nodeList;
    private int currentIndex;

    public SimpleInorderIterator(Node root) {
        currentIndex = 0;
        nodeList = new ArrayList<>();
        inorder(root);
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            nodeList.add(node);
            inorder(node.right);
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
