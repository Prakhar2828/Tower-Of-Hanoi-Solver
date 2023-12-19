// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Prakhar Pandey (prakhar28)

package towerofhanoi;

import cs2.*;
import java.awt.Color;
import student.TestableRandom;

// -------------------------------------------------------------------------
/**
 * Represents a disk used in the Tower of Hanoi puzzle.
 * 
 * @author Prakhar Pandey
 * @version 16-Oct-2023
 */
public class Disk
    extends Shape
    implements Comparable<Disk>
{
    private int width;

    // ----------------------------------------------------------
    /**
     * Create a new Disk object.
     * 
     * @param width
     *            The width of the disk.
     */
    public Disk(int width)
    {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);

        TestableRandom random = new TestableRandom();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        Color backgroundColor = new Color(red, green, blue);
        this.setBackgroundColor(backgroundColor);

        this.width = width;
    }


    /**
     * Compares this disk to another disk based on their widths.
     * 
     * @param otherDisk
     *            The disk to compare with.
     * @return Negative value if this disk is smaller, 0 if equal, positive if
     *             larger.
     * @throws IllegalArgumentException
     *             if the otherDisk is null.
     */
    public int compareTo(Disk otherDisk)
    {
        if (otherDisk == null)
        {
            throw new IllegalArgumentException(
                "Cannot compare to a null Disk.");
        }
        return this.width - otherDisk.width;
    }


    /**
     * Returns a string representation of the disk, showing its width.
     * 
     * @return The width of the disk as a string.
     */
    public String toString()
    {
        return Integer.toString(width);
    }


    /**
     * Checks if this disk is equal to another object.
     * 
     * @param obj
     *            The object to compare with.
     * @return True if the objects are the same instance or have the same width.
     */
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        Disk otherDisk = (Disk)obj;
        return width == otherDisk.width;
    }
}
