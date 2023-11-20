package lab9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
	private String id, title, type;
	private String lecturer;
	List<Student> students;

	public Course(String id, String title, String type, String lecturer, List<Student> students) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.lecturer = lecturer;
		this.students = students;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}

	public String getLecturer() {
		return lecturer;
	}

	public List<Student> getStudents() {
		return students;
	}

	@Override
	public String toString() {
		return id + "  title= " + title + "  type= " + type + "  lecturer= " + lecturer + "  students= " + students;
	}

	
 //Câu 2
    public Map<Integer, List<Student>> groupStudentsByYear() {
        Map<Integer, List<Student>> result = new HashMap<>();
        for (Student student : students) {
            if (result.containsKey(student.getYear())) {
                result.get(student.getYear()).add(student);
            }
            else {
                List<Student> list = new ArrayList<>();
                list.add(student);
                result.put(student.getYear(), list);
            }
        }
        return result;
    }
}
	
