// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Prakhar Pandey (prakhar28)

package towerofhanoi;

import java.util.EmptyStackException;

// -------------------------------------------------------------------------
/**
 * Represents a set of test cases for the LinkedStack class to ensure its
 * correctness.
 * 
 * @author Prakhar Pandey
 * @version 17-Oct-2023
 */
public class LinkedStackTest
    extends student.TestCase
{
    private LinkedStack<String> stack;

    /**
     * Initializes the LinkedStack for testing.
     */
    public void setUp()
    {
        stack = new LinkedStack<String>();
    }


    // ----------------------------------------------------------
    /**
     * Tests the size method to ensure it returns the correct size of the stack.
     */
    public void testSize()
    {
        assertEquals(0, stack.size());

        stack.push("prakhar");
        assertEquals(1, stack.size());

        stack.push("pandey");
        assertEquals(2, stack.size());

        stack.pop();
        assertEquals(1, stack.size());

        stack.pop();
        assertEquals(0, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * Tests the clear method to ensure it clears the stack correctly.
     */
    public void testClear()
    {
        stack.push("prakhar");
        assertEquals(1, stack.size());

        stack.push("pandey");
        assertEquals(2, stack.size());

        stack.push("anushka");
        assertEquals(3, stack.size());

        stack.push("bhatia");
        assertEquals(4, stack.size());

        stack.clear();
        assertEquals(0, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * Tests the isEmpty method to ensure it correctly determines if the stack
     * is empty.
     */
    public void testIsEmpty()
    {
        assertTrue(stack.isEmpty());
        stack.push("prakhar");
        assertFalse(stack.isEmpty());
        stack.clear();
        assertTrue(stack.isEmpty());
    }


    // ----------------------------------------------------------
    /**
     * Tests the peek method to ensure it correctly retrieves the top element
     * without removing it.
     */
    public void testPeek()
    {
        @SuppressWarnings("unused")
        Exception thrown = null;
        try
        {
            stack.peek();
            fail();
        }
        catch (EmptyStackException e)
        {
            thrown = e;
        }

        stack.push("prakhar");
        stack.push("pandey");
        stack.push("anushka");
        stack.push("bhatia");
        assertEquals("bhatia", stack.peek());

        stack.pop();
        stack.pop();
        assertEquals("pandey", stack.peek());
    }


    // ----------------------------------------------------------
    /**
     * Tests the pop method to ensure it correctly removes and returns the top
     * element.
     */
    public void testPop()
    {
        @SuppressWarnings("unused")
        Exception thrown = null;
        try
        {
            stack.peek();
            fail();
        }
        catch (EmptyStackException e)
        {
            thrown = e;
        }

        stack.push("prakhar");
        stack.push("pandey");
        stack.push("anushka");
        stack.push("bhatia");
        assertEquals("bhatia", stack.pop());
        assertEquals("anushka", stack.pop());
    }


    // ----------------------------------------------------------
    /**
     * Tests the push method to ensure it correctly adds elements to the stack.
     */
    public void testPush()
    {
        assertEquals(0, stack.size());
        stack.push("prakhar");
        assertEquals(1, stack.size());
        stack.push("pandey");
        assertEquals(2, stack.size());
        stack.push("anushka");
        assertEquals(3, stack.size());
        stack.push("bhatia");
        assertEquals(4, stack.size());
        assertEquals("bhatia", stack.peek());
    }


    // ----------------------------------------------------------
    /**
     * Tests the toString method to ensure it returns the correct string
     * representation of the stack.
     */
    public void testToString()
    {
        assertEquals("[]", stack.toString());
        stack.push("prakhar");
        stack.push("pandey");
        stack.push("anushka");
        stack.push("bhatia");
        assertEquals("[bhatia, anushka, pandey, prakhar]", stack.toString());

        stack.pop();
        stack.pop();
        assertEquals("[pandey, prakhar]", stack.toString());
    }
}
