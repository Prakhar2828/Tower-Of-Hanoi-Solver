// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Prakhar Pandey (prakhar28)

package towerofhanoi;

import java.util.Observable;

// -------------------------------------------------------------------------
/**
 * Represents a solver for the Tower of Hanoi puzzle.
 * 
 * @author Prakhar Pandey
 * @version 16-Oct-2023
 */
@SuppressWarnings("deprecation")
public class HanoiSolver
    extends Observable
{
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    // ----------------------------------------------------------
    /**
     * Create a new HanoiSolver object with the specified number of disks.
     *
     * @param numDisks
     *            The number of disks in the Tower of Hanoi puzzle.
     */
    public HanoiSolver(int numDisks)
    {
        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        right = new Tower(Position.RIGHT);
        middle = new Tower(Position.MIDDLE);
    }


    // ----------------------------------------------------------
    /**
     * Gets the total number of disks in the puzzle.
     *
     * @return The number of disks in the Tower of Hanoi puzzle.
     */
    public int disks()
    {
        return numDisks;
    }


    // ----------------------------------------------------------
    /**
     * Get the tower at the specified position (LEFT, MIDDLE, or RIGHT).
     *
     * @param position
     *            The position of the tower.
     * @return The tower at the specified position.
     */
    public Tower getTower(Position position)
    {
        switch (position)
        {
            case RIGHT:
                return right;

            case MIDDLE:
                return middle;

            case LEFT:
                return left;

            default:
                return middle;
        }
    }


    /**
     * Returns a string representation of the HanoiSolver, showing the state of
     * all towers.
     *
     * @return A string representation of the Tower of Hanoi puzzle.
     */
    public String toString()
    {
        String leftString = left.toString();
        String middleString = middle.toString();
        String rightString = right.toString();

        StringBuilder sb = new StringBuilder();
        sb.append(leftString);
        sb.append(middleString);
        sb.append(rightString);

        return sb.toString();
    }


    // ----------------------------------------------------------
    /**
     * Moves a disk from the source tower to the destination tower. Notifies
     * observers of the change in tower state.
     *
     * @param source
     *            The source tower from which a disk is moved.
     * @param destination
     *            The destination tower where the disk is placed.
     */
    public void move(Tower source, Tower destination)
    {
        destination.push(source.pop());
        setChanged();
        notifyObservers(destination.position());
    }


    // ----------------------------------------------------------
    /**
     * Recursive method to solve the Tower of Hanoi puzzle with a specified
     * number of disks.
     *
     * @param currentDisks
     *            The number of disks in the current tower.
     * @param startPole
     *            The starting pole.
     * @param tempPole
     *            The temporary pole.
     * @param endPole
     *            The destination pole.
     */
    public void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole)
    {
        if (currentDisks == 1)
        {
            move(startPole, endPole);
        }
        else
        {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }


    // ----------------------------------------------------------
    /**
     * Solves the Tower of Hanoi puzzle with the configured number of disks.
     */
    public void solve()
    {
        solveTowers(numDisks, left, middle, right);
    }

}
