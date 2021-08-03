package com.database;
import java.sql.*;

public class BugInsertion {

    public static boolean isUnique(String ID) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String MySQLURL = "jdbc:mysql://localhost:3306/bug_report?useSSL=false";
            Connection con = null;
            con = DriverManager.getConnection(MySQLURL, "root", "");
            PreparedStatement st = con.prepareStatement("Select Bug_ID from bug_info where Bug_ID=? ");
            st.setString(1, ID);
            ResultSet r = st.executeQuery();
            if (r.next()) {
                return false;
            } else {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return true;
    }

    public static void dataInsertion(String BugId, String BugName, String TesterID, String DeveloperName, String Status, byte[] photo, String Description, String Date) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String MySQLURL = "jdbc:mysql://localhost:3306/bug_report?useSSL=false";
            Connection con = null;
            con = DriverManager.getConnection(MySQLURL, "root", "");
            PreparedStatement st = con.prepareStatement("Insert into bug_info(Bug_ID,Bug_Name,Tester_Name,Developer_Name,Status,Uploaded_Picture,Description,Date) values(?,?,?,?,?,?,?,?)");
            st.setString(1, BugId);
            st.setString(2, BugName);
            st.setString(3, TesterID);
            st.setString(4, DeveloperName);
            st.setString(5, Status);
            st.setBytes(6, photo);
            st.setString(7, Description);
            st.setString(8, Date);
            st.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
