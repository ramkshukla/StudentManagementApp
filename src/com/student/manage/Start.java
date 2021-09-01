package com.student.manage;

import java.io.*;

public class Start {
    public static void main(String[] args) throws IOException{
        System.out.println("Welcome to Student Management System");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.println("PRESS 1 to ADD Student");
            System.out.println("PRESS 2 to Delete Student");
            System.out.println("PRESS 3 to UPDATE Student");
            System.out.println("PRESS 4 to Display Student");
            System.out.println("PRESS 5 to Exit ");

            int c = Integer.parseInt(br.readLine());
            if (c == 1){
                //Add Student
                System.out.println("Enter use name : ");
                String name = br.readLine();

                System.out.println("Enter user Phone : ");
                String phone = br.readLine();

                System.out.println("Enter user City");
                String city = br.readLine();

                // create student object to store student
                Student st = new Student(name, phone, city);
                boolean ans = StudentDao.insertStudentToDb(st);
                if (ans){
                    System.out.println("Student added successfully");
                }
                else{
                    System.out.println("Something  went wrong");
                }

                System.out.println(st);
            }
            else if (c == 2){
                //Delete Student
                System.out.println("Enter id to Delete Student Data");
                int userId = Integer.parseInt(br.readLine());
                boolean ans = StudentDao.deleteStudent(userId);

                if (ans){
                    System.out.println("Deleted...");
                }
                else{
                    System.out.println("Something  went wrong");
                }
            }
            else if (c == 3){
                //Update Student
                int id = Integer.parseInt(br.readLine());
                String name = br.readLine();
                String phone = br.readLine();
                String city = br.readLine();
                boolean ans = StudentDao.updateStudent(id, name, phone, city);
                if (ans){
                    System.out.println("Update...");
                }
                else{
                    System.out.println("Something went wrong");
                }
            }
            else if (c == 4){
                //Display Student
                System.out.println("Display your Data");
                StudentDao.displayStudent();

            }
            else if (c == 5){
            // Exit
                break;
            }
            else{

            }

        }
        System.out.println("Thank you for using my application...");
        System.out.println("See you soon... bye bye");
    }
}
