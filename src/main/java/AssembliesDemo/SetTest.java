package AssembliesDemo;

import java.util.*;

public class SetTest {
    public List<Student> students;
    public SetTest() {
        students = new ArrayList<>();
    }

    public void adds() {
        Student student1 = new Student("1", "xiaoming");
        Student student2 = new Student("2", "aqiang");
        Student[] st = {new Student("3", "xiaolong"), new Student("4", "along"), student1, student2};
        students.addAll(Arrays.asList(st));
    }

    public void print() {
        for (Student s:students
             ) {
            Student student = s;
            System.out.println(student.id+" "+student.name);
        }
    }

    public static void main(String[] args) {
        SetTest setTest = new SetTest();
        setTest.adds();
        setTest.print();
        PD pd = new PD("1", "老师");
        System.out.println("请选择3个学生：");
        System.out.println(setTest.students);
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++){
            String id = scanner.next();
            for (Student s: setTest.students
                 ) {
                if(s.id.equals(id)){
                    pd.students.add(s);
                }
            }
        }
        for (Student s : pd.students
             ) {
            System.out.println("选择的学生: "+s.id+" "+s.name);
        }
    }

}
