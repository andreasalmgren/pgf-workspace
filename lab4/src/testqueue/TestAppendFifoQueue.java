package testqueue;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import queue_singlelinkedlist.FifoQueue;

public class TestAppendFifoQueue {
    private FifoQueue<Integer> q1;
    private FifoQueue<Integer> q2;

    @Before
    public void setUp() {
        q1 = new FifoQueue<>();
        q2 = new FifoQueue<>();
    }

    @After
    public void tearDown() {
        q1 = null;
        q2 = null;
    }

    @Test
    public void testAppendTwoEmpty() {
        q1.append(q2);
        assertNull("Appended empty queues results in empty queue", q1.poll());
        assertNull("q2 is empty after append", q2.peek());
    }

    @Test
    public void testAppendEmptyToNonEmpty() {
        for(int i = 1; i <= 5; i++) {
            q2.offer(i);
        }
        q1.append(q2);
        assertNotNull("Appending empty and non-empty queues results in non-empty queue", q1.peek());
        for (int i = 1; i <= 5; i++) {
            int k = q1.poll();
            assertEquals("Poll returns incorrect element", i, k);
        }

        assertNull("q2 is empty after append", q2.peek());
    }

    @Test
    public void testAppendNonEmptyToEmpty() {
        for(int i = 1; i <= 5; i++) {
            q1.offer(i);
        }
        q1.append(q2);
        assertNotNull("Appending non-empty and empty queues results in non-empty queue", q1.peek());
        for (int i = 1; i <= 5; i++) {
            int k = q1.poll();
            assertEquals("Poll returns incorrect element", i, k);
        }

        assertNull("q2 is empty after append", q2.poll());
    }

    @Test
    public void testAppendNonEmptyToNonEmpty() {
        for(int i = 1; i <= 5; i++) {
            q1.offer(i);
        }
        for(int i = 6; i <= 10; i++) {
            q2.offer(i);
        }
        q1.append(q2);
        assertNotNull("Appending two non-empty queues results in non-empty queue", q1.peek());
        for (int i = 1; i <= 10; i++) {
            int k = q1.poll();
            assertEquals("Poll returns incorrect element", i, k);
        }
        assertNull("q2 is empty after append", q2.peek());
    }

    @Test
    public void testAppendToSelf() {
        try {
            q1.append(q1);
            fail("Should raise IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // successful test
        }
    }

}