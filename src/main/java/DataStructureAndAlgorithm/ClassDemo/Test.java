package DataStructureAndAlgorithm.ClassDemo;

public class Test<T> {
    private T var;

    public T getVar() {
        return var;
    }

//    public void setVar(T var) {
//        this.var = var;
//    }

    public Test(T var) {
        this.var = var;
    }

    public Test() {
    }

    public void showType() {
        System.out.println("T的实际类型是："+ var.getClass().getName());
    }


    public<t, S extends t> t testDemo(t t, S s) {
        System.out.println("我是 T 类型，我的类型是" + t.getClass().getName());
        System.out.println("我是 S 类型，我的类型是" + s.getClass().getName());
        return  t;
    }
}
