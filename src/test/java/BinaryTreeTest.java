import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BinaryTreeTest {

    @Test
    public void givenABinaryTree_WhenAddingElements_ThenTreeContainsThoseElements() {
        BinaryTree bt = BinaryTree.createBinaryTree();

        assertTrue(bt.containsNode(6));
        assertTrue(bt.containsNode(4));

        assertFalse(bt.containsNode(1));
    }

}
