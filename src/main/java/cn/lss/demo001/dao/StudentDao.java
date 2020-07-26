package cn.lss.demo001.dao;


import cn.lss.demo001.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentDao {
    public List<Student> selectAll();

    public int insert(Student stu);

    public int update(Student stu);

    public int delete(int id);

    public List<Student> findStudentByLimit(@Param("page") Integer offset, @Param("limit") Integer limit);

    public Student selectOne(@Param("id") Integer id);

    public int count();

    public List<Student> search(@Param("keyword") String keyword);


}
