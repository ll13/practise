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
        // URL指向要访问的数据库名scutcs          
              String url = "jdbc:mysql://127.0.0.1:3306/homework";
        // MySQL配置时的用户名           
              String user = "lili";              
              // MySQL配置时的密码          
              String password = "123456";
        try {             
        	// 加载驱动程序           
        	Class.forName(driver);
         // 连续数据库            
        	Connection conn = DriverManager.getConnection(url, user, password);
         if(!conn.isClosed())  
        	 
        	 System.out.println("Succeeded connecting to the Database!");
         
        // statement用来执行SQL语句           
         Statement statement = conn.createStatement();
         // 要执行的SQL语句  
         //String sql2="insert into student values(131,'womingt','man');";
          // pstm=conn.prepareStatement(sql2);
           //pstm.executeUpdate();
           //pstm.close();
         String sql = "select * from student";
       rs2 = statement.executeQuery(sql);
       
        
         String name="";
		while(rs2.next()){             
        	 // 选择sname这列数据   
         
        	 name = rs2.getString("NAME");
		     
          // 输出结果          
         
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
