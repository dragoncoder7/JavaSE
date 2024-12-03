package Test;


import org.junit.platform.commons.util.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyTest {

    /**
     * 定义用户的接口
     */
    public interface User {
        String job();
    }

    public interface Animals {
        String action();
    }

    /**
     * 实际的调用对象
     */
    public static class Teacher {

        public void test() {
            System.out.println("this is test data");
        }

        public String invoke() {
            return "i'm Teacher";
        }
    }

    public static class Dog {

        public void test() {
            System.out.println("this is test data");
        }

        /**
         * 创建JDK动态代理类
         */


        public String invoke() {
            return "wang!wang!wang!";
        }
    }
    public static class JDKProxy implements InvocationHandler {
        private Object target;


        JDKProxy(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] paramValues) {
            ((Teacher) target).test();
            System.out.println(((Dog) target).invoke());
            return ((Teacher) target).invoke();
        }
    }

    public static void main(String[] args) {
        // 构建代理器
        JDKProxy proxy = new JDKProxy(new Teacher());

        ClassLoader classLoader = ClassLoaderUtils.getClassLoader(Teacher.class);

        // 生成代理类
        User user = (User) Proxy.newProxyInstance(classLoader, new Class[]{User.class, Dog.class}, proxy);


        // 接口调用
        System.out.println(user.job());
    }
}
