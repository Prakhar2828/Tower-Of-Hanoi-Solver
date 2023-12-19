// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Prakhar Pandey (prakhar28)

package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * Represents a set of test cases for the HanoiSolver class to ensure its
 * correctness.
 * 
 * @author Prakhar Pandey
 * @version 17-Oct-2023
 */
public class HanoiSolverTest
    extends student.TestCase
{
    private HanoiSolver hanoiSolver;
    private Tower left;
    private Tower right;
    private Tower middle;
    private Tower defaultPosition;
    private int numDisks = 3;

    /**
     * Initializes the HanoiSolver and Tower objects for testing.
     */
    public void setUp()
    {
        hanoiSolver = new HanoiSolver(numDisks);
        left = hanoiSolver.getTower(Position.LEFT);
        right = hanoiSolver.getTower(Position.RIGHT);
        middle = hanoiSolver.getTower(Position.MIDDLE);
        defaultPosition = hanoiSolver.getTower(Position.DEFAULT);
    }


    // ----------------------------------------------------------
    /**
     * Tests the disks method to ensure it returns the correct number of disks.
     */
    public void testDisk()
    {
        assertEquals(hanoiSolver.disks(), numDisks);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getTower method to ensure it correctly returns the specified
     * tower based on the position.
     */
    public void testGetTower()
    {
        assertEquals(hanoiSolver.getTower(Position.LEFT), left);
        assertEquals(hanoiSolver.getTower(Position.RIGHT), right);
        assertEquals(hanoiSolver.getTower(Position.MIDDLE), middle);
        assertEquals(hanoiSolver.getTower(Position.DEFAULT), defaultPosition);
        assertEquals(hanoiSolver.getTower(Position.MIDDLE), defaultPosition);
    }


    // ----------------------------------------------------------
    /**
     * Tests the toString method to ensure it returns the correct string
     * representation of the Tower of Hanoi puzzle.
     */
    public void testToString()
    {
        assertEquals("[][][]", hanoiSolver.toString());

        Disk disk1 = new Disk(7);
        Disk disk2 = new Disk(2);
        Disk disk3 = new Disk(1);

        hanoiSolver.getTower(Position.LEFT).push(disk1);
        hanoiSolver.getTower(Position.LEFT).push(disk2);
        hanoiSolver.getTower(Position.LEFT).push(disk3);
        assertEquals("[1, 2, 7][][]", hanoiSolver.toString());

        Disk disk4 = new Disk(9);
        Disk disk5 = new Disk(5);
        Disk disk6 = new Disk(4);

        hanoiSolver.getTower(Position.MIDDLE).push(disk4);
        hanoiSolver.getTower(Position.RIGHT).push(disk5);
        hanoiSolver.getTower(Position.DEFAULT).push(disk6);
        assertEquals("[1, 2, 7][4, 9][5]", hanoiSolver.toString());
    }


    // ----------------------------------------------------------
    /**
     * Tests the solve method to ensure it solves the Tower of Hanoi puzzle
     * correctly.
     */
    public void testSolve()
    {
        Disk diskOne = new Disk(10);
        Disk diskTwo = new Disk(9);
        Disk diskThree = new Disk(8);

        hanoiSolver.getTower(Position.LEFT).push(diskOne);
        hanoiSolver.getTower(Position.LEFT).push(diskTwo);
        hanoiSolver.getTower(Position.LEFT).push(diskThree);

        hanoiSolver.solve();

        assertEquals(3, hanoiSolver.getTower(Position.RIGHT).size());

        HanoiSolver hanoiSolver2 = new HanoiSolver(6);
        Disk disk1 = new Disk(10);
        Disk disk2 = new Disk(9);
        Disk disk3 = new Disk(8);
        Disk disk4 = new Disk(7);
        Disk disk5 = new Disk(6);
        Disk disk6 = new Disk(5);

        hanoiSolver2.getTower(Position.LEFT).push(disk1);
        hanoiSolver2.getTower(Position.LEFT).push(disk2);
        hanoiSolver2.getTower(Position.LEFT).push(disk3);
        hanoiSolver2.getTower(Position.LEFT).push(disk4);
        hanoiSolver2.getTower(Position.LEFT).push(disk5);
        hanoiSolver2.getTower(Position.LEFT).push(disk6);

        hanoiSolver2.solve();

        assertEquals(6, hanoiSolver2.getTower(Position.RIGHT).size());
    }
}
