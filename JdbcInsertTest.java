import java.sql.*;
import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/Insert_Delete_Update?allowPublicKeyRetrieval=true",
                        "root", ""
                );
                Statement statement = connection.createStatement();
        ){
//          Delete a record
//                String sqlDelete = "delete from Student where studentID like'%FPT11'";
//                System.out.println("The SQL statement is: "+ sqlDelete +"\n");
//                int countDeleted = statement.executeUpdate(sqlDelete);
//                System.out.println(countDeleted+" record deleted.\n");
//
////        Insert a record
//                String sqlInsert = "insert into Student value('FPT11','Ngoc Linh',18,'Female','0484834839')";
//                System.out.println("The SQL statement is: "+ sqlInsert +"\n");
//                int countInserted = statement.executeUpdate(sqlInsert);
//                System.out.println(countInserted+" record insert");
//
//          Update database
//                String sqlUpdate = "UPDATE Student " +
//                        "SET studentName = 'Thuy Linh' " +
//                        "WHERE studentID='FPT05';";
//                System.out.println("The SQL preparedStatement is: "+ sqlUpdate +"\n");
//                PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
//
//                int countUpdated = preparedStatement.executeUpdate(sqlUpdate);
//                System.out.println(countUpdated+" record update");
////
//          Tim kiem theo id & ten
//                  Scanner scanner = new Scanner(System.in);  // Create a Scanner scanner
//                  System.out.println("Enter studentID: ");
//                  String StudentID = scanner.nextLine();  // Read StudentID input
//                  System.out.println("StudentID is: " + StudentID);
//                  String findbyID = "SELECT * FROM Student where studentID like '%"+StudentID+"'";
//                  System.out.println(findbyID);
//            //
//                  Scanner scanner1 = new Scanner(System.in);  // Create a Scanner scanner1
//                  System.out.println("Enter studentName: ");
//                  String StudentName = scanner1.nextLine();  // Read StudentName input
//                  System.out.println("StudentName is: " + StudentName);
//                  String findbyName ="SELECT * FROM Student where studentName like '%"+StudentName+"'";
//                  System.out.println(findbyName);
//            //
//              String query[] ={findbyID,
//                      findbyName};
//                  for(String q : query){
//                  ResultSet resultSet1 = statement.executeQuery(q);
//                  System.out.println("Student for query "+q+" is(studentID, studentName, age, gender, phoneNumber): ");
//                  while (resultSet1.next()) {
//                    String studentID = resultSet1.getString("studentID");
//                    String studentName = resultSet1.getString("studentName");
//                    String age = resultSet1.getString("age");
//                    String gender = resultSet1.getString("gender");
//                    String phoneNumber = resultSet1.getString("phoneNumber");
//                    System.out.println(studentID + ", " + studentName + ", " + age + ", " + gender + ", " + phoneNumber);
//                  }
//                   System.out.println();
//              }

////            Issue a SELECT to check change
            String strSelect = "select * from Student";
            System.out.println("The SQL statement is: "+ strSelect +"\n");
            ResultSet resultSet = statement.executeQuery(strSelect);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("studentID") + ", "
                        + resultSet.getString("studentName") + ", "
                        + resultSet.getInt("age") + ", "
                        + resultSet.getString("gender") + ", "
                        + resultSet.getString("phoneNumber")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}