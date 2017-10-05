package com.star.mapper;

import com.star.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {
    //public Student findStudentById(int id);
    @Insert("insert into students(name,email,dob,addr_id) values(#{name},#{email},#{dob},#{addrId})")
    @Options(useGeneratedKeys = true,keyProperty = "studId")
    public int insertStudent(Student student);

    @Update("UPDATE STUDENTS SET NAME=#{name}, EMAIL=#{email}, DOB=#{dob} WHERE STUD_ID=#{studId}")
    public int updateStudent(Student student);

    @Select("SELECT * FROM STUDENTS")
    @Results(
            {
                    @Result(id = true, column = "stud_id", property = "studId"),
                    @Result(column = "name", property = "name"),
                    @Result(column = "email", property = "email"),
                    @Result(column = "addr_id", property = "addrId"),
                    @Result(column = "dob", property = "dob")
            })
    List<Student> findAllStudents();
}
