package DataStructureAndAlgorithm.ClassDemo;

public class People {
    private double height;
    private int age;
    private int sex;

    public class Student {
        String id;
        public void stuInfo (){
            System.out.println("外部类的属性："+height);
            System.out.println("内部类的属性："+id);
        }

        public  Student(String id){
            this.id = id;
        }

        public  Student(){

        }
    }
    void cry(){
        System.out.println("I'm crying!");
    }
    void laugh(){
        System.out.println("我在笑！");
    }
    void printBaseMes(){
        System.out.println("我的身高是"+height+"cm");
        System.out.println("我的年龄是"+age+"岁");
        if(this.sex==0)
            System.out.println("我是男性！");
        else
            System.out.println("我是女性！");
    }

    public People(){

    }

    public People(double h, int age, int sex){
        height = h;
        this.age = age;
        this.sex = sex;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public static void main(String[] args) {
        People along = new People();
        Student s = along.new Student();

        People.Student student = new People().new Student("1910100440");
        student.stuInfo();


    }
}


