package JAEGUTIMES_Final_ver;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JGDBConnection {
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
		
			
			System.out.println("���� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try { 
					//���� ����
					conn.close(); 
					System.out.println("���� ����");
				} catch (SQLException e) {}
			}
		}
	}
}