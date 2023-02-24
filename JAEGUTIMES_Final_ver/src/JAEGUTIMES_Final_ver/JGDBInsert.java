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
			//JDBC Driver ���
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//�����ϱ�
			conn = DriverManager.getConnection(
					"jdbc:mysql://222.119.100.81:3382/jaegutimes", 
					"jaegutimes", 
					"jaegutimes*"
				);					
			
			//�Ű�����ȭ�� SQL�� �ۼ� 
			String sql = "" +
				"INSERT INTO userTable (UserName, Password, Country, DarkMode, FontSize) " +
				"VALUES (?, ?, ?, ?, ?)";
			
			//PreparedStatement ��� �� �� ����
			PreparedStatement pstmt = conn.prepareStatement(
					sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, JGDBUser.UserName);
			pstmt.setString(2, JGDBUser.Password);
			pstmt.setString(3, JGDBUser.Country);
			pstmt.setString(4, JGDBUser.DarkMode);
			pstmt.setString(5, JGDBUser.FontSize);
			
			//SQL�� ����
			int rows = pstmt.executeUpdate();
			System.out.println("����� �� ��: " + rows);
			
			//bno �� ���
			if(rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("����� id: " + id);
				}
				rs.close();
			}
			
			//PreparedStatement �ݱ�
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try { 
					//���� ����
					conn.close(); 
				} catch (SQLException e) {}
			}
		}
	}
}





