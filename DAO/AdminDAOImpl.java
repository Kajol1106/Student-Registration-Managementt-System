package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DBUtil.DatabaseConnection;
import com.Exception.AdminException;
import com.Exception.BatchException;
import com.Exception.CourseException;
import com.Exception.StudentException;
import com.Model.Course;
import com.Model.Student;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public boolean adminLogIn(String userName, String password) throws AdminException {
		boolean check = false;
		//String message = "Please Enter Correct Details of Admin ";
		
		try(Connection conn = DatabaseConnection.provideDbConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from admin where AdminEmail=? and AdminPassword=?");
			ps.setString(1, userName);
			ps.setNString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("Login Successfull 👍...");
				//message = "Welcome back to Student Management System Admin 🤴 "+rs.getString("AdminName");
				//return true;
				check = true;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return check;
	}
	
	
	

	@Override
	public String addNewCourse(Course course) throws CourseException {
		String message = "course insertion is failed please try again to insert...";
		
		try(Connection conn = DatabaseConnection.provideDbConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into course values(?,?,?,?,?,?,?)");
			ps.setInt(1, course.getCid());
			ps.setString(2, course.getCname());
			ps.setLong(3, course.getCourseFee());
			ps.setString(4,course.getcDuration());
			ps.setString(5,course.getcStart());
			ps.setInt(6, course.getTotalSeat());
			ps.setInt(7, course.getAvailableSeat());
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = course.getCname() + "course inserted successfully in database";
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return message;
	}

	
	
	@Override
	public String updateFeesOfCourseUsingCId(int cid, long fee) throws CourseException {
		String message = "Fee updation failed please try again...";
		
		try(Connection conn = DatabaseConnection.provideDbConnection()) {
		
			PreparedStatement ps = conn.prepareStatement("update course set CourseFee=? where CourseId=?");
			ps.setLong(1, fee);
			ps.setInt(2, cid);
			int x = ps.executeUpdate();
			if(x>0) {
				message ="for course Id "+cid+" Fee Updatation is successfull...";
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return message;
	}
	
	
	

	@Override
	public String deleteCourseUsingCId(int cid) throws CourseException {
		String message = "Course deletion is falied please try again with correct course id...";
		
		try(Connection conn = DatabaseConnection.provideDbConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("delete from course where CourseId=?");
			ps.setInt(1, cid);
			int x = ps.executeUpdate();
			if(x>0) {
				message  = x+" course deletion is successul...";
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return message;
	}
	
	
	

	@Override
	public Course searchInfoUsingCId(int cid) throws CourseException {
		Course course = null;
		try(Connection conn = DatabaseConnection.provideDbConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from course where CourseId=?");
			ps.setInt(1, cid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int courseId=rs.getInt("CourseId");
				String courseName = rs.getString("CourseName");
				long fee  = rs.getLong("CourseFee");
				String duration= rs.getString("CourseDuration");
				String courseStart = rs.getString("CourseStartDate");
				int totalsets = rs.getInt("TotalSeat");
				int avlblSeats = rs.getInt("AvailableSeat");
				Course cs = new Course(courseId, courseName, fee, duration,courseStart,totalsets, avlblSeats);
				System.out.println("You can see all information about this course below :");
				
				course =cs;
				
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return course;
	}

	@Override
	public String createBatchUnderCourse(int cid, String batch, int totalSeat) throws BatchException {
		String message = "Batch creation is failed please try again...";
		try(Connection conn = DatabaseConnection.provideDbConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into batch (CourseId, BatchName, TotalSeat) values(?,?,?) ");
			ps.setInt(1, cid);
			ps.setString(2, batch);
			ps.setInt(2, totalSeat);
			int x = ps.executeUpdate();
			if(x>0) {
				message = batch + " Batch created successfully...";
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return message;
	}
	
	

	@Override
	public int allocateBatchToStudent(String email, String cname) throws BatchException, StudentException {
		int totalStudents = 0;
		try(Connection conn = DatabaseConnection.provideDbConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select b.BatchName, b.TotalEnrolledStudent, b.TotalSeats from course c, batch b, student s where c.CourseId=b.CourseId and c,CourseId=s.CourseId and c.CourseName=?");
			ps.setString(1, cname);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String batch= rs.getString("BatchName");
				
				int totalEnrolledStudent = rs.getInt("TotalEnrolledStudent");
				int totalSeats = rs.getInt("TotalSeats");
				
				PreparedStatement ps1 = conn.prepareStatement("Update student set BatchName=? where StudentEmail =?");
				ps1.setString(1, batch);
				ps1.setString(2, email);
				int x = ps1.executeUpdate();
				//totalStudents=x;
				if(x>0) {
					
					PreparedStatement ps2;
					if(totalEnrolledStudent < totalSeats) {
						ps2 = conn.prepareStatement("update batch set  TotalEnrolledStudent = TotalEnrolledStudent+? where BatchName = ? ");
						ps2.setInt(1, x);
						ps2.setString(2, batch);
						totalStudents=x;
						int y = ps2.executeUpdate();
					}else {
						System.out.println("Batch seats full you can not allocate to any student ");	
						return -1;
					}
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return 2;
		}
		
		return totalStudents;
	}

	@Override
	public String updateTotalSeatsInBatch(String batch, int seats) throws BatchException {
		String message = "Seat updation is failed please try again...";
		try(Connection conn = DatabaseConnection.provideDbConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update bach set TotalSeat=? where BatchName=?");
			ps.setInt(1, seats);
			ps.setString(2, batch);
			int x =ps.executeUpdate();
			if(x>0) {
				message = "Seats updated successfully...";
			}
		} catch (SQLException e) {
			message = e.getMessage();
		}
		return message;
	}

	@Override
	public List<Student> viewAllStudents() throws StudentException {
		List<Student> studentList = new ArrayList<>();
		
		try(Connection conn = DatabaseConnection.provideDbConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from student order by BatchName ASC");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Student s = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
				studentList.add(s);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return studentList;
		}
		
		return studentList;
	}
//	
//	
//	
//	try(Connection conn = DatabaseConnection.provideDbConnection()) {
//		
//		PreparedStatement ps = conn.prepareStatement("");
//		
//	} catch (SQLException e) {
//		
//	}
	

}
