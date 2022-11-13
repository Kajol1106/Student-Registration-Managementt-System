package com.DAO;

import java.util.List;

import com.Exception.CourseException;
import com.Exception.StudentException;
import com.Model.Course;
import com.Model.Student;

public interface StudentDAO {
	public boolean registraterStudent(Student std) throws StudentException;
	
	public boolean loginStudent(String username, String password) throws StudentException;
	
	public boolean updatePassword(String username, String newpassword) throws StudentException;
	
	public boolean updateEmail(String username, String newEmail) throws StudentException;
	
	public boolean updateMobile(String username, long newMobile) throws StudentException;
	
	public boolean updateAddress(String username, String add) throws StudentException;
	
	public List<Course> viewAllCourseList() throws CourseException;
	
	
}
