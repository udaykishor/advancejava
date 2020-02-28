package dao.users;

public interface QueryConstants {
	String LOGIN_SQL = "select userid, password from user_list where Userid=? and password=?";
	String REGISTER_SQL = "insert into user_list(userid, password)values(?,?)";
}
