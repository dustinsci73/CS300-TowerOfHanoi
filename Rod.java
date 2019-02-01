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

import java.util.NoSuchElementException;

public class Rod implements Comparable<Rod>
{
	private int numberOfDisks; // tracks the number of disks on this rod
	private Disk[] disks;      // stores references to the disks on this rod
							  // index 0: bottom, index discNumber-1: top
 
	/**
	 * Constructs a new rod that can hold a maximum of maxHeight Disks. The
	 * numberOfDisks new Disks will be created with sizes between 1 and 
	 * numberOfDisks (inclusive), and arranged from largest (on bottom) to the
	 * smallest (on top) on this Rod.
	 * @param maxHeight is the capacity or max number of Disks a rod can hold.
	 * @param numberOfDisks is the initial number of Disks created on this rod.
	 */
	public Rod(int maxHeight, int numberOfDisks) 
	{ 
		this.numberOfDisks = numberOfDisks;
		disks = new Disk[maxHeight];
		for(int i = 0; i < numberOfDisks; i++)
		{
			disks[i] = new Disk(numberOfDisks - i);
		}
	}
 
	/**
	 * Adds one new Disk to the top of this rod.
	 * @param disk is a reference to the Disk being added to this rod.
	 * @throws IllegalStateException when this rod is already full to capacity.
	 */
	public void push(Disk disk) throws IllegalStateException 
	{ 
		if (numberOfDisks == disks.length)
		{
			throw new IllegalStateException();
		}
		else 
		{
			for(int i = 0; i < disks.length; i++)
			{
				if (disks[i] == null)
				{
					disks[i] = disk;
					numberOfDisks++;
					return;
				}
				else
				{
					continue;
				}
			}
		}
	}
 
	/**
	 * Removes and returns one Disk from the top of this rod.
	 * @return a reference to the Disk that is being removed.
	 * @throws NoSuchElementException when this rod is empty.
	 */
	public Disk pop() throws NoSuchElementException 
	{ 
		if (numberOfDisks == 0)
		{
			throw new NoSuchElementException();
		}
		else 
		{
			int i = 0;
			while ((i+1) < disks.length && disks[i+1] != null)
			{
				i++;
			}
			Disk temp = disks[i];
			disks[i] = null;
			numberOfDisks--;
			return temp;
		}
	}
 
	/**
	 * Returns (without removing) one Disk from the top of this rod.
	 * @return a reference to the Disk that is being returned.
	 * @throws NoSuchElementException when this rod is empty.
	 */
	public Disk peek() throws NoSuchElementException 
	{
		if (numberOfDisks == 0)
		{
			throw new NoSuchElementException();
		}
		else 
		{
			int i = 0;
			while ((i+1) < disks.length && disks[i+1] != null)
			{
				i++;
			}
			Disk temp = disks[i];
			return temp;
		}
	}
 
	/**
	 * Indicates whether this rod is currently holding zero Disks.
	 * @return true when there are no Disks on this rod.
	 */
	public boolean isEmpty() 
	{
		if (numberOfDisks == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
 
	/**
	 * Indicates whether this rod is currently full to its capacity with disks.
	 * @return true when the number of Disks on this rod equals its max height.
	 */
	public boolean isFull() 
	{ 
		if (numberOfDisks == disks.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * Compares one rod to another to determine whether it's legal to move the
	 * top disk from this rod onto the other.
	 * @param other is the destination rod we are considering moving a disk to.
	 * @return +1 when moving a disk from this rod to other is legal,
	 *         -1 when moving a disk from this rod to other is illegal,
	 *         or 0 when this rod is empty and there are no disks to move.
	 */
	@Override
	public int compareTo(Rod other) 
	{
		if (this.isEmpty() || other == null)
		{
			return 0;
		}
		else if (other.isEmpty())
		{
			return 1;
		}
		else if (peek().compareTo(other.peek()) > 0  || other.isFull())
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
 
	/**
	 * The string representation of this rod includes its max height number
	 * of rows separated by and ending with newline characters (\n).  Rows 
	 * occupied by a disk will include that disk's string representation, and 
	 * other rows instead contain a single vertical bar character (|).  All 
	 * rows are centered by surrounding both sides with spaces until they are 
	 * each capacity*2+1 characters wide.  Example of 5 capacity rod w\3 disks:
	 * "     |     \n" +
	 * "     |     \n" +
	 * "   <=2=>   \n" +
	 * "  <==3==>  \n" +
	 * "<====5====>\n"
	 * @return the string representation of this rod based on its contents.
	 */
	@Override
	public String toString() 
	{
		String space = "";
		String line = "";
		String fin = "";
		for (int i = disks.length - 1; i >= 0; i--)
		{
			space = "";
			if (disks[i] == null)
			{
				for (int j = 0; j < disks.length; j++)
				{
					space = space + " ";
				}
				line = space + "|" + space + "\n";
				fin = fin + line;
			}
			else
			{
				for (int j = 0; j < disks.length - 
						(((disks[i].toString().length()) - 1)/2); j++)
				{
					space = space + " ";
				}
				line = space + disks[i].toString() + space + "\n";
				fin = fin + line;
			}
		}
		//System.out.println(fin);
		return fin;
	}
}
