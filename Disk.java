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
public class Disk implements Comparable<Disk>
{
	private int size; // 1-9: restricts disk movement, and used for drawing
	 
	/**
	 * Constructs a new immutable disk object with the specified size.
	 * @param size is used for drawing and comparing against other disks.
	 * @throws IllegalArgumentException when size is not between 1 and 9.
	 */
	public Disk(int size) throws IllegalArgumentException 
	{ 
		if (size > 0 && size < 10)
		{
			this.size = size;
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}
	 
	/**
	 * Compares one disk to another to determine which is larger, and therefore
	 * which can be moved on top of the other.
	 * @param other is a reference to the disk we are comparing this one to.
	 * @return a positive number when this.size > other.size,
	 *         a negative number when this.size < other.size, or
	 *         zero when this.size == other.size, or other is null.
	 */
	@Override
	public int compareTo(Disk other) 
	{ 
		if (other == null || this.size == other.size)
		{
			return 0;
		}
		else if (this.size > other.size) 
		{
			return 1;
		}
		else 
		{
			return -1;
		}
	}
	 
	/**
	 * The string representation of this disk object includes its integer size
	 * surrounded by size-1 equals characters (=) on each side, and enclosed 
	 * within angle brackets (<>).  For example:
	 *     size 1: "<1>"
	 *     size 2: "<=2=>"
	 *     size 3: "<==3==>"
	 * @return the string representation of this disk object based on its size.
	 */
	@Override
	public String toString() 
	{
		String equals = "";
		for (int i = 0; i < this.size - 1; i++)
		{
			equals = equals + "=";
		}
		String x = "<" + equals + this.size + equals + ">";
		return x;
	}
}
