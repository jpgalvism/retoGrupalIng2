package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import modelo.Interprete;
import modelo.VotoAlbum;
import modelo.VotoCancion;

class DaoVoto {

	String registrarVotoCancion(ArrayList<VotoCancion> listaVotosCancion) {
		// TODO Auto-generated method stub

		Connection conn = null;
		try {

			conn = DataConection.getDatacon().getCon();
			conn.setAutoCommit(false);
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

			for (VotoCancion votoCancion : listaVotosCancion) {

				if (!addVotoCancion(votoCancion)) {
					conn.rollback();
					conn.setAutoCommit(true);
					return "ERROR: al adicionar votos para la canción";
				}
			}

			conn.commit();
			conn.setAutoCommit(true);

			return "OK";
		} catch (Exception e) {
			// TODO: handle exception
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "ERROR: al adicionar votos para el canción; "
					+ e.getMessage();
		}
	}

	String registrarVotoAlbum(ArrayList<VotoAlbum> listaVotosAlbum) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {

			conn = DataConection.getDatacon().getCon();
			conn.setAutoCommit(false);
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

			for (VotoAlbum votoAlbum : listaVotosAlbum) {

				if (!addVotoAlbum(votoAlbum)) {
					conn.rollback();
					conn.setAutoCommit(true);
					return "ERROR: al adicionar votos para el álbum";
				}
			}

			conn.commit();
			conn.setAutoCommit(true);

			return "OK";
		} catch (Exception e) {
			// TODO: handle exception
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "ERROR: al adicionar votos para el álbum; " + e.getMessage();
		}
	}

	boolean addVotoAlbum(VotoAlbum votoAlbum) {

		String sql;
		Connection conn = null;
		try {
			conn = DataConection.getDatacon().getCon();
			sql = "INSERT INTO `retogrupal`.`votoxalbum`(`album_id`,`fecha`,`cantidad`) VALUES( "
					+ "'"
					+ votoAlbum.getAlbum().getId()
					+ "','"
					+ getFecha(votoAlbum.getFecha())
					+ "','"
					+ votoAlbum.getCantidad() + "');";

			if (!DataConection.getDatacon().execute_Ins_Upd_Del_Sql(conn, sql)) {
				System.out
						.println("addVotoAlbum--Error al crear el interprete");
				return false;
			}
			System.out.println("interprete creado exitosamente.");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("addVotoAlbum--Error:" + e.getLocalizedMessage());
			e.printStackTrace();
			return false;
		}
	}

	boolean addVotoCancion(VotoCancion votoCancion) {

		String sql;
		Connection conn = null;
		try {
			conn = DataConection.getDatacon().getCon();
			sql = "INSERT INTO `retogrupal`.`votoxcancion`(`cancion_id`,`fecha`,`cantidad`) VALUES( "
					+ "'"
					+ votoCancion.getCancion().getId()
					+ "','"
					+ getFecha(votoCancion.getFecha())
					+ "','"
					+ votoCancion.getCantidad() + "');";

			if (!DataConection.getDatacon().execute_Ins_Upd_Del_Sql(conn, sql)) {
				System.out
						.println("addVotoCancion--Error al crear el interprete");
				return false;
			}
			System.out.println("interprete creado exitosamente.");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("addVotoCancion--Error:"
					+ e.getLocalizedMessage());
			e.printStackTrace();
			return false;
		}
	}

	private String getFecha(GregorianCalendar fecha) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		if (fecha != null)
			return sdf.format(fecha.getTime());
		return null;

	}
}
