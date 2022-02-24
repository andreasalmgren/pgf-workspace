package bst;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBST {
    private BinarySearchTree<Integer> myIntBST;
    private BinarySearchTree<Integer> myIntBST_comp;
    private BinarySearchTree<String> myStringBST;

    @BeforeEach
    void setUp() {
        myIntBST = new BinarySearchTree<>();
         myIntBST_comp = new BinarySearchTree<>((e1, e2) -> e1 - e2);
        myStringBST = new BinarySearchTree<>();
    }

    @AfterEach
    void tearDown(){
        myIntBST = null;
        myIntBST_comp = null;
        myStringBST = null;
    }

    /**
     * Test the add method
     */
    @Test
    void add() {
        assertTrue(myIntBST.add(1));
        assertFalse(myIntBST.add(1));
    }

    /**
     * Test the height of a BST
     */
    @Test
    void height() {
        assertEquals(0, myIntBST.height(), "Empty BST should return height 0");

        assertTrue(myIntBST.add(1));
        assertTrue(myIntBST.add(3));
        assertTrue(myIntBST.add(4));
        assertTrue(myIntBST.add(2));
        assertEquals(myIntBST.height(), 3);
    }
}