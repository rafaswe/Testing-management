package com.database;

import com.frame.Developer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BugReport {
    public static void retriveData(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bug_report?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            PreparedStatement st = con.prepareStatement("select * from bug_info");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String bugId = rs.getString("Bug_ID");
                String bugName = rs.getString("Bug_Name");
                String testerName = rs.getString("Tester_Name");
                String developerName = rs.getString("Developer_Name");
                String status = rs.getString("Status");
                byte[] uploadedPicture = rs.getBytes("Uploaded_Picture");
                String description = rs.getString("Description");
                String date=rs.getString("Date");
                Developer.allBugInfo(bugId, bugName, testerName, developerName,status,uploadedPicture,description,date);             
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
