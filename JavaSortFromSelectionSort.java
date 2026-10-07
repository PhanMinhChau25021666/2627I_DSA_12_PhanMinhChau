import java.util.*;

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

//Complete the code
public class JavaSortFromSelectionSort
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
        
        for (int i = 0; i < studentList.size(); i++) {
            int correctStudent = i;
            for (int j = i + 1; j < studentList.size(); j++) {
                if (studentList.get(correctStudent).getCgpa() < studentList.get(j).getCgpa()) {
                    correctStudent = j;
                } else if (studentList.get(correctStudent).getCgpa() == studentList.get(j).getCgpa()) {
                    if (studentList.get(correctStudent).getFname().compareTo(studentList.get(j).getFname()) > 0) {
                        correctStudent = j;
                    } else if (studentList.get(correctStudent).getFname().compareTo(studentList.get(j).getFname()) == 0) {
                        if (studentList.get(correctStudent).getId() > studentList.get(j).getId()) {
                            correctStudent = j;
                        }
                    }
                }   
            }
            Student temp = studentList.get(i);
            studentList.set(i,studentList.get(correctStudent));
            studentList.set(correctStudent,temp);
        }
        
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
