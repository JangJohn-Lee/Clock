package JAEGUTIMES_Final_ver;



import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JGDBUpdate {
	public static void main(String[] args) {
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
			String sql = new StringBuilder()
					.append("UPDATE userTable SET ")
					.append("UserName=?, ")
					.append("Password=?, ")
					.append("Country=?, ")
					.append("DarkMode=?, ")
					.append("FontSize=? ")
					.append("WHERE id=?")
					.toString();			
			
			//PreparedStatement 얻기 및 값 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "bye10");
			pstmt.setString(2, "1234");
			pstmt.setString(3, "usa");
			pstmt.setString(4, "dark");
			pstmt.setString(5, "large");
			pstmt.setInt(6, 5);  //boards 테이블에 있는 게시물 번호(id) 지정			
			
			
			//SQL문 실행
			int rows = pstmt.executeUpdate();
			System.out.println("수정된 행 수: " + rows);
			
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

