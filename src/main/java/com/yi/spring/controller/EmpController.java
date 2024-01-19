package com.yi.spring.controller;

import com.yi.spring.mappers.EmployeeMapper;
import com.yi.spring.service.EmployeeService;
import com.yi.spring.vo.EmployeeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@ComponentScan
@RequestMapping("/emp/*")
public class EmpController {
    private static final Logger logger
            = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeMapper employeeMapper;


    @GetMapping("/emplist")
    public String  empList(EmployeeVO vo, Model model) throws Exception{
        List<EmployeeVO> employeeList = employeeService.listEmployees();
        System.out.println(employeeList);

        return "/emp/emp_list";
    }

    @GetMapping("/emplist2")
    public String  empList2(EmployeeVO vo, Model model) throws Exception{
        List<EmployeeVO> employeeList = employeeMapper.listEmployees();
        logger.info(employeeList.toString());

        return "/emp/emp_list";
    }






}
