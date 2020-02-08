package shop.dao.users;

public interface QueryConstants {
	String LOGIN_SQL = "select uid, pwd from user_mst where uid=? and pwd=?";
	String REGISTER_SQL = "insert into user_mst(uid,pwd)values(?,?)";

}
