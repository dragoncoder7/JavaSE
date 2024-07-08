package DataStructureAndAlgorithm.AssembliesDemo;

public class Student {
    public String id;

    public String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

}
