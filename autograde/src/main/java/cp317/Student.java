package cp317;

/**
 * Student class definition.
 *
 * @author Gavin Wright, 210932770, wrig3277@mylaurier.ca
 * @version 2023-07-27
 */
public class Student {

	// Constants
	public static final int ID_LENGTH = 9;

	// Attributes
	private String id;
	private double mygrade;
	private String[] directory = new String[256];
	private int[] task = new int[256];
	private String testing;

	public Student() {
		id = "";
		mygrade = 0;
		testing = "";
	}

	// functions
	public String getID() {
		return this.id;
	}

	public String getDirectoryID(int id) {
		return directory[id];
	}

	public String[] getDirectory() {
		return directory;
	}

	public int[] getTask() {
		return this.task;
	}

	public int getTaskID(int id) {
		return task[id];
	}

	public double getGrade() {
		return mygrade;
	}

	public String getTesting() {
		return testing;
	}

	public void setID(String id) {
		this.id = id;
		return;
	}

	public void setDirectoryID(String value, int id) {
		this.directory[id] = value;
		return;
	}

	public void setTaskID(int value, int id) {
		this.task[id] = value;
		return;
	}

	public void setGrade(double value) {
		this.mygrade = value;
		return;
	}

	public void setTesting(String testing) {
		this.testing = testing;
		return;
	}

	@Override
	public String toString() {
		String out = "#" + id + "," + mygrade + ",#";
		return out;
	}

}