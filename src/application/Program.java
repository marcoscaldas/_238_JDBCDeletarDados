package application;     //  PROGRAMA PARA ALTERAR SALARIO DO VENDEDOR

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args)  {
		
		Connection conn = null;
		PreparedStatement st =null;
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"DELETE FROM department "
					+ "WHERE "
					+ "id = ?");
			st.setInt(1, 2);
			
			int rowsaffected = st.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsaffected );
		}
		
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage()); // lançar excecao personalizada
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		}
}
