package JDBC;
import java.sql.*;
public class StudentSystem {
    Connection conn;
    Statement stat;
    static PreparedStatement pstm;
    ResultSet rs;
	private static ResultSet rs2;
    
    public static void main(String[] args){
             String driver = "com.mysql.jdbc.Driver";
              //String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
        // URLָ��Ҫ���ʵ����ݿ���scutcs          
              String url = "jdbc:mysql://127.0.0.1:3306/homework";
        // MySQL����ʱ���û���           
              String user = "lili";              
              // MySQL����ʱ������          
              String password = "123456";
        try {             
        	// ������������           
        	Class.forName(driver);
         // �������ݿ�            
        	Connection conn = DriverManager.getConnection(url, user, password);
         if(!conn.isClosed())  
        	 
        	 System.out.println("Succeeded connecting to the Database!");
         
        // statement����ִ��SQL���           
         Statement statement = conn.createStatement();
         // Ҫִ�е�SQL���  
         //String sql2="insert into student values(131,'womingt','man');";
          // pstm=conn.prepareStatement(sql2);
           //pstm.executeUpdate();
           //pstm.close();
         String sql = "select * from student";
       rs2 = statement.executeQuery(sql);
       
        
         String name="";
		while(rs2.next()){             
        	 // ѡ��sname��������   
         
        	 name = rs2.getString("NAME");
		     
          // ������          
         
		System.out.println( name); 
		}
         rs2.close();            
         conn.close();
        } catch(ClassNotFoundException e) {
         System.out.println("Sorry,can`t find the Driver!");   
         e.printStackTrace();
       } catch(SQLException e) {
         e.printStackTrace();
        } catch(Exception e) {
       e.printStackTrace();
      } } 
    
}
