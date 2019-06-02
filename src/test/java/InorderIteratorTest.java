import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InorderIteratorTest {

    private BinaryTree binaryTree = BinaryTree.createBinaryTree();
    private InorderIterator iterator = null;

    @Before
    public void setUp(){
        iterator = new InorderIterator(binaryTree.root);
    }

    @Test
    public void inorder_iterates_correctly() {
    }

}
