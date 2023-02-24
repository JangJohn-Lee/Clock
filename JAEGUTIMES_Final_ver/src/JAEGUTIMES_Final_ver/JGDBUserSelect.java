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
				"SELECT Id, UserName, Password, Country, DarkMode, FontSize " +
				"FROM userTable " +
				"ORDER BY id DESC limit 1 ";
			
			//PreparedStatement ��� �� �� ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, "winter");
			
			//SQL�� ���� ��, ResultSet�� ���� ������ �б�
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {						//1���� ������ ���� �������� ���
				JGDBUser user = new JGDBUser();				
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setCountry(rs.getString(4));       //�÷� ������ �̿�
				user.setDarkMode(rs.getString(5));  //�÷� ������ �̿�		
				user.setFontSize(rs.getString(6));  //�÷� ������ �̿�	
				System.out.println(user);
			} else {                           //������ ���� �������� �ʾ��� ���
				System.out.println("����� ���̵� �������� ����");
			}
			rs.close();						
			
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


