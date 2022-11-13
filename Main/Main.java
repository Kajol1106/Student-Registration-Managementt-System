package com.Main;

import java.io.*;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.DAO.AdminDAO;
import com.DAO.AdminDAOImpl;
import com.DAO.StudentDAO;
import com.DAO.StudentDAOImpl;
import com.Exception.AdminException;
import com.Exception.BatchException;
import com.Exception.CourseException;
import com.Exception.InputMistMatchException;
import com.Exception.StudentException;
import com.Model.Course;
import com.Model.Student;

public class Main {

	public static void main(String[] args) {
		
		try {
			startRun();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	
	public static void startRun() throws Exception{
		StudentDAOImpl sDao = new StudentDAOImpl();
		AdminDAOImpl aDao = new AdminDAOImpl();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		try {
			System.out.println("Press 1 : If you are a Administrator");
			System.out.println("Press 2 : If your are a Student");
			System.out.println("Press 0 : Exit App");
			int mainCases = Integer.parseInt(br.readLine());
			switch(mainCases) {
//=========================================================================================Main case 1============================================================================			
			case 1:
				try {
					System.out.print("Enter your username(email id is username) : ");
					String adminUserName = br.readLine();
					System.out.print("Enter your password : ");
					String adminPass = br.readLine();
					boolean check = aDao.adminLogIn(adminUserName, adminPass);
					if(check) {
						String message = "Welcome To Student Management App Admin " + "🤴" + adminUserName + "";
						System.out.println("*****************************"+ message + "*****************************\n\n");
						
						//adminusecases work implementation
						adminWork();
					}
					else {
						System.out.println("Log in failed. Invalid username or password. Please try again\n");
						System.out.println("************************************************\n\n");
						startRun();
					}
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
					startRun();;
					
				}
				
				break;
				
//=============================================================================================Main case 2====================================================================================				
				
			case 2:
				System.out.println("Press 1 : If you didn't registered. Please Register");
				System.out.println("Press 2 : Login");
				System.out.println("Press 0 : Exit App");
				int studentCases = Integer.parseInt(br.readLine());
				switch(studentCases) {
				//*****************************************************************************student case 1****************************************************************
				case 1:
					System.out.println("Here you can register...");
					System.out.print("Enter name : ");
					String name = br.readLine();
					System.out.print("Enter email : ");
					String email = br.readLine();
					System.out.print("Enter Password : ");
					String password = br.readLine();
					System.out.print("Enter Mobile Number : ");
					String mobile = br.readLine();
					System.out.print("Enter address : ");
					String address = br.readLine();
					System.out.print("Enter Course which u want : ");
					String cname = br.readLine();
					
					//create student object
					Student st = new Student(name, email, password, mobile, address, cname);
					boolean scheck; 
					try {
						scheck = sDao.registraterStudent(st);
						if(scheck) {
							System.out.println("Student record Inserted Successfully...");
							System.out.println("Your Record Details is :");
							System.out.println(st);
							
							String message = "Welcome To Student Management App Student " + "🤴" + name + "";
							System.out.println("*****************************"+ message + "*****************************\n\n");
							
							//studentusecases work implementation
							studentWork();
							
						}else {
							System.out.println("Some error Occured While Inserting...Please try Again!");
							//startRun();
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
						System.out.println("Please try again...\n\n");
						startRun();
					}
					
					break;

				
				//***************************************************************************student case 2************************************************************************
										
				case 2:
					System.out.println("Here you can login...");
					
					try {
						System.out.println("Enter your username(email id is username) :");
						String studentUserName = br.readLine();
						System.out.print("Enter your password : ");
						String studentPass = br.readLine();
						boolean check = sDao.loginStudent(studentUserName, studentPass);
						if(check) {
							String message = "Welcome To Student Management App Student " + "🤴" + studentUserName + "";
							System.out.println("*****************************"+ message + "*****************************\n\n");
							
							//studentusecases work implementation
							studentWork();
						}
						else {
							System.out.println("Log in failed. Invalid username or password. Please try again\n");
							System.out.println("************************************************\n\n");
							startRun();
						}
					} catch (InputMismatchException e) {
						System.out.println(e.getMessage());
						startRun();
					}
					
					break;
					
					
				//***************************************************************************student case 0 ******************************************************************	
					
				case 0:
					System.out.println("|************************|");
					System.out.println("|     --Thank You--      |");
					System.out.println("**************************");
					System.out.println("\n\n");
					startRun();
					break;
				}
				
				
				
			
//============================================================================================Main case 0=======================================================================				
				
				
			case 0:
				System.out.println();
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("|                                                        |");
				System.out.println("|            --Thank You for Visiting--                  |");
				System.out.println("|                                                        |");
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("\n\n");
				System.out.println("If You Enjoyed, Please Experience It Again!");
				br.close();
			}
			
		
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());;
		}
	}
	
	
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	
	
//==========================================Admin Work Start=====================================================================================
	
	
	public static void adminWork() throws Exception {
		AdminDAO dao = new AdminDAOImpl();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Press 1 : Add new course");
			System.out.println("Press 2 : Update Course Fee");
			System.out.println("Press 3 : Delete a course from any training session");
			System.out.println("Press 4 : Search information about a course");
			System.out.println("Press 5 : Create Batch under a course");
			System.out.println("Press 6 : Allocate students in a Batch under a course");
			System.out.println("Press 7 : Update total seats of a batch");
			System.out.println("Press 8 : View the students of every batch");
			System.out.println("Press 0 : Log out");
			int cases = Integer.parseInt(br.readLine());
			useCasesOfAdmin(cases, dao, br);
			System.out.println();
		} catch (InputMismatchException e) {
			System.out.println("Oop's...Invalid input...");
			System.out.println("--------------------------\n\n");
			adminWork();
		}
		
	}
	
	
	
	public static void useCasesOfAdmin(int num, AdminDAO dao, BufferedReader br) throws Exception {
		switch(num) {
		case 1:
			System.out.println("You have selected : Add new course");
			try {
				System.out.print("Enter Course Name : ");
				String cname = br.readLine();
				System.out.print("Enter Course Fee : ");
				long cfee = Long.parseLong(br.readLine());
				System.out.print("Enter Course Duration : ");
				String cDuration = br.readLine();
				System.out.print("Enter Course Start Date : ");
				String cdate = br.readLine();
				System.out.print("Enter Total Seats : ");
				int tSeat = Integer.parseInt(br.readLine());
				System.out.print("Enter Available Seats : ");
				int aSeat = Integer.parseInt(br.readLine());
				
				//create course object
				Course courses = new Course(cname, cfee, cDuration, cdate, tSeat, aSeat);
				try {
					System.out.println(dao.addNewCourse(courses));
					System.out.println("\n\n");
				} catch (CourseException e) {
					System.out.println(e.getMessage());;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Oop's invalid input");
			}
			
			System.out.println("***********************************************************************************\n\n");
			adminWork();
			break;
			
		//********************************************************************************
			
		case 2:
			System.out.println("You have selected : Update Course Fee");
			try {
				System.out.print("Enter Course Id :");
				int cid = Integer.parseInt(br.readLine());
				System.out.print("Enter Course New Fee :");
				long cfee = Long.parseLong(br.readLine());
	
				try {
					System.out.println(dao.updateFeesOfCourseUsingCId(cid, cfee));
				} catch (CourseException e) {
					System.out.println(e.getMessage());;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Oop's invalid input");
			}
			
			System.out.println("*********************************************************************************\n\n");
			adminWork();
			break;
			
		//********************************************************************************
		
		case 3:
			System.out.println("You have selected : Delete Course Using Course Id ");
			try {
				System.out.print("Enter Course Id : ");
				int cid = Integer.parseInt(br.readLine());
	
				try {
					System.out.println(dao.deleteCourseUsingCId(cid));
				} catch (CourseException e) {
					System.out.println(e.getMessage());;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Oop's invalid input");
			}
			
			System.out.println("*********************************************************************************\n\n");
			adminWork();
			
			break;
			
		//********************************************************************************
		
		case 4:
			System.out.println("You have selected : Search Course Information Using Course Id ");
			try {
				System.out.print("Enter Course Id : ");
				int cid = Integer.parseInt(br.readLine());
	
				try {
					System.out.println(dao.searchInfoUsingCId(cid));
				} catch (CourseException e) {
					System.out.println(e.getMessage());;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Oop's invalid input");
			}
			
			System.out.println("*********************************************************************************\n\n");
			adminWork();
			
			break;
		//********************************************************************************
		
		case 5:
			try {
				System.out.println("case 5 work is pending");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			break;
			
		//********************************************************************************
			
		case 6:
			try {
				System.out.println("case 6 work is pending");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			break;
			
		//********************************************************************************
		
		case 7:
			try {
				System.out.println("case 7 work is pending");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			break;
			
		//********************************************************************************
		
		case 8:
			try {
				System.out.println("case 8 work is pending");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			break;
		//********************************************************************************
			
		case 0:
			System.out.println("|************************|");
			System.out.println("|     --THANK YOU--      |");
			System.out.println("|************************|");
			startRun();
			break;
			
		}
	}
	
	
	
//==================================================Student Work Start=====================================================================================
	
	
	public static void studentWork() throws Exception {
		StudentDAO dao = new StudentDAOImpl();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Press 1 : Update your password");
			System.out.println("Press 2 : Update your email id");
			System.out.println("Press 3 : Update your Mobile number");
			System.out.println("Press 4 : Update your address");
			System.out.println("Press 5 : View all available course list and their seat availability");
			System.out.println("Press 0 : Log out");
			int cases = Integer.parseInt(br.readLine());
			useCasesOfStudent(cases, dao, br);
		} catch (InputMismatchException e) {
			System.out.println("Oop's...Invalid input...");
			System.out.println("--------------------------");
			studentWork();
		}
		
	}
	
	
	public static void useCasesOfStudent(int num, StudentDAO dao, BufferedReader br) throws IOException {
		switch(num) {
		case 1:
			System.out.println("You have selected : Update Password");
			try {
				System.out.print("Enter Username (Email id is a your username) : ");
				String username = br.readLine();
				System.out.print("Enter New Password : ");
				String pass = br.readLine();
				try {
					if(dao.updatePassword(username, pass)) {
						System.out.println("Password updated Successfully...");
						System.out.println("Your new password is : "+ pass);
					}
					else {
						System.out.println("Something went wrong. Please kindly check your username ");
					}
				} catch (StudentException e) {
					System.out.println(e.getMessage());
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Oop's invalid input");
			}
			
			System.out.println("*********************************************************************************");
			try {
				studentWork();
			} catch (Exception e5) {
				e5.printStackTrace();
			}
			break;
			
			
		case 2:
			System.out.println("You have selected : Update Email Id");
			try {
				System.out.print("Enter Username (Email id is a your username) : ");
				String username = br.readLine();
				System.out.print("Enter New Email Id : ");
				String email = br.readLine();
				try {
					if(dao.updateEmail(username, email)) {
						System.out.println("Password updated Successfully...");
						System.out.println("Your new Email Id is : "+ email);
					}
					else {
						System.out.println("Something went wrong. Please kindly check your username ");
					}
				} catch (StudentException e) {
					System.out.println(e.getMessage());;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Oop's invalid input");
			}
			
			System.out.println("*********************************************************************************");
			try {
				studentWork();
			} catch (Exception e4) {
				e4.printStackTrace();
			}
			break;
			
			
		case 3:
			System.out.println("You have selected : Update Mobile Number");
			try {
				System.out.print("Enter Username (Email id is a your username) : ");
				String username = br.readLine();
				System.out.print("Enter New Password : ");
				long mobile = Long.parseLong(br.readLine());
				try {
					if(dao.updateMobile(username, mobile)) {
						System.out.println("Mobile number updated Successfully...");
						System.out.println("Your new Mobile Number is : "+ mobile);
					}
					else {
						System.out.println("Something went wrong. Please kindly check your username ");
					}
					
				} catch (StudentException e) {
					System.out.println(e.getMessage());;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Oop's invalid input");
			}
			
			System.out.println("*********************************************************************************");
			try {
				studentWork();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			break;
			
			
		case 4:
			System.out.println("You have selected : Update Address");
			try {
				System.out.print("Enter Username (Email id is a your username) : ");
				String username= br.readLine();;
				System.out.print("Enter New Password :");
				String address= br.readLine();
				try {
					if(dao.updateAddress(username, address)) {
						System.out.println("Address updated Successfully...");
						System.out.println("Your new password is : "+ address);
					}
					else {
						System.out.println("Something went wrong. Please kindly check your username ");
					}
					
				} catch (StudentException e) {
					System.out.println(e.getMessage());;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Oop's invalid input");
			}
			
			System.out.println("*********************************************************************************");
			try {
				studentWork();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			break;
			
			
		case 5:
			System.out.println("You have selected : View all available course list and their seat availability");
			try {
				List<Course> list;
				try {
					list = dao.viewAllCourseList();
					if(list.size()>0) {
						System.out.println("Course List ...");
						list.forEach(el -> System.out.println(el));
					}
					else {
						System.out.println("Sorry, Courses are not available now");
					}
				} catch (CourseException e) {
					e.printStackTrace();
				}
			} catch (InputMismatchException e) {
				System.out.println("Oop's invalid input");
			}
			
			System.out.println("*********************************************************************************");
			try {
				studentWork();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
			
			
		case 0:
			try {
				System.out.println("|************************|");
				System.out.println("|     --THANK YOU--      |");
				System.out.println("**************************");
				System.out.println("\n\n\n");
				startRun();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
	}
	
}


