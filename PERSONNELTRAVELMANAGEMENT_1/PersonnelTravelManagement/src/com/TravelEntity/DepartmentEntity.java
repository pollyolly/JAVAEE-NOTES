package com.TravelEntity;

public class DepartmentEntity extends StatusEntity{
private int departmentid;
private String department;
private String description;

public DepartmentEntity(){}

public int getDepartmentid() {
	return departmentid;
}
public void setDepartmentid(int departmentid) {
	this.departmentid = departmentid;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

}
