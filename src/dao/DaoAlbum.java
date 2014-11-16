package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.Album;
import modelo.Cancion;
import modelo.Interprete;

class DaoAlbum {

	Album getAlbum(int id) {
		Album album = null;
		String sql;
		Connection conn;
		ResultSet result = null;
		try {
			conn = DataConection.getDatacon().getCon();
			sql = "SELECT * FROM  `retogrupal`.`album` where id ='" + id + "';";
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

	Album getAlbum(String name) {
		Album album = null;
		String sql;
		Connection conn;
		ResultSet result = null;
		try {
			conn = DataConection.getDatacon().getCon();
			sql = "SELECT * FROM   `retogrupal`.`album` where convert(nombre using latin1) collate latin1_general_cs ='" + name
					+ "';";
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

	String addAlbum(Album album) {
		String sql;
		Connection conn = null;
		ResultSet result = null;
		Album tempAlbum = null;
		try {

			if (album.getListCancion().size() == 0) {
				return "ERROR: al adicionar el álbum, no existe canciones asociadas";
			}

			conn = DataConection.getDatacon().getCon();
			conn.setAutoCommit(false);
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

			sql = "SELECT count(id) as cant FROM  `retogrupal`.`album` where convert(nombre using latin1) collate latin1_general_cs ='"
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
			tempAlbum = getAlbum(album.getName());
			album.setId(tempAlbum.getId());

			if (!addCancionesAlbum(album)) {
				conn.rollback();
				conn.setAutoCommit(true);
				return "ERROR: al adicionar el álbum";
			}

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

	private boolean addCancionesAlbum(Album album) {
		DaoCancion daoCancion = new DaoCancion();
		try {
			for (Cancion cancion : album.getListCancion()) {
				if (cancion.getId() == -1) {
					if (!daoCancion.addCancion(cancion))
						return false;
				}
				if (!addCancionAlbum(album, cancion))
					return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean addCancionAlbum(Album album, Cancion cancion) {
		String sql;
		Connection conn = null;
		try {
			conn = DataConection.getDatacon().getCon();
			sql = "INSERT INTO `retogrupal`.`cancionxalbum`(`cancion_id`,`album_id`) VALUES( "
					+ "'" + cancion.getId() + "','" + album.getId() + "');";
			if (!DataConection.getDatacon().execute_Ins_Upd_Del_Sql(conn, sql)) {
				System.out
						.println("addCancionAlbum--Error al crear el interprete");
				return false;
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("addCancionAlbum--Error:"
					+ e.getLocalizedMessage());
			e.printStackTrace();
			return false;
		}
	}

	ArrayList<Album> getListAlbum(String likeName) {
		Album album = null;
		String sql;
		Connection conn;
		ResultSet result = null;
		ArrayList<Album> listAlbum = null;
		try {

			conn = DataConection.getDatacon().getCon();
			listAlbum = new ArrayList<Album>();

			sql = "SELECT * FROM  `retogrupal`.`album` where convert(nombre using latin1) collate latin1_general_cs like '%"
					+ likeName + "%' LIMIT 10;";

			result = DataConection.getDatacon().execute_Sel_Sql(conn, sql);

			if (result != null) {
				while (result.next()) {
					album = new Album();
					album.setId(result.getInt("id"));
					album.setName(result.getString("nombre"));
					listAlbum.add(album);
				}
			}

			if (result != null)
				result.close();

			return listAlbum;
		} catch (Exception e) {
			// TODO: handle exception
			try {
				System.out.println("getListAlbum--Error:"
						+ e.getLocalizedMessage());
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
