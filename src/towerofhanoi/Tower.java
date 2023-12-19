// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Prakhar Pandey (prakhar28)

package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * A class representing a tower in the Tower of Hanoi puzzle.
 * 
 * @author Prakhar Pandey
 * @version 16-Oct-2023
 */
public class Tower
    extends LinkedStack<Disk>
{
    private Position position;

    // ----------------------------------------------------------
    /**
     * Creates a new Tower object with the specified position.
     *
     * @param position
     *            The position of the tower (LEFT, MIDDLE, or RIGHT).
     */
    public Tower(Position position)
    {
        super();
        this.position = position;
    }


    // ----------------------------------------------------------
    /**
     * Gets the position of the tower.
     *
     * @return The position of the tower (LEFT, MIDDLE, or RIGHT).
     */
    public Position position()
    {
        return position;
    }


    /**
     * Overrides the push method to enforce puzzle rules.
     *
     * @param disk
     *            The disk to be pushed onto the tower.
     * @throws IllegalArgumentException
     *             If the provided disk is null.
     * @throws IllegalStateException
     *             If the provided disk is larger than the top disk on the
     *             tower.
     */
    @Override
    public void push(Disk disk)
    {
        if (disk == null)
        {
            throw new IllegalArgumentException("Cannot push a null disk.");
        }

        if (isEmpty() || disk.compareTo(peek()) < 0)
        {
            super.push(disk);
        }
        else
        {
            throw new IllegalStateException(
                "Invalid push: Disk is larger than "
                    + "the top disk on the tower.");
        }
    }

}
