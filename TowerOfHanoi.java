//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           (descriptive title of the program making use of this file)
// Files:           (a list of all source files used by that program)
// Course:          (course number, term, and year)
//
// Author:          (Dustin Li)
// Email:           (dli284@wisc.edu)
// Lecturer's Name: (Gary Dahl)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates 
// strangers, etc do.  If you received no outside help from either type of 
// source, then please explicitly indicate NONE.
//
// Persons:         (NONE)
// Online Sources:  (NONE)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

public class TowerOfHanoi 
{
	private Rod[] rods; // rods[0] starts filled to capacity with disks
    						// goal is to move all disks to rods[rods.length-1]

	/**
	 * Constructs a new TowerOfHanoi puzzle with width rods that can hold a max
	 * of height disks each.  The first of these rods begins with this maximum
	 * (height) number of disks, and each of the other rods begins empty.
	 * @param width is the total number of rods in this puzzle.
	 * @param height is the number of disks that begin on the first rod.
	 */
	public TowerOfHanoi(int width, int height) 
	{ 
		rods = new Rod[width];
		rods[0] = new Rod(height, height);
		for (int i = 1; i < width; i++)
		{
			rods[i] = new Rod(height, 0);
		}
	}
	
	/**
	* Moves a single disk from the source rod to the target rod.  These rods
	* are indexed using a zero-based index, where 0 references the first rod
	* where all disks begin, and the width-1 references the goal rods.  If
	* moving a disk from this source rod to this destination rod is illegal, 
	* then the message "WARNING: Illegal move." should be printed out to the
	* console, instead of moving any disks.
	* @param source is a zero-based index for the rod to move a disk from.
	* @param destination is a zero-based index for the rod that disk moves to.
	*/
	public void moveDisk(int source, int destination) 
	{ 
		if ((rods[source].compareTo(rods[destination])) <= 0)
		{
			System.out.println("WARNING: Illegal move.");
		}
		else
		{
			rods[destination].push(rods[source].pop());
		}
	}
	
	/**
	* Determines whether the puzzle has been solved.  This happens when the
	* goal rod (index width-1) is full, and each of the other rods are empty.
	* @return true when all disks have been moved from the first to last rod.
	*/
	public boolean isSolved() 
	{ 
		int j = 0;
		boolean test;
		for (int i = 0; i < rods.length - 1; i++)
		{
			if (rods[i].isEmpty())
			{
				j++;
			}
			else 
			{
				j -= 10000000;
			}
		}
		if (j > 0)
		{
			test = true;
		}
		else 
		{
			test = false;
		}
		if ((rods[rods.length-1].isFull()) && test == true)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	/**
	* The string representation of this puzzle is composed of the strings
	* representing each rod.  However the rows of each rod must be combined
	* with the rows of the other rods, so that they appear horizontally 
	* aligned in the final string.  Here is an example from a 3x5 game:
	* "     |          |          |     \n" +
	* "     |          |          |     \n" +
	* "    <1>         |          |     \n" +
	* "   <=2=>     <==3==>       |     \n" +
	* "<====5====> <===4===>      |     \n"
	* @return the string representation of this puzzle's current state.
	*/
	@Override
	public String toString() 
	{
		String fin = "";
		String[][] array = new String[rods.length][];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = rods[i].toString().split("\n");
		}
		
		for (int i = 0; i < array[0].length; i++)
		{
			for (int j = 0; j < array.length; j++)
			{
				fin += array[j][i];
			}
			fin += "\n";
		}
		return fin;
	}
	
	/**
	 * This method automatically solves the problem of moving number disks from
	 * the source rod to the destination rod, by making use of an extra 
	 * auxiliary rod.
	 * @param number is the number of disks being moved.
	 * @param source is the zero-based index of the rod disks are moved from.
	 * @param destination is the index of the rod that disks are moved to.
	 * @param auxiliary is an extra rod index that disks can be moved through.
	 */
	public void solve(int number, int source, int destination, int auxiliary) 
	{
	    // when the number of disks to move is greater than zero
	        // recursively move number-1 disks from the source to auxiliary rods
	        // move a single disk from the source to destination rods
	        // display the current state of the puzzle as a result of this move
	        // then recursively move number-1 disks from the auxiliary to destination rods
		if (number > 0)
		{
			solve(number-1, source, auxiliary, destination);
			moveDisk(source, destination);
			System.out.println(toString());
			solve(number-1, auxiliary, destination, source);
		}
	}
}
