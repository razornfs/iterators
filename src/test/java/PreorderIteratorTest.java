import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class PreorderIteratorTest {

    private BinaryTree binaryTree;
    private PreorderIterator iterator;

    @Test
    public void preorder_iterates_correctly() {
        binaryTree = BinaryTree.createBinaryTree();
        iterator = new PreorderIterator(binaryTree.root);
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
        iterator = new PreorderIterator(binaryTree.root);

        assertEquals(10, iterator.next().value);
        assertEquals(4, iterator.next().value);
        assertEquals(-5, iterator.next().value);
        assertEquals(7, iterator.next().value);
        assertEquals(55, iterator.next().value);
        iterator.next();
    }

    @Test
    public void random_test() {
        BinaryTree bt = new BinaryTree();
        IteratorUtils.fillBTWithRandomNumbers(bt, 1000000);
        Iterator preorderIterator = new PreorderIterator(bt.root);
        Iterator simplePreorderIterator = new SimplePreorderIterator(bt.root);
        IteratorUtils.random_test(bt, preorderIterator, simplePreorderIterator);
    }
}
