import java.util.List;

import bean.Student;
import daoIMP.StudentDAOIMP;

public class Client {
	public static void main(String[] args) {
		StudentDAOIMP sdimp = new StudentDAOIMP();
		sdimp.delete(1);
		List<Student> result = sdimp.findAll();
		for(Student s : result) {
			System.out.println(s.getID() + " " + s.getName());
		}
	}
}
