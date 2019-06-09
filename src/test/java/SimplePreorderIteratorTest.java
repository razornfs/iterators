import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SimplePreorderIteratorTest {
    private BinaryTree binaryTree = BinaryTree.createBinaryTree();
    private SimplePreorderIterator iterator = null;

    @Before
    public void setUp() {
        iterator = new SimplePreorderIterator(binaryTree.root);
    }

    @Test
    public void preorder_iterates_correctly() {
        assertEquals(6, iterator.next().value);
        assertEquals(4, iterator.next().value);
        assertEquals(3, iterator.next().value);
        assertEquals(5, iterator.next().value);
        assertEquals(8, iterator.next().value);
        assertEquals(7, iterator.next().value);
        assertEquals(9, iterator.next().value);
        assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void preorder_iterates_correctly2() {
        binaryTree = new BinaryTree();
        binaryTree.add(10);
        binaryTree.add(4);
        binaryTree.add(7);
        binaryTree.add(55);
        binaryTree.add(-5);
        iterator = new SimplePreorderIterator(binaryTree.root);

        assertEquals(10, iterator.next().value);
        assertEquals(4, iterator.next().value);
        assertEquals(-5, iterator.next().value);
        assertEquals(7, iterator.next().value);
        assertEquals(55, iterator.next().value);
        iterator.next();
    }
}
