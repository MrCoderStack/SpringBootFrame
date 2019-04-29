package com.mrcoder.mrservice;


import com.mrcoder.mrentity.entity.master.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getListByAnno();

    public List<Student> getList();

    public Student getById(Long id);

    public Integer save(Student s);

    public Integer update(Student s);

    public Integer delete(Long id);

    public void trans(int code);
}
