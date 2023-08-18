package web0817.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JdbcUtil {

	public static Connection connect() throws NamingException, SQLException {
		// 1. Connection Pool 로딩
		Context init = new InitialContext();
        DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/oraxe");
        Connection con = ds.getConnection();
		// 2. DBMS 연결
		return con;
	}

	public static void close(PreparedStatement pstmt, Connection con) {
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) { }
			try {
				if(con != null) con.close();
			} catch (SQLException e) { }
			
	}
}