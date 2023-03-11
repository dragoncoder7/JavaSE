package AssembliesDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class MapTest {
    public Map<String, Course> courseMap;

    public MapTest() {
        this.courseMap = new HashMap<>();
    }

    public void testPut() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("课程id：");
            String id = sc.next();
            Course cr = courseMap.get(id);
            System.out.println(cr);
            if (cr == null) {
                System.out.println("课程name：");
                String name = sc.next();
                Course course = new Course(id, name);
                courseMap.put(id, course);
                System.out.println(courseMap);
            } else {
                System.out.println("id 已被占用！");
            }
        }
        sc.close();
    }

    public void testKeySet() {
        Set<String> keySet = courseMap.keySet();
        for(String crID: keySet) {
            Course cr = courseMap.get(crID);
            if(cr != null){
                System.out.println("课程：" + cr.name);
            }
        }
    }

    public void testRemove() {
        //获取从键盘输入的待删除课程 ID 字符串
        Scanner console = new Scanner(System.in);
        while(true){
            //提示输出待删除的课程 ID
            System.out.println("请输入要删除的课程 ID！");
            String ID = console.next();
            //判断该 ID 是否对应的课程对象
            Course cr = courseMap.get(ID);
            if(cr == null) {
                //提示输入的 ID 并不存在
                System.out.println("该 ID 不存在！");
                continue;
            }
            courseMap.remove(ID);
            System.out.println("成功删除课程" + cr.name);
            break;
        }
    }
    public void testEntrySet() {
        //通过 entrySet 方法，返回 Map 中的所有键值对
        Set<Entry<String,Course>> entrySet = courseMap.entrySet();
        for(Entry<String,Course> entry: entrySet) {
            System.out.println("取得键：" + entry.getKey());
            System.out.println("对应的值为：" + entry.getValue().name);
        }
    }

    /**
     * 利用 put 方法修改Map 中的已有映射
     * param args
     **/
    public void testModify(){
        //提示输入要修改的课程 ID
        System.out.println("请输入要修改的课程 ID：");
        //创建一个 Scanner 对象，去获取从键盘上输入的课程 ID 字符串
        Scanner console = new Scanner(System.in);
        while(true) {
            //取得从键盘输入的课程 ID
            String crID = console.next();
            //从 courses 中查找该课程 ID 对应的对象
            Course course = courseMap.get(crID);
            if(course == null) {
                System.out.println("该 ID 不存在！请重新输入！");
                continue;
            }
            //提示当前对应的课程对象的名称
            System.out.println("当前该课程 ID，所对应的课程为：" + course.name);
            //提示输入新的课程名称，来修改已有的映射
            System.out.println("请输入新的课程名称：");
            String name = console.next();
            Course newCourse = new Course(crID,name);
            courseMap.put(crID, newCourse);
            System.out.println("修改成功！");
            break;
        }
    }

    public static void main(String[] args) {
        MapTest mt = new MapTest();
        mt.testPut();
        mt.testKeySet();
        mt.testRemove();
        mt.testModify();
        mt.testEntrySet();

    }
}
