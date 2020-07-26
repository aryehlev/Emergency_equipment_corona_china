package cn.lss.demo001.dao.impl;

import cn.lss.demo001.dao.StudentDao;
import cn.lss.demo001.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private StudentDao studentDao;


    @Override
    public List<Student> selectAll() {
        List<Student> students = studentDao.selectAll();
        return students;
    }

    @Override
    public int insert(Student stu) {
        int num = studentDao.insert(stu);
        return num;
    }

    @Override
    public int update(Student stu) {
        int num = studentDao.update(stu);
        return num;
    }

    @Override
    public int delete(int id) {
        int num = studentDao.delete(id);
        return num;
    }

    @Override
    public List<Student> findStudentByLimit(Integer offset, Integer limit) {
        List<Student> students = studentDao.findStudentByLimit((offset - 1) * limit, limit);
        return students;
    }

    @Override
    public Student selectOne(Integer id) {
        Student student = studentDao.selectOne(id);
        return student;
    }

    @Override
    public int count() {
        int count = studentDao.count();
        return count;
    }

    @Override
    public List<Student> search(String keyword) {

        List<Student> students = studentDao.search(keyword);
        return students;
    }
}
