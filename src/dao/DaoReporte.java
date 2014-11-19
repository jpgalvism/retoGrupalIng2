package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import modelo.Album;
import modelo.Cancion;
import modelo.Interprete;

class DaoReporte {

	ArrayList<String> getReportCancionXFecha(GregorianCalendar fechaIni,
			GregorianCalendar fechafin) {

		String sql;
		Connection conn;
		ResultSet result = null;
		String lineaReporte = "";
		ArrayList<String> listReport = null;
		int pos = 0;
		try {
			conn = DataConection.getDatacon().getCon();
			listReport = new ArrayList<String>();
			sql = "  SELECT can.`id`,can.`nombre`,sum(cantidad) as cantidad FROM `retogrupal`.`votoxcancion` as vtcan INNER JOIN `retogrupal`.`cancion` as can "
					+ " on vtcan.`cancion_id` = can.`id` where vtcan.fecha between '"
					+ getFecha(fechaIni)
					+ "' and '"
					+ getFecha(fechafin)
					+ "' group by can.`id`,can.`nombre` order by sum(cantidad) desc;";

			result = DataConection.getDatacon().execute_Sel_Sql(conn, sql);
			if (result != null) {
				while (result.next()) {
					lineaReporte = "";
					pos++;
					lineaReporte = pos + ":@:";
					lineaReporte += result.getString("id") + ":@:";
					lineaReporte += result.getString("nombre") + ":@:";
					lineaReporte += result.getString("cantidad");
					listReport.add(lineaReporte);
				}
			}
			if (result != null)
				result.close();
			return listReport;
		} catch (Exception e) {
			// TODO: handle exception
			try {
				System.out.println("getReportCancionXFecha--Error:"
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

	ArrayList<String> getReportAlbumXFecha(GregorianCalendar fechaIni,
			GregorianCalendar fechafin) {
		String sql;
		Connection conn;
		ResultSet result = null;
		String lineaReporte = "";
		ArrayList<String> listReport = null;
		int pos = 0;
		try {
			conn = DataConection.getDatacon().getCon();
			listReport = new ArrayList<String>();
			sql = "  SELECT alb.`id`,alb.`nombre`,sum(cantidad) as cantidad FROM `retogrupal`.`votoxalbum` as vtalb INNER JOIN `retogrupal`.`album` as alb "
					+ " on vtalb.`album_id` = alb.`id` where vtalb.fecha between '"
					+ getFecha(fechaIni)
					+ "' and '"
					+ getFecha(fechafin)
					+ "' group by alb.`id`,alb.`nombre` order by sum(cantidad) desc";

			result = DataConection.getDatacon().execute_Sel_Sql(conn, sql);
			if (result != null) {
				while (result.next()) {
					lineaReporte = "";
					pos++;
					lineaReporte = pos + ":@:";
					lineaReporte += result.getString("id") + ":@:";
					lineaReporte += result.getString("nombre") + ":@:";
					lineaReporte += result.getString("cantidad");
					listReport.add(lineaReporte);
				}
			}
			if (result != null)
				result.close();
			return listReport;
		} catch (Exception e) {
			// TODO: handle exception
			try {
				System.out.println("getReportAlbumXFecha--Error:"
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

	ArrayList<String> getReportInterpreteAlbum(Interprete interprete) {
		String sql;
		Connection conn;
		ResultSet result = null;
		String lineaReporte = "";
		ArrayList<String> listReport = null;
		int pos = 0;
		try {
			conn = DataConection.getDatacon().getCon();
			listReport = new ArrayList<String>();
			sql = "SELECT alb.`id`,alb.`nombre`,sum(cantidad) as cantidad FROM `retogrupal`.`votoxalbum` as vtalb  INNER JOIN `retogrupal`.`album` as alb "
					+ " on vtalb.`album_id` = alb.`id` WHERE alb.`id` in ( SELECT DISTINCT ca.`album_id` from `retogrupal`.`interpretexcancion` as ic "
					+ " INNER JOIN `retogrupal`.`cancionxalbum` as ca ON ic.`cancion_id` = ca.`cancion_id` WHERE ic.`interprete_id` = '"
					+ interprete.getId()
					+ "')  group by alb.`id`,alb.`nombre` order by sum(cantidad) desc";

			result = DataConection.getDatacon().execute_Sel_Sql(conn, sql);
			if (result != null) {
				while (result.next()) {
					lineaReporte = "";
					pos++;
					lineaReporte = pos + ":@:";
					lineaReporte += result.getString("id") + ":@:";
					lineaReporte += result.getString("nombre") + ":@:";
					lineaReporte += result.getString("cantidad");
					listReport.add(lineaReporte);
				}
			}
			if (result != null)
				result.close();
			return listReport;
		} catch (Exception e) {
			// TODO: handle exception
			try {
				System.out.println("getReportInterpreteAlbum--Error:"
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

	ArrayList<String> getReportInterpreteCancion(Interprete interprete) {
		// TODO Auto-generated method stub
		String sql;
		Connection conn;
		ResultSet result = null;
		String lineaReporte = "";
		ArrayList<String> listReport = null;
		int pos = 0;
		try {
			conn = DataConection.getDatacon().getCon();
			listReport = new ArrayList<String>();
			sql = "SELECT can.`id`,can.`nombre`,sum(cantidad) as cantidad FROM `retogrupal`.`votoxcancion` as vtcan INNER JOIN `retogrupal`.`cancion` as can on vtcan.`cancion_id` = can.`id` "
					+ " INNER JOIN `retogrupal`.`interpretexcancion` as ic ON ic.`cancion_id` = can.`id` WHERE ic.`interprete_id` = '"
					+ interprete.getId()
					+ "' group by can.`id`,can.`nombre` order by sum(cantidad) desc";

			result = DataConection.getDatacon().execute_Sel_Sql(conn, sql);
			if (result != null) {
				while (result.next()) {
					lineaReporte = "";
					pos++;
					lineaReporte = pos + ":@:";
					lineaReporte += result.getString("id") + ":@:";
					lineaReporte += result.getString("nombre") + ":@:";
					lineaReporte += result.getString("cantidad");
					listReport.add(lineaReporte);
				}
			}
			if (result != null)
				result.close();
			return listReport;
		} catch (Exception e) {
			// TODO: handle exception
			try {
				System.out.println("getReportInterpreteAlbum--Error:"
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

	ArrayList<String> getReportCancionesAlbum(Album album) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String sql;
		Connection conn;
		ResultSet result = null;
		String lineaReporte = "";
		ArrayList<String> listReport = null;
		int pos = 0;
		try {
			conn = DataConection.getDatacon().getCon();
			listReport = new ArrayList<String>();
			sql = "SELECT can.`id`,can.`nombre`,IFNULL(sum(cantidad),0) as cantidad FROM `retogrupal`.`cancionxalbum` as caal INNER JOIN  `retogrupal`.`cancion` as can ON can.`id` = caal.`cancion_id` "
					+ " LEFT JOIN `retogrupal`.`votoxcancion` as vtcan ON caal.`cancion_id` = vtcan.`cancion_id` WHERE caal.`album_id` = '"
					+ album.getId()
					+ "' group by can.`id`,can.`nombre` order by sum(cantidad) desc; ";

			result = DataConection.getDatacon().execute_Sel_Sql(conn, sql);
			if (result != null) {
				while (result.next()) {
					lineaReporte = "";
					pos++;
					lineaReporte = pos + ":@:";
					lineaReporte += result.getString("id") + ":@:";
					lineaReporte += result.getString("nombre") + ":@:";
					lineaReporte += result.getString("cantidad");
					listReport.add(lineaReporte);
				}
			}
			if (result != null)
				result.close();
			return listReport;
		} catch (Exception e) {
			// TODO: handle exception
			try {
				System.out.println("getReportCancionesAlbum--Error:"
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

	private String getFecha(GregorianCalendar fecha) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		if (fecha != null)
			return sdf.format(fecha.getTime());
		return null;

	}
}
