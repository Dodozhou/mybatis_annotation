package com.star.service;

import com.star.entity.Student;
import com.star.factory.JavaAPISqlSessionFactory;
import com.star.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentServiceTest {
    public static StudentMapper getStudentMapper(){
        SqlSession sqlSession=JavaAPISqlSessionFactory.getSqlSession();
        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
        return studentMapper;
    }
    @Test
    public void insertStudent(){
        Student student=new Student();
        student.setName("zhou");
        student.setEmail("111@qq.com");
        student.setDob("1995-5-13");
        student.setAddrId(2);
        SqlSession sqlSession=JavaAPISqlSessionFactory.getSqlSession();
        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
        studentMapper.insertStudent(student);
        sqlSession.commit();//必须要commit，否则会失效
        Assert.assertNotNull(student.getStudId());
        System.out.println(student.getStudId());

    }
    @Test
    public void updateStudent(){
        Student student=new Student();
        student.setStudId(1);
        student.setName("zhou");
        student.setEmail("111@qq.com");
        student.setDob("1995-5-13");
        student.setAddrId(2);
        SqlSession sqlSession=JavaAPISqlSessionFactory.getSqlSession();
        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
        studentMapper.updateStudent(student);
        sqlSession.commit();
    }
    //注意：插入和更新操作一定要提交，否则没有效果！

    @Test
    public void findAllStudents(){
        StudentMapper studentMapper=getStudentMapper();
        List<Student> students=studentMapper.findAllStudents();
        Assert.assertNotNull(students);
        for (Student stu :students) {
            System.out.println(stu.getName());
        }
    }

}