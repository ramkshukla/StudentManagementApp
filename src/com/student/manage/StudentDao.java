package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class StudentDao {

    public static boolean insertStudentToDb(Student st) {
        boolean f = false;
        try {
            //jdbc code...
            Connection con = CP.createC();
            String q = "insert into Student(studentName, studentPhone, studentCity)" +
                    "values (?, ?, ?)";

            //preparedStatement
            PreparedStatement stmt = con.prepareStatement(q);

            // set the values of parameter
            stmt.setString(1, st.getStudentName());
            stmt.setString(2, st.getStudentPhone());
            stmt.setString(3, st.getStudentCity());

            // execute...
            stmt.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public static boolean deleteStudent(int userId) {
        boolean f = false;
        try{
            //jdbc code...
            Connection con = CP.createC();
            String q = "delete from Student where studentId=?";

            //preparedStatement
            PreparedStatement stmt = con.prepareStatement(q);

            // set the values of parameter
            stmt.setInt(1, userId);

            // execute...
            stmt.executeUpdate();
            f = true;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static void displayStudent(){

        try{
            Connection con = CP.createC();
            String q = "select * from Student";
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);
            while (set.next()){
                int id = set.getInt(1);
                String name = set.getString(2);
                String phone = set.getString(3);
                String city = set.getString("studentCity");
                System.out.println("Id : " + id);
                System.out.println("Student Name : " + name);
                System.out.println("Student Phone : " + phone);
                System.out.println("Student City : " + city);
                System.out.println("+++++++++++++++++++++++++++++++");

            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean updateStudent(int id, String name, String phone, String city){
        boolean f = false;
        try{
            //jdbc code...
            Connection con = CP.createC();
            String q = "update Student set studentName=?, studentPhone=?, studentCity=? where studentId=?";

            //preparedStatement
            PreparedStatement stmt = con.prepareStatement(q);

            //set the values of the parameter


            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.setString(3, city);
            stmt.setInt(4, id);

            // execute...
            stmt.executeUpdate();
            f = true;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

}

