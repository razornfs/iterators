import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PostorderIteratorTest {

    private BinaryTree binaryTree;
    private PostorderIterator iterator;

    @Test
    public void postorder_iterates_correctly() {
        binaryTree = BinaryTree.createBinaryTree();
        iterator = new PostorderIterator(binaryTree.root);
        assertEquals(3, iterator.next().value);
        assertEquals(5, iterator.next().value);
        assertEquals(4, iterator.next().value);
        assertEquals(7, iterator.next().value);
        assertEquals(9, iterator.next().value);
        assertEquals(8, iterator.next().value);
        assertEquals(6, iterator.next().value);
        assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void postorder_iterates_correctly2() {
        binaryTree = new BinaryTree();
        binaryTree.add(10);
        binaryTree.add(4);
        binaryTree.add(7);
        binaryTree.add(55);
        binaryTree.add(-5);
        iterator = new PostorderIterator(binaryTree.root);

        assertEquals(-5, iterator.next().value);
        assertEquals(7, iterator.next().value);
        assertEquals(4, iterator.next().value);
        assertEquals(55, iterator.next().value);
        assertEquals(10, iterator.next().value);
        iterator.next();
    }

    @Test
    public void random_test() {
        BinaryTree bt = new BinaryTree();
        RandomIteratorUtils.fillBTWithRandomNumbers(bt, 1000000);
        Iterator postorderIterator = new PostorderIterator(bt.root);
        Iterator simplePostorderIterator = new SimplePostorderIterator(bt.root);
        RandomIteratorUtils.random_test(bt, postorderIterator, simplePostorderIterator);
    }
}
