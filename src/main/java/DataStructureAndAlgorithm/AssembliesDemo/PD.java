package DataStructureAndAlgorithm.AssembliesDemo;

import java.util.HashSet;
import java.util.Set;

public class PD {
    public String id;
    public String name;
    public Set<Student> students;

    public PD(String id, String name) {
        this.id = id;
        this.name = name;
        this.students = new HashSet<Student>();
    }
}
