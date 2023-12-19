// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Prakhar Pandey (prakhar28)

package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * A class that contains test cases for the Tower class, which represents a
 * tower in the Tower of Hanoi puzzle.
 * 
 * @author Prakhar Pandey
 * @version 17-Oct-2023
 */
public class TowerTest
    extends student.TestCase
{
    private Tower tower;

    /**
     * Sets up the test by creating a Tower object with the MIDDLE position.
     */
    public void setUp()
    {
        tower = new Tower(Position.MIDDLE);
    }


    // ----------------------------------------------------------
    /**
     * Test the position() method of the Tower class.
     */
    public void testPosition()
    {
        assertEquals(Position.MIDDLE, tower.position());
    }


    // ----------------------------------------------------------
    /**
     * Test the push() method of the Tower class, including handling invalid
     * cases.
     */
    @SuppressWarnings("unused")
    public void testPush()
    {
        Disk disk1 = new Disk(10);
        Disk disk2 = new Disk(20);

        tower.push(disk1);
        
        Exception thrown = null;
        try
        {
            tower.push(disk2);
            fail();
        }
        catch (IllegalStateException e)
        {
            thrown = e;
        }

        try
        {
            tower.push(null);
            fail();
        }
        catch (IllegalArgumentException e)
        {
            thrown = e;
        }
    }
}
