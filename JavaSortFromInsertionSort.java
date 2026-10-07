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
public class JavaSortFromInsertionSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        for (int i = 1; i < studentList.size(); i++) {
            Student value = studentList.get(i);
            int j = i - 1;

            while (j >= 0) {
                Student current = studentList.get(j);
                boolean move = (value.getCgpa() > current.getCgpa())
                        || (value.getCgpa() == current.getCgpa()
                        && value.getFname().compareTo(current.getFname()) < 0)
                        || (value.getCgpa() == current.getCgpa()
                        && value.getFname().compareTo(current.getFname()) == 0
                        && value.getId() < current.getId());
                if (move) {
                    studentList.set(j + 1, studentList.get(j));
                    j--;
                } else {
                    break;
                }
            }
            studentList.set(j + 1, value);
        }

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
