package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DBUtil.DatabaseConnection;
import com.Exception.CourseException;
import com.Exception.StudentException;
import com.Model.Course;
import com.Model.Student;

public class StudentDAOImpl implements StudentDAO {
	
	@Override
	public boolean registraterStudent(Student std) throws StudentException {
		boolean f =false;
		//System.out.println(std.getBatch());
		try (Connection conn  = DatabaseConnection.provideDbConnection()){
			PreparedStatement ps= conn.prepareStatement("insert into student(StudentName, StudentEmail, StudentPassword, StudentMobile, StudentAddress, StudentBatch, StudentAdmissionDate) values(?,?,?,?,?,?,?)");
			ps.setString(1, std.getName());
			ps.setString(2, std.getEmail());
			ps.setString(3, std.getPassword());
			ps.setString(4, std.getMobile());
			ps.setString(5, std.getAddress());
			ps.setString(6, std.getBatch());
			ps.setString(7, std.getAdmissionDate());
			ps.executeUpdate();
			f = true;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return f;
	}
	
	@Override
	public boolean loginStudent(String username, String password) throws StudentException {
		
		try (Connection conn  = DatabaseConnection.provideDbConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from student where StudentEmail = ? and StudentPassword = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("StudentName") ;
				System.out.println("login successfully..");
				System.out.println(" ________________________________");
				System.out.println("|                                |");
				System.out.println("|       WELCOME BACK "+name.toUpperCase()+"      |");
				System.out.println("|________________________________|");
				System.out.println(" ");
	
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	
//******************************************************************Registration student****************************************************
	
//************************************************************************Update password***********************************************************

	
@Override
public boolean updatePassword(String username, String newpassword) throws StudentException {
	
		try (Connection conn  = DatabaseConnection.provideDbConnection()){
			PreparedStatement ps = conn.prepareStatement("update student set StudentPassword = ? where StudentEmail = ?");
			ps.setString(1, newpassword);
			ps.setString(2, username);
			int x = ps.executeUpdate();
			if(x>0) {
				return true;
			}else{
				return false;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	return false;
}

//***************************************************Update Email***************************************************************************

@Override
public boolean updateEmail(String username, String newEmail) throws StudentException {
	
	try (Connection conn  = DatabaseConnection.provideDbConnection()){
		PreparedStatement ps = conn.prepareStatement("update student set StudentEmail= ? where StudentEmail = ?");
		ps.setString(1, newEmail);
		ps.setString(2, username);

		int x = ps.executeUpdate();
		if(x>0) {
			return true;
		}else{
			return false;
		}
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
return false;
}

//******************************************************************Update Mobile***********************************************************************

@Override
public boolean updateMobile(String username, long newMobile) throws StudentException {
	
	try (Connection conn  = DatabaseConnection.provideDbConnection()){
		PreparedStatement ps = conn.prepareStatement("update student set Studentobile = ? where StudentEmail = ?");
		ps.setLong(1, newMobile);
		ps.setString(2, username);
		int x = ps.executeUpdate();
		if(x>0) {
			return true;
		}else{
			return false;
		}
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	return false;
}

//*********************************************************************Update Address***************************************************************
@Override
public boolean updateAddress(String username, String add) throws StudentException {
	
	try (Connection conn  = DatabaseConnection.provideDbConnection()){
		PreparedStatement ps = conn.prepareStatement("update student set StudentAddress = ? where StudentEmail = ?");
		ps.setString(1, add);
		ps.setString(2, username);
		int x = ps.executeUpdate();
		if(x>0) {
			return true;
		}else{
			return false;
		}
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	return false;
}
//******************************************************************************View Course List********************************************************************
@Override
public List<Course> viewAllCourseList() throws CourseException {
	List<Course> list = new ArrayList<>();
	
	try(Connection conn = DatabaseConnection.provideDbConnection()) {
		PreparedStatement ps = conn.prepareStatement("select * from course");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Course crs = new Course(rs.getInt(1),rs.getString(2),rs.getLong(3),rs.getString(4),rs.getString(5),rs.getInt(6), rs.getInt(7));
			list.add(crs);
		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	
	return list;
}
}
