package FxMVC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecialWishDao {

	private static OracleDsSingleton ds = OracleDsSingleton.getInstance();

	public static void deleteSWCategory(int catID) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String selectStatement = "delete specialwishescategory where special_wish_id=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(selectStatement);
			pstmt.setInt(1, catID);

			rset = pstmt.executeQuery();

			conn.close();

			System.out.println("special wish category deleted!");

		} catch (SQLException esql) {
			esql.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("Connection close error");
				}
			}
		}
	}
}
