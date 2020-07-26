package cn.lss.demo001;

import cn.lss.demo001.dao.StudentDao;
import cn.lss.demo001.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo001ApplicationTests {

    @Autowired
    private StudentDao dao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() {       //测试查询方法
        List<Student> list = dao.selectAll();
        for (Student student : list) {
            System.out.println(student);
        }
    }

    public void test2(String name){       //测试添加方法
        Student stu = new Student();
        stu.setSname(name);
        stu.setSage(15+(int)(Math.random()*9));
        stu.setPhone("182082245"+(int)(10+Math.random()*90));
        int i = dao.insert(stu);
        System.out.println(i);
    }
    @Test
    public void test3(){       //测试修改方法
        Student stu = new Student();
        stu.setId(6);
        stu.setSname("haha");
        stu.setSage(21);
        stu.setPhone("1820822453"+(int)(Math.random()*9));
        int i = dao.update(stu);
        System.out.println(i);
    }

    @Test
    public void test4(){      //测试删除方法
        int i = dao.delete(2);
        System.out.println(i);
    }


    @Test
    public void methodTest(){
        String[] fn = {"张","赵","钱","孙","李","周","吴","郑","王"};
        String[] ln =  {"彤","阳","紫彤","紫阳","丹","熙","曦","瞳","童","鹏","鸿","琨","鸾","翊"};
        for(int i = 0; i < 20;i ++){
            String name = fn[(int)(Math.random()*fn.length)]+ln[(int)(Math.random()*ln.length)];
            test2(name);
        }
    }
}
