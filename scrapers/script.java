import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

class WhatIsJdbc{
Connection conn = null;
    try {
      String url = "jdbc:mysql:source <path_to_files>/test-production.sql";
      conn = DriverManager.getConnection(url);

      Statement stmt = null;
	  for(int i=0;i<40;i++){
		String query="INSERT INTO reviews (id,course_name,Rating,Liked,Useful,Easy,Interesting, WellStructured, StudentID, InstructorID, CourseID, Description, create_time)";
		if(i>20){
			query=query+"VALUES ("+i+",cs350,";
		}else{
			query=query+"VALUES ("+i+",cs348,";
		}
		query=query+i%10+","; //Rating
		query=query+i%2+",";  
		query=query+i%2+",";
		query=query+i%2+","; //Easy
		query=query+i%2+","; //Interesting
		query=query+i%2+","; //WellStructured
		query=query+"1234,"; //StudentID has to be filled with real studentid already in db
		query=query+"1234,"; //InstructorID has to be filled
		if(i>20){
			query=query+"cs350,"; //CourseID?
		}else{
			query=query+"cs348,";
		}
		if(i%2){
			query=query+"\"What a great course, I will take it again next year!!!\",";
		}else{
			query=query+"\"What a bad course, I will never take it again!!!\",";
		}
		query=query+"CURRENT_TIME());";
		  try {
			  stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
		  } catch (SQLException e ) {
			  throw new Error("Problem", e);
		  } finally {
			  if (stmt != null) { stmt.close(); }
		  }
	  }
    } catch (SQLException e) {
        throw new Error("Problem", e);
    } finally {
      try {
        if (conn != null) {
            conn.close();
        }
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }
    }
  }
}