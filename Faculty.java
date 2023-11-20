package lab9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Faculty {
	private String name;
	private String address;
	List<Course> courses;

	public Faculty(String name, String address, List<Course> courses) {
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

//trả về course thực hành có nhiều sinh viên đăng ký học nhất.
	public Course getMaxPracticalCourse() {
		int max = 0;
		Course maxSt = null;
		for (Course course : courses) {
			if (course.getType().equals("TH") && course.getStudents().size() >= max) {
				max = course.getStudents().size();
				maxSt = course;
			}
		}
		return maxSt;
	}
//để thống kê danh sách sinh viên theo năm vào học, với key
//là năm vào học và value là các sinh viên tương ứng.

	public Map<Integer, List<Student>> groupStudentsByYear() {
		Map<Integer, List<Student>> res = new HashMap<>();
		for (Course course : courses) {
			Set<Map.Entry<Integer, List<Student>>> set = course.groupStudentsByYear().entrySet();
			for (Map.Entry<Integer, List<Student>> st : set) {
				if (res.containsKey(st.getKey())) {
					res.get(st.getKey()).addAll(st.getValue());
				} else {
					res.put(st.getKey(), st.getValue());
				}
			}
		}
		return res;
	}

//trả về các course theo loại cho trước (type). Các course 
//được sắp xếp giảm dần theo số lượng sinh viên đăng ký học.
	public Set<Course> filterCourses(String type) {
		Set<Course> res = new TreeSet<>(new Comparator<Course>() {
			@Override
			public int compare(Course o1, Course o2) {
				return o1.getStudents().size() - o2.getStudents().size();
			}
		});
		for (Course course : courses) {
			  if (course.getType().equals(type)) res.add(course);
		}
		return res;
	}

	public static void main(String[] args) {

		Student stA1 = new Student("01", "Nguyen Van A", 2000);
		Student stA2 = new Student("02", "Nguyen Thi C", 2004);
		Student stA3 = new Student("03", "Nguyen Van Anh", 2000);
		Student stA4 = new Student("04", "Nguyen Thi Hoa", 2003);
		Student stA5 = new Student("05", "Tran Anh", 2000);
		Student stA6 = new Student("06", "Pham Cong", 2000);

		Student stB1 = new Student("01", "Nguyen Van S", 2002);
		Student stB2 = new Student("02", "Nguyen Thi W", 2000);
		Student stB3 = new Student("03", "Nguyen Van T", 2003);
		Student stB4 = new Student("04", "Nguyen Thi H", 2001);
		Student stB5 = new Student("05", "Tran A", 2000);

		Student stC1 = new Student("01", "Nguyen Van N", 2000);
		Student stC2 = new Student("02", "Nguyen Thi M", 2003);
		Student stC3 = new Student("03", "Nguyen Van D", 2002);
		Student stC4 = new Student("04", "Nguyen O", 2004);

		List<Student> stA = new ArrayList<>();
		stA.add(stA1);
		stA.add(stA2);
		stA.add(stA3);
		stA.add(stA4);
		stA.add(stA5);
		stA.add(stA6);

		List<Student> stB = new ArrayList<>();
		stB.add(stB1);
		stB.add(stB2);
		stB.add(stB3);
		stB.add(stB4);
		stB.add(stB5);

		List<Student> stC = new ArrayList<>();
		stC.add(stC1);
		stC.add(stC2);
		stC.add(stC3);
		stC.add(stC4);

		Course course1 = new Course("213", "Toan roi rac", "LT", "Nguyen Thi Phuong Tram", stA);
		Course course2 = new Course("215", "Cau truc du lieu", "LT", "Nguyen Van Du", stB);
		Course course3 = new Course("220", "Cau truc du lieu", "TH", "Nguyen Van Du", stB);
		Course course4 = new Course("219", "Xac suat thong ke", "LT", "Nguyen Thi Ha Tram", stC);

		List<Course> course = new ArrayList<>();
		course.add(course1);
		course.add(course2);
		course.add(course3);
		course.add(course4);
		Faculty faculty = new Faculty("CNTT", "TV", course);
//		System.out.println(faculty.getMaxPracticalCourse());
//		System.out.println(faculty.filterCourses("LT"));

	}
}
