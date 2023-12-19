// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Prakhar Pandey (prakhar28)

package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;

// -------------------------------------------------------------------------
/**
 * Represents a generic stack data structure implemented using a singly linked
 * list.
 * 
 * @param <T>
 * @author Prakhar Pandey
 * @version 16-Oct-2023
 */
public class LinkedStack<T>
    implements StackInterface<T>
{
    private int size;
    private Node<T> topNode;

    // ----------------------------------------------------------
    /**
     * Creates a new LinkedStack object, initializing an empty stack.
     */
    public LinkedStack()
    {
        size = 0;
        topNode = null;
    }


    // ----------------------------------------------------------
    /**
     * Returns the current size of the stack.
     *
     * @return The number of elements in the stack.
     */
    public int size()
    {
        return size;
    }


    /**
     * Checks if the stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return size == 0;
    }


    /**
     * Clears the stack by removing all elements and resetting the size.
     */
    public void clear()
    {
        topNode = null;
        size = 0;
    }


    /**
     * Returns a string representation of the stack.
     *
     * @return A string containing the elements of the stack in square brackets.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder("[");

        Node<T> currentNode = topNode;
        while (currentNode != null)
        {
            sb.append(currentNode.getData());
            if (currentNode.getNextNode() != null)
            {
                sb.append(", ");
            }
            currentNode = currentNode.getNextNode();
        }
        sb.append("]");
        return sb.toString();
    }


    /**
     * Pushes an element onto the stack.
     *
     * @param argument
     *            The element to be pushed onto the stack.
     */
    public void push(T argument)
    {
        Node<T> node = new Node<T>(argument, topNode);
        topNode = node;
        size++;
    }


    /**
     * Retrieves the element at the top of the stack without removing it.
     *
     * @return The element at the top of the stack.
     * @throws EmptyStackException
     *             if the stack is empty.
     */
    public T peek()
    {
        if (size == 0)
        {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }


    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return The element at the top of the stack.
     * @throws EmptyStackException
     *             if the stack is empty.
     */
    public T pop()
    {
        if (size == 0)
        {
            throw new EmptyStackException();
        }

        Node<T> temp = topNode;
        topNode = topNode.nextNode;
        size--;
        return temp.getData();
    }

    /**
     * Represents a node in the singly linked list used for implementing the
     * stack.
     *
     * @param <T>
     *            The type of data stored in the node.
     */
    private class Node<T>
    {
        private T data;
        private Node<T> nextNode;

        public Node(T entry, Node<T> node)
        {
            this(entry);
            this.setNextNode(node);
        }


        public Node(T data)
        {
            this.data = data;
        }


        public Node<T> getNextNode()
        {
            return nextNode;
        }


        public void setNextNode(Node<T> node)
        {
            this.nextNode = node;
        }


        public T getData()
        {
            return data;
        }
    }
}
