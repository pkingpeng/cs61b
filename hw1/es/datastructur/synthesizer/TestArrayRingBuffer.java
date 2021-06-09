package es.datastructur.synthesizer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the ArrayRingBuffer class.
 *
 * @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        assertTrue(arb.isEmpty());
        assertEquals(arb.capacity(), 10);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.enqueue(5);
        arb.enqueue(6);
        arb.enqueue(6);
        arb.enqueue(6);
        arb.enqueue(6);
        arb.enqueue(6);

        assertTrue(arb.isFull());
        System.out.println(arb.isFull());


        arb.dequeue();
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();
        System.out.println(arb.fillCount());
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();


        System.out.println(arb.fillCount());
        assertTrue(arb.isEmpty());

    }
}
