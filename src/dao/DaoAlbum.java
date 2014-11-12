package dao;

import java.sql.Connection;
import java.sql.ResultSet;

import modelo.Album;

public class DaoAlbum {

	public boolean addAlbum(Album alb) {
		String sql;
		try {

		} catch (Exception e) {
			// TODO: handle exception
		} finally { // cerrar conexion
			try {

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return false;
	}

	public Album getAlbum(int id) {
		Album album = null;
		String sql;
		Connection conn;
		ResultSet result = null;

		try {

			conn = DataConection.getDatacon().getCon();

			sql = "SELECT * FROM retogrupal.album where id ='" + id + "';";

			result = DataConection.getDatacon().execute_Sel_Sql(conn, sql);
			
			
			if (result != null) {
				if (result.next()) {

					album = new Album();
					album.setId(result.getInt("id"));
					album.setName(result.getString("nombre"));
				}
			}

			if (result != null)
				result.close();
			return album;
		} catch (Exception e) {
			// TODO: handle exception
			try {
				System.out
						.println("getAlbum--Error:" + e.getLocalizedMessage());
				e.printStackTrace();
				if (result != null)
					result.close();
			} catch (Exception e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
		}
		return null;
	}

}
