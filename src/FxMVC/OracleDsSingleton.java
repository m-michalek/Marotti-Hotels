package FxMVC;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

public class OracleDsSingleton {

	private static OracleDsSingleton dss = null;
	private static OracleDataSource ds = null;

	private OracleDsSingleton(){

		try {
			ds = new OracleDataSource();

			ds.setDataSourceName("FHWOracleDataSource");
			ds.setURL("jdbc:oracle:thin:@//wi-dbora.hwr-berlin.de:1521/dbk.hwr-berlin.de");

			ds.setUser("marottihotels");
			ds.setPassword("xamarin");

			//ds.setConnectionCachingEnabled(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static OracleDsSingleton getInstance() {
		if(dss == null) dss = new OracleDsSingleton();
		return dss;
	}

	public Connection getConnection() throws SQLException{
		Connection con = null;
		con = ds.getConnection();
		return con;
	}
}