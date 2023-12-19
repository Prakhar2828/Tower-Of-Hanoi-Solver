// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Prakhar Pandey (prakhar28)

package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * A class that serves as the entry point for running the Tower of Hanoi puzzle
 * simulation.
 * 
 * @author Prakhar Pandey
 * @version 16-Oct-2023
 */
public class ProjectRunner
{
    // ----------------------------------------------------------
    /**
     * The main method that initiates the Tower of Hanoi puzzle simulation.
     * 
     * @param args
     *            An array of command-line arguments. The first argument, if
     *            provided, specifies the number of disks for the puzzle.
     */
    public static void main(String[] args)
    {
        int disks = 6;

        if (args.length == 1)
        {
            disks = Integer.parseInt(args[0]);
        }
        HanoiSolver solver = new HanoiSolver(disks);
        PuzzleWindow puzzleWindow = new PuzzleWindow(solver);
    }
}
