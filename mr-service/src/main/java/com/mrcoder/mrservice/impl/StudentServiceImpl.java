package com.mrcoder.mrservice.impl;

import com.mrcoder.mrentity.entity.master.Student;
import com.mrcoder.mrentity.entity.slave.Teacher;
import com.mrcoder.mrentity.mapper.master.StudentMapper;
import com.mrcoder.mrentity.mapper.slave.TeacherMapper;
import com.mrcoder.mrservice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    public List<Student> getListByAnno() {
        return studentMapper.getListByAnno();
    }

    public List<Student> getList() {
        return studentMapper.getList();
    }

    public Student getById(Long id) {
        return studentMapper.getById(id);
    }

    public Integer save(Student s) {
        return studentMapper.insert(s);
    }

    public Integer update(Student s) {
        return studentMapper.update(s);
    }

    public Integer delete(Long id) {
        return studentMapper.delete(id);
    }

    @Transactional
    public void trans(int code) {
        Student s1 = new Student();
        s1.setAge(10);
        s1.setGrade(10);
        s1.setName("s1");
        studentMapper.insert(s1);

        Teacher t1 = new Teacher();
        t1.setAge(10);
        t1.setName("t1");
        t1.setCourse(10);
        teacherMapper.insert(t1);
        int result = 1 / code;
    }
}

