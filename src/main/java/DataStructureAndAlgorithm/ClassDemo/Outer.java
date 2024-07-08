package DataStructureAndAlgorithm.ClassDemo;

public class Outer {
    public Inner1 getInner(final String name, String city) {
        return new Inner1(name, city) {
            private  String nameStr = city ;
            public String getName() {
                return  nameStr;
            }
        };
    }
    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner1 inner = outer.getInner("毛云龙", "长沙");
        System.out.println(inner.getName());
    }
}

interface Inner{
    String getName();
}

abstract class Inner1{
    String name;
    String city;

    public Inner1(String name, String city) {
        this.name = name;
        this.city = city;
    }

    abstract String getName();
}


