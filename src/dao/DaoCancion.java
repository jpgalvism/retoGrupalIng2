package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.Cancion;
import modelo.Interprete;

class DaoCancion {

	Cancion getCancion(int id) {
		Cancion cancion = null;
		String sql;
		Connection conn;
		ResultSet result = null;

		try {

			conn = DataConection.getDatacon().getCon();

			sql = "SELECT * FROM  `retogrupal`.`cancion` where id ='" + id
					+ "';";

			result = DataConection.getDatacon().execute_Sel_Sql(conn, sql);

			if (result != null) {
				if (result.next()) {

					cancion = new Cancion();
					cancion.setId(result.getInt("id"));
					cancion.setName(result.getString("nombre"));
				}
			}

			if (result != null)
				result.close();
			return cancion;
		} catch (Exception e) {
			// TODO: handle exception
			try {
				System.out.println("getCancion--Error:"
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

	Cancion getCancion(String name) {
		Cancion cancion = null;
		String sql;
		Connection conn;
		ResultSet result = null;

		try {

			conn = DataConection.getDatacon().getCon();

			sql = "SELECT * FROM  `retogrupal`.`cancion` where nombre ='"
					+ name + "';";

			result = DataConection.getDatacon().execute_Sel_Sql(conn, sql);

			if (result != null) {
				if (result.next()) {

					cancion = new Cancion();
					cancion.setId(result.getInt("id"));
					cancion.setName(result.getString("nombre"));
				}
			}

			if (result != null)
				result.close();
			return cancion;
		} catch (Exception e) {
			// TODO: handle exception
			try {
				System.out.println("getCancion--Error:"
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

	ArrayList<Cancion> getListCancion(String likeName) {
		Cancion cancion = null;
		String sql;
		Connection conn;
		ResultSet result = null;
		ArrayList<Cancion> listCancion = null;
		try {

			conn = DataConection.getDatacon().getCon();
			listCancion = new ArrayList<Cancion>();

			sql = "SELECT * FROM  `retogrupal`.`cancion` where nombre like '%"
					+ likeName + "%' LIMIT 10;;";

			result = DataConection.getDatacon().execute_Sel_Sql(conn, sql);

			if (result != null) {
				while (result.next()) {
					cancion = new Cancion();
					cancion.setId(result.getInt("id"));
					cancion.setName(result.getString("nombre"));
					listCancion.add(cancion);
				}
			}

			if (result != null)
				result.close();

			return listCancion;
		} catch (Exception e) {
			// TODO: handle exception
			try {
				System.out.println("getCancion--Error:"
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

	boolean addCancion(Cancion cancion) {

		String sql;
		Connection conn = null;
		ArrayList<Interprete> listInterpreteNuevos = null;
		DaoInterprete daoInterprete = null;
		try {

			daoInterprete = new DaoInterprete();

			conn = DataConection.getDatacon().getCon();

			if (getCancion(cancion.getName()) != null) {
				return false;
			}

			sql = "INSERT INTO `retogrupal`.`cancion`(`nombre`) VALUES( " + "'"
					+ cancion.getName() + "');";

			if (!DataConection.getDatacon().execute_Ins_Upd_Del_Sql(conn, sql)) {
				System.out
						.println("addInterprete--Error al crear el interprete");
				return false;
			}

			System.out.println("interprete creado exitosamente.");

			listInterpreteNuevos = cancion.getListInterpreteNuevo();

			// actualizo el objeto
			cancion = getCancion(cancion.getName());

			for (Interprete interprete : listInterpreteNuevos) {
				if (interprete.getId() == -1) {
					if (!daoInterprete.addInterprete(interprete))
						return false;
				}

			}

			return true;
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("addInterprete--Error:"
					+ e.getLocalizedMessage());
			e.printStackTrace();
			return false;

		}
	}
}
