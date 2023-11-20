package lab9;

public class Student {
	private String id, name;
	private int year;

	public Student(String id, String name, int year) {
		this.id = id;
		this.name = name;
		this.year = year;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return "\n" + "id= " + id + "  name= " + name + "  year= " + year + "\n";
	}

}
