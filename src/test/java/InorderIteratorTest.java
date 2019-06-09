import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class InorderIteratorTest {

    private BinaryTree binaryTree;
    private InorderIterator iterator;

    @Test
    public void inorder_iterates_correctly() {
        binaryTree = BinaryTree.createBinaryTree();
        iterator = new InorderIterator(binaryTree.root);
        assertEquals(3, iterator.next().value);
        assertEquals(4, iterator.next().value);
        assertEquals(5, iterator.next().value);
        assertEquals(6, iterator.next().value);
        assertEquals(7, iterator.next().value);
        assertEquals(8, iterator.next().value);
        assertEquals(9, iterator.next().value);
        assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void inorder_iterates_correctly2() {
        binaryTree = new BinaryTree();
        binaryTree.add(10);
        binaryTree.add(4);
        binaryTree.add(7);
        binaryTree.add(55);
        binaryTree.add(-5);
        iterator = new InorderIterator(binaryTree.root);

        assertEquals(-5, iterator.next().value);
        assertEquals(4, iterator.next().value);
        assertEquals(7, iterator.next().value);
        assertEquals(10, iterator.next().value);
        assertEquals(55, iterator.next().value);
        iterator.next();
    }

    @Test
    public void random_test() {
        binaryTree = new BinaryTree();
        IteratorUtils.fillBTWithRandomNumbers(binaryTree, 1000000);
        Iterator inorderIterator = new InorderIterator(binaryTree.root);
        Iterator simpleInorderIterator = new SimpleInorderIterator(binaryTree.root);
        IteratorUtils.random_test(binaryTree, inorderIterator, simpleInorderIterator);
    }

}