package dao;

import java.sql.Connection;
import java.sql.ResultSet;

import modelo.Album;

public class DaoAlbum {

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

	public Album getAlbum(String name) {
		Album album = null;
		String sql;
		Connection conn;
		ResultSet result = null;

		try {

			conn = DataConection.getDatacon().getCon();

			sql = "SELECT * FROM retogrupal.album where name ='" + name + "';";

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

	public String addAlbum(Album album) {
		String sql;
		Connection conn = null;
		ResultSet result = null;

		try {

			conn = DataConection.getDatacon().getCon();

			conn.setAutoCommit(false);

			sql = "SELECT count(id) as cant FROM  `retogrupal`.`album` where name ='"
					+ album.getName() + "';";

			result = DataConection.getDatacon().execute_Sel_Sql(conn, sql);

			if (result.next()) {
				if (result.getInt("cant") > 0) {
					System.out.println("addAlbum-- el album a crear ya existe");

					conn.rollback();
					conn.setAutoCommit(true);
					return "ERROR: el álbum a adicionar ya existe";
				}
			}

			if (result != null)
				result.close();

			sql = "INSERT INTO `retogrupal`.`album`(`nombre`) VALUES( " + "'"
					+ album.getName() + "');";

			if (!DataConection.getDatacon().execute_Ins_Upd_Del_Sql(conn, sql)) {
				System.out.println("addAlbum--Error al crear el album");
				conn.rollback();
				conn.setAutoCommit(true);
				return "ERROR: al adicionar el álbum";
			}

			// agregar parte de adicionar cancion

			System.out.println("album creado exitosamente.");

			conn.commit();
			conn.setAutoCommit(true);

			return "OK";
		} catch (Exception e) {
			// TODO: handle exception
			try {
				conn.rollback();
				conn.setAutoCommit(true);

				System.out
						.println("addAlbum--Error:" + e.getLocalizedMessage());
				e.printStackTrace();

				if (result != null)
					result.close();

				return "ERROR: al adicionar el álbum; " + e.getMessage();

			} catch (Exception e1) {
				// TODO: handle exception
				e1.printStackTrace();
				return "ERROR: al adicionar el álbum; " + e1.getMessage();

			}
		}

	}
}
