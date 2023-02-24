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
			//JDBC Driver ���
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//�����ϱ�
			conn = DriverManager.getConnection(
					"jdbc:mysql://222.119.100.81:3382/jaegutimes", 
					"jaegutimes", 
					"jaegutimes*"
				);			
			
			//�Ű�����ȭ�� SQL�� �ۼ�
			String sql = new StringBuilder()
					.append("UPDATE userTable SET ")
					.append("UserName=?, ")
					.append("Password=?, ")
					.append("Country=?, ")
					.append("DarkMode=?, ")
					.append("FontSize=? ")
					.append("WHERE id=?")
					.toString();			
			
			//PreparedStatement ��� �� �� ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "bye10");
			pstmt.setString(2, "1234");
			pstmt.setString(3, "usa");
			pstmt.setString(4, "dark");
			pstmt.setString(5, "large");
			pstmt.setInt(6, 5);  //boards ���̺� �ִ� �Խù� ��ȣ(id) ����			
			
			
			//SQL�� ����
			int rows = pstmt.executeUpdate();
			System.out.println("������ �� ��: " + rows);
			
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

