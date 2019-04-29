package com.mrcoder.webservice.controller;

import com.mrcoder.mrentity.entity.master.Student;
import com.mrcoder.mrservice.RedisService;
import com.mrcoder.mrservice.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(value = "Test", description = "Test测试Controller")
public class TestController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private RedisService redisService;


    private Log logger = LogFactory.getLog(getClass());

    @ApiOperation(value = "log测试接口", notes = "测试写level日志")
    @RequestMapping("log")
    public void testAll() {
        logger.info("====info");
        logger.warn("====warn");
        logger.error("====error");
    }

    //列表查询
    @RequestMapping("getStudentList")
    public ResponseEntity<List<Student>> getStudentList() {
        return ResponseEntity.ok(studentService.getList());
    }

    //列表查询
    @RequestMapping("getStudentListByAnno")
    public ResponseEntity<List<Student>> getStudentListByAnno() {
        return ResponseEntity.ok(studentService.getListByAnno());
    }

    //新增
    @RequestMapping("addStudent")
    public int addStudent() {
        Student student = new Student();
        student.setAge(1);
        student.setGrade(1);
        student.setName("student");
        return studentService.save(student);
    }

    //更新
    @RequestMapping("updateStudent/{id}")
    public int updateStudent(@PathVariable(name = "id") Long id) {
        Student student = new Student();
        student.setAge(10);
        student.setGrade(10);
        student.setName("update");
        student.setId(id);
        return studentService.update(student);
    }

    //删除
    @RequestMapping("deleteStudent/{id}")
    public int deleteStudent(@PathVariable(name = "id") Long id) {
        return studentService.delete(id);
    }

    //事务
    @RequestMapping("transSuccess")
    public void transSuccess() {
        //人为制造0除异常测试事务分布式事务回滚
        studentService.trans(1);
    }

    //事务
    @RequestMapping("transRoll")
    public void transRoll() {
        //人为制造0除异常测试事务分布式事务回滚
        studentService.trans(0);
    }

    //redis string读写
    @RequestMapping(value = "/redis")
    public String redis() {

        redisService.setValue("test", "test123");
        return redisService.getValue("test").toString();
    }

}
