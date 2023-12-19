// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Prakhar Pandey (prakhar28)

package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * Represents a set of test cases for the Disk class to ensure its correctness.
 * 
 * @author Prakhar Pandey
 * @version 17-Oct-2023
 */
public class DiskTest
    extends student.TestCase
{
    private Disk disk;

    /**
     * Initializes the Disk object for testing.
     */
    public void setUp()
    {
        disk = new Disk(15);
    }


    // ----------------------------------------------------------
    /**
     * Tests the compareTo method of the Disk class.
     */
    public void testCompareTo()
    {
        Disk diskOne = new Disk(7);
        assertEquals(8, disk.compareTo(diskOne));

        Disk diskTwo = new Disk(15);
        assertEquals(0, disk.compareTo(diskTwo));

        Disk newDisk = new Disk(12);
        Disk diskThree = null;
        Exception thrown = null;
        assertEquals(3, disk.compareTo(newDisk));
        try
        {
            disk.compareTo(diskThree);
            fail();
        }
        catch (IllegalArgumentException e)
        {
            thrown = e;
        }
        assertTrue(thrown instanceof IllegalArgumentException);
    }


    // ----------------------------------------------------------
    /**
     * Tests the toString method of the Disk class.
     */
    public void testToString()
    {
        String outcome = disk.toString();
        assertEquals("15", outcome);

        Disk diskOne = new Disk(7);
        String outcome1 = diskOne.toString();
        assertEquals("7", outcome1);

        Disk diskTwo = new Disk(12);
        String outcome2 = diskTwo.toString();
        assertEquals("12", outcome2);
    }


    // ----------------------------------------------------------
    /**
     * Tests the equals method of the Disk class.
     */
    public void testEquals()
    {
        assertTrue(disk.equals(disk));

        Disk diskOne = new Disk(15);
        assertTrue(disk.equals(diskOne));

        Disk diskTwo = new Disk(1);
        assertFalse(disk.equals(diskTwo));

        Object diskObject = new Object();
        assertFalse(disk.equals(diskObject));

        Disk diskThree = null;
        assertFalse(disk.equals(diskThree));

        Object obj = disk;
        assertTrue(disk.equals(obj));
    }
}
