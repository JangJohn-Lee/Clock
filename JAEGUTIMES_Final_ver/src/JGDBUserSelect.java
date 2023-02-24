package JAEGUTIMES_Final_ver;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JGDBUserSelect {
	public JGDBUserSelect() {
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
				"SELECT Id, UserName, Password, Country, DarkMode, FontSize " +
				"FROM userTable " +
				"ORDER BY id DESC limit 1 ";
			
			//PreparedStatement 얻기 및 값 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, "winter");
			
			//SQL문 실행 후, ResultSet을 통해 데이터 읽기
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {						//1개의 데이터 행을 가져왔을 경우
				JGDBUser user = new JGDBUser();				
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setCountry(rs.getString(4));       //컬럼 순번을 이용
				user.setDarkMode(rs.getString(5));  //컬럼 순번을 이용		
				user.setFontSize(rs.getString(6));  //컬럼 순번을 이용	
				System.out.println(user);
			} else {                           //데이터 행을 가져오지 않았을 경우
				System.out.println("사용자 아이디가 존재하지 않음");
			}
			rs.close();						
			
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


