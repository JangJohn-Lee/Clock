package JAEGUTIMES_Final_ver;



import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JGDBInsert {
	public JGDBInsert () {
		Connection conn = null;
		try {
			//JDBC Driver 등록
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//연결하기
			conn = DriverManager.getConnection(
					"jdbc:mysql://222.119.100.81:3382/jaegutimes", 
					"jaegutimes", 
					"jaegutimes*"
				);					
			
			//매개변수화된 SQL문 작성 
			String sql = "" +
				"INSERT INTO userTable (UserName, Password, Country, DarkMode, FontSize) " +
				"VALUES (?, ?, ?, ?, ?)";
			
			//PreparedStatement 얻기 및 값 지정
			PreparedStatement pstmt = conn.prepareStatement(
					sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, JGDBUser.UserName);
			pstmt.setString(2, JGDBUser.Password);
			pstmt.setString(3, JGDBUser.Country);
			pstmt.setString(4, JGDBUser.DarkMode);
			pstmt.setString(5, JGDBUser.FontSize);
			
			//SQL문 실행
			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행 수: " + rows);
			
			//bno 값 얻기
			if(rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("저장된 id: " + id);
				}
				rs.close();
			}
			
			//PreparedStatement 닫기
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try { 
					//연결 끊기
					conn.close(); 
				} catch (SQLException e) {}
			}
		}
	}
}





