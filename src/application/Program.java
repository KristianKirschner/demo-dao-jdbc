package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {
		
//		Connection conn = null;


//		LISTAR REGISTROS DO DB
//		try {
//			conn = DB.getConnection();
//			
//			st = conn.createStatement();
//			
//			rs= st.executeQuery("SELECT * FROM seller");
//			
//			while (rs.next()) {
//				System.out.println(rs.getString("Name") + " " + rs.getString("Email"));
//			}
//			
//		} catch (SQLException err) {
//			System.out.println(err.getMessage());
//		} finally {
//			DB.closeResultSet(rs);
//			DB.closeStatement(st);
//			DB.closeConnection();
//		}
		
		
		
		
		
//		INSERIR VALOR NA TABELA
//		PreparedStatement st = null;
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
//		try {
//			conn = DB.getConnection();
//			
//			st = conn.prepareStatement(
//					"INSERT INTO seller"
//					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
//					+ "VALUES "
//					+ "(?, ?, ?, ?, ?)",
//					Statement.RETURN_GENERATED_KEYS);
//			st.setString(1, "Carl Purple");
//			st.setString(2, "carl@gmail.com");
//			st.setDate(3, new java.sql.Date(sdf.parse("02/01/2006").getTime()));
//			st.setDouble(4, 4000.0);
//			st.setInt(5, 4);
//			
//			st = conn.prepareStatement("INSERT INTO department (Name) value ('D1'), ('D2')", Statement.RETURN_GENERATED_KEYS);
//			
//			int rowsAffected = st.executeUpdate();
//			
//			if (rowsAffected > 0) {
//				ResultSet rs = st.getGeneratedKeys();
//				while (rs.next()) {
//					int id = rs.getInt(1);
//					System.out.println("Done! Id = " + id);
//				}
//			} else {
//				System.out.println("No rows affected!");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DB.closeStatement(st);
//			DB.closeConnection();
//		}
		
		// atualizar dados
//		Connection conn = null;
//		PreparedStatement st = null;
//		
//		try {
//			conn = DB.getConnection();
//			
//			st = conn.prepareStatement(
//					"UPDATE seller "
//					+ "SET BaseSalary = BaseSalary + ? "
//					+ "WHERE "
//					+ "(DepartmentId = ?)");
//			
//			st.setDouble(1, 200);
//			st.setInt(2, 2);
//			
//			int rowsAffected = st.executeUpdate();
//			
//			System.out.println("Done! Rows affected: " + rowsAffected);
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DB.closeStatement(st);
//			DB.closeConnection();
//		}
//		
		
		
		
		
		// Deletar registro
//		Connection conn = null;
//		PreparedStatement st = null;
//		
//		try {
//			conn = DB.getConnection();
//			
//			st = conn.prepareStatement(
//					"DELETE FROM department "
//					+ "WHERE "
//					+ "Id = ?");
//			
//			st.setInt(1, 2);
//
//				int rowsAffected = st.executeUpdate();
//				System.out.println("Done! Rows affected: " + rowsAffected);
//
//			
//			
//		} catch (SQLException e) {
//			throw new DbIntegrityException(e.getMessage());
//		} finally {
//			DB.closeStatement(st);
//			DB.closeConnection();
//		}
		
		// transação
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
		
			
			int rows1 = st.executeUpdate("UPDATE seller set BaseSalary = 2090 WHERE DepartmentId = 1");

			int x = 1;
			if (x<2) {
				throw new SQLException("Fake error");
			}
			
			int rows2 = st.executeUpdate("UPDATE seller set BaseSalary = 3090 DepartmentId = 2");
			
			conn.commit();
			
			System.out.println("rows1 " + rows1);
			System.out.println("rows2 " + rows2);
			
		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Transaction rolled back! Caused by " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error trying to rollbac! Caused by " + e1.getMessage());
			}
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
		
		
	}

}
