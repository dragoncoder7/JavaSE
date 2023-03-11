package AssembliesDemo;

import java.util.*;

public class ListTest {
    public List<Student> students;

    public ListTest() {
        this.students = new ArrayList<>();
    }

    public void testAdd() {
        Student s1 = new Student("1,", "along");
        students.add(s1);
        Student st2 = new Student("2", "李四");
        students.add(0, st2);
        Student temp = students.get(0);
        System.out.println(students);
        System.out.println(temp);
        Student[] student = {new Student("3", "王五"), new Student("4", "马六")};
        students.addAll(2, Arrays.asList(student));
        System.out.println(students);
    }

    public void testGet() {
        for (Student s:students
             ) {
            System.out.println(s);
        }
    }

    public void TestIterator() {
        Iterator<Student> it = students.iterator();
        Iterator<Student> it2 = students.listIterator();
        while (it.hasNext()) {
            Student st = it.next();
            System.out.println("学生" + st.getId() + ":" + st.getName());
        }
        while (it2.hasNext()) {
            System.out.println(it2.next());
            //System.out.println("学生" + st.getId() + ":" + st.getName());
        }
    }

    public void testForeach() {
        for (Student st:students
             ) {
            System.out.println(st.getId()+" "+st.getName());
        }
        students.stream().sorted(Comparator.comparing(Student::getId)).forEach(System.out :: println);
    }

    public void testRemove() {
        Student st = students.get(3);
        System.out.println("我是学生：" + st.getId() + ":" + st.getName() + "，我即将被删除");
        students.remove(st);
        System.out.println("成功删除学生！");
        testForeach();
    }
    public static void main(String[] args) {
        ListTest lt = new ListTest();
        lt.testAdd();
        lt.testGet();
        lt.TestIterator();
        lt.testForeach();
        lt.testRemove();
    }
}
