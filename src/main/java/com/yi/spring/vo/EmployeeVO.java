package com.yi.spring.vo;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmployeeVO {
	private String empCode;
	private String empName;
	private String empTitle;
	private String empAuth;
	private int empSalary;
	private String empTel;
	private String empId;
	private String empPwd;
	private DepartmentVO dept;
	private String pic;
	private boolean empRetire;

	
}
