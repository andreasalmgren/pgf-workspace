package bst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBST {
    private BinarySearchTree<Integer> tree;
    private BinarySearchTree<Integer> tree2;
    private BinarySearchTree<String> tree3;

    @BeforeEach
    void setUp() {
        tree = new BinarySearchTree<Integer>();

        // Egen konstruktor
        tree2 = new BinarySearchTree<Integer>((e1, e2) -> e1 - e2);

        // String
        tree3 = new BinarySearchTree<String>();
    }

    @AfterEach
    void tearDown(){
        tree = null;
        tree2 = null;
        tree3 = null;
    }

    /**
     * Test the size/add method
     */
    @Test
    void testSize() {
        assertTrue(tree.add(1));
        assertTrue(tree.add(2));
        assertTrue(tree.add(3));

        assertFalse(tree.add(3));

        assertEquals(tree.size(), 3);

        assertTrue(tree2.add(1));
        assertEquals(tree2.size(), 1);

        assertTrue(tree3.add("h"));
        assertTrue(tree3.add("d"));
        assertFalse(tree3.add("h"));

        assertEquals(tree3.size(), 2);
    }

    /**
     * Test the height of a BST
     */
    @Test
    void testHeight() {
        assertTrue(tree.add(1));
        assertTrue(tree.add(3));
        assertTrue(tree.add(4));
        assertTrue(tree.add(2));

        assertEquals(tree.height(), 3);

        assertTrue(tree2.add(1));
        assertTrue(tree2.add(2));
        assertTrue(tree2.add(3));
        assertFalse(tree2.add(1));
        assertEquals(tree2.height(), 3);

        assertTrue(tree3.add("h"));
        assertTrue(tree3.add("d"));
        assertFalse(tree3.add("h"));

        assertEquals(tree3.height(), 2);
    }

    /**
     * Test clear/ size
     */
    @Test
    void testClear() {
        tree.add(1);
        tree.add(52);
        tree.add(8);

        tree.clear();

        assertEquals(tree.size(), 0);
    }

}