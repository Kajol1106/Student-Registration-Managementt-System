**Hii, This is a Student Management System Project Using JDBC, SQL and Core Java topics.
This is a console based application.

Output :
//main part
*************************************************************************
|                                                        				|
|            --Welcome to Student Management System ---                 |
|                                                        				|
*************************************************************************

Press 1 : If you are a Administrator
Press 2 : If your are a Student
Press 0 : Exit App
1
Enter your username(email id is username) : a1@gmail.com
Enter your password : admin1
Login Successfull 👍...
*****************************Welcome To Student Management App Admin 🤴a1@gmail.com*****************************

//For Admin Usecases :
Press 1 : Add new course
Press 2 : Update Course Fee
Press 3 : Delete a course from any training session
Press 4 : Search information about a course
Press 5 : Create Batch under a course
Press 6 : Allocate students in a Batch under a course
Press 7 : Update total seats of a batch
Press 8 : View the students of every batch
Press 0 : Log out
1
You have selected : Add new course
Enter Course Name : PHP
Enter Course Fee : 6000
Enter Course Duration : 3 month
Enter Course Start Date : 10 Nov, 2022
Enter Total Seats : 50
Enter Available Seats : 50
PHP course inserted successfully in database

***********************************************************************************

Press 1 : Add new course
Press 2 : Update Course Fee
Press 3 : Delete a course from any training session
Press 4 : Search information about a course
Press 5 : Create Batch under a course
Press 6 : Allocate students in a Batch under a course
Press 7 : Update total seats of a batch
Press 8 : View the students of every batch
Press 0 : Log out
2
You have selected : Update Course Fee
Enter Course Id :1
Enter Course New Fee :9000
for course Id 1 Fee Updatation is successfull...
*********************************************************************************

Press 1 : Add new course
Press 2 : Update Course Fee
Press 3 : Delete a course from any training session
Press 4 : Search information about a course
Press 5 : Create Batch under a course
Press 6 : Allocate students in a Batch under a course
Press 7 : Update total seats of a batch
Press 8 : View the students of every batch
Press 0 : Log out
3
You have selected : Delete Course Using Course Id 
Enter Course Id : 1
1 course deletion is successfull...
*********************************************************************************

Press 1 : Add new course
Press 2 : Update Course Fee
Press 3 : Delete a course from any training session
Press 4 : Search information about a course
Press 5 : Create Batch under a course
Press 6 : Allocate students in a Batch under a course
Press 7 : Update total seats of a batch
Press 8 : View the students of every batch
Press 0 : Log out
4
You have selected : Search Course Information Using Course Id 
Enter Course Id : 4
You can see all information about this course below :
Course [cid=4, cname=PHP, courseFee=6000, cDuration=3 month, cStart=3 month, totalSeat=50, availableSeat=50]
*********************************************************************************

Press 1 : Add new course
Press 2 : Update Course Fee
Press 3 : Delete a course from any training session
Press 4 : Search information about a course
Press 5 : Create Batch under a course
Press 6 : Allocate students in a Batch under a course
Press 7 : Update total seats of a batch
Press 8 : View the students of every batch
Press 0 : Log out
0
|************************|
|     --THANK YOU--      |
|************************|

//Note : From case 5 to case 8 work is pending. I will update as soon as possible.

//For Student Usecases :
Press 1 : If you are a Administrator
Press 2 : If your are a Student
Press 0 : Exit App
2
Press 1 : If you didn't registered. Please Register
Press 2 : Login
Press 0 : Exit App
1
Here you can register...
Enter name : kajal
Enter email : kaju@gmail.com
Enter Password : kaju
Enter Mobile Number : 1234567890
Enter address : Pune
Enter Course which u want : SpringBoot
Student record Inserted Successfully...
Your Record Details is :
Student [roll=0, name=kajal, email=kaju@gmail.com, password=kaju, mobile=1234567890, address=Pune, batch=SpringBoot, admissionDate=null]
*****************************Welcome To Student Management App Student 🤴kajal*****************************

Press 1 : Update your password
Press 2 : Update your email id
Press 3 : Update your Mobile number
Press 4 : Update your address
Press 5 : View all available course list and their seat availability
Press 0 : Log out
1
You have selected : Update Password
Enter Username (Email id is a your username) : kaju@gmail.com
Enter New Password : kajal
Password updated Successfully...
Your new password is : kajal
*********************************************************************************

Press 1 : Update your password
Press 2 : Update your email id
Press 3 : Update your Mobile number
Press 4 : Update your address
Press 5 : View all available course list and their seat availability
Press 0 : Log out
2
You have selected : Update Email Id
Enter Username (Email id is a your username) : kk@gmail.com
Enter New Email Id : krushna@gmail.com
Password updated Successfully...
Your new Email Id is : krushna@gmail.com
*********************************************************************************

Press 1 : Update your password
Press 2 : Update your email id
Press 3 : Update your Mobile number
Press 4 : Update your address
Press 5 : View all available course list and their seat availability
Press 0 : Log out
3
You have selected : Update Mobile Number
Enter Username (Email id is a your username) : kaju@gmail.com
Enter New Mobile Number : 8765432190
Mobile number updated Successfully...
Your new Mobile Number is : 8765432190
*********************************************************************************

Press 1 : Update your password
Press 2 : Update your email id
Press 3 : Update your Mobile number
Press 4 : Update your address
Press 5 : View all available course list and their seat availability
Press 0 : Log out
4
You have selected : Update Address
Enter Username (Email id is a your username) : kaju@gmail.com
Enter New Address :Mumbai
Address updated Successfully...
Your new address is : Mumbai
*********************************************************************************

Press 1 : Update your password
Press 2 : Update your email id
Press 3 : Update your Mobile number
Press 4 : Update your address
Press 5 : View all available course list and their seat availability
Press 0 : Log out
5
You have selected : View all available course list and their seat availability
Course List ...
Course [cid=4, cname=PHP, courseFee=6000, cDuration=3 month, cStart=3 month, totalSeat=50, availableSeat=50]
Course [cid=5, cname=java, courseFee=5000, cDuration=5 month, cStart=5 month, totalSeat=50, availableSeat=50]
Course [cid=6, cname=PHP, courseFee=3000, cDuration=3 month, cStart=3 month, totalSeat=40, availableSeat=40]
*********************************************************************************

Press 1 : Update your password
Press 2 : Update your email id
Press 3 : Update your Mobile number
Press 4 : Update your address
Press 5 : View all available course list and their seat availability
Press 0 : Log out
0
|************************|
|     --THANK YOU--      |
**************************

Press 1 : If you didn't registered. Please Register
Press 2 : Login
Press 0 : Exit App
2
Here you can login...
Enter your username(email id is username) :
kaju@gmail.com
Enter your password : kaju
login successfully..
 ________________________________
|                                |
|       WELCOME BACK KAJAL      |
|________________________________|
 
*****************************Welcome To Student Management App Student 🤴kaju@gmail.com*****************************

**Press 1 : Update your password
Press 2 : Update your email id
Press 3 : Update your Mobile number
Press 4 : Update your address
Press 5 : View all available course list and their seat availability
Press 0 : Log out
0**

**//Exit App
Press 1 : If you are a Administrator
Press 2 : If your are a Student
Press 0 : Exit App
0**
**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
|                                                        |
|            --Thank You for Visiting--                  |
|                                                        |
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++**

**If You Enjoyed, Please Experience It Again!**






