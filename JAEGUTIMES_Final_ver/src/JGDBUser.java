package JAEGUTIMES_Final_ver;



import java.util.Objects;

public class JGDBUser {
	static int Id; 
	static String UserName; 
	static String Password; 
	static String Country; 
	static String DarkMode;
	static String FontSize;
	


	public JGDBUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JGDBUser (int id, String userName, String password, String country, String darkMode, String fontSize) {
		super();
		this.Id = id;
		this.UserName = userName;
		this.Password = password;
		this.Country = country;
		this.DarkMode = darkMode;
		this.FontSize = fontSize;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		this.UserName = userName;
	}

	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getDarkMode() {
		return DarkMode;
	}

	public void setDarkMode(String darkMode) {
		DarkMode = darkMode;
	}

	public String getFontSize() {
		return FontSize;
	}

	public void setFontSize(String fontSize) {
		FontSize = fontSize;
	}


	@Override
	public int hashCode() {
		return Objects.hash(Country, DarkMode, FontSize, Id, Password, UserName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JGDBUser other = (JGDBUser) obj;
		return Objects.equals(Country, other.Country) && Objects.equals(DarkMode, other.DarkMode)
				&& Objects.equals(FontSize, other.FontSize) && Id == other.Id
				&& Objects.equals(Password, other.Password) && Objects.equals(UserName, other.UserName);
	}


	@Override
	public String toString() {
		return "JGDBUser [Id=" + Id + ", userName=" + UserName + ", Password=" + Password + ", Country=" + Country
				+ ", DarkMode=" + DarkMode + ", FontSize=" + FontSize + "]";
	}
	

}
