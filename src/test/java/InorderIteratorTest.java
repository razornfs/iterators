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
        assertEquals(3, iterator.next().value);
        assertEquals(4, iterator.next().value);
        assertEquals(5, iterator.next().value);
        assertEquals(6, iterator.next().value);
        assertEquals(7, iterator.next().value);
        assertEquals(8, iterator.next().value);
        assertEquals(9, iterator.next().value);
        assertFalse(iterator.hasNext());
    }

}
