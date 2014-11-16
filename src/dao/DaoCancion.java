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
		String interpretes = "";

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
			sql = "SELECT inter.`nombre` FROM `retogrupal`.`interpretexcancion` as cinter INNER JOIN `retogrupal`.`interprete` as inter ON cinter.`interprete_id` = inter.`id` WHERE cinter.`cancion_id` = '"
					+ cancion.getId() + "';";

			result = DataConection.getDatacon().execute_Sel_Sql(conn, sql);
			interpretes = "";
			
			while (result.next()) {
				interpretes += result.getString("nombre");
			}
			if (result != null)
				result.close();

			cancion.setNombreInterpretes(interpretes);

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
		String interpretes = "";

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

			sql = "SELECT inter.`nombre` FROM `retogrupal`.`interpretexcancion` as cinter INNER JOIN `retogrupal`.`interprete` as inter ON cinter.`interprete_id` = inter.`id` WHERE cinter.`cancion_id` = '"
					+ cancion.getId() + "';";

			result = DataConection.getDatacon().execute_Sel_Sql(conn, sql);

			interpretes = "";
			while (result.next()) {
				interpretes += result.getString("nombre");
			}

			if (result != null)
				result.close();

			cancion.setNombreInterpretes(interpretes);

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
		Cancion tempCancion = null;
		try {

			if (cancion.getListInterpreteNuevo().size() == 0)
				return false;

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
			// actualizo el id objeto
			tempCancion = getCancion(cancion.getName());
			cancion.setId(tempCancion.getId());
			if (!addInterpretesCancion(cancion)) {
				return false;
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

	private boolean addInterpretesCancion(Cancion cancion) {
		DaoInterprete daoInterprete = new DaoInterprete();
		try {
			for (Interprete interprete : cancion.getListInterpreteNuevo()) {
				if (interprete.getId() == -1) {
					if (!daoInterprete.addInterprete(interprete))
						return false;
				}
				if (!addInterpreteCancion(cancion, interprete))
					return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean addInterpreteCancion(Cancion cancion, Interprete interprete) {
		String sql;
		Connection conn = null;
		try {
			conn = DataConection.getDatacon().getCon();
			sql = "INSERT INTO `retogrupal`.`interpretexcancion`(`cancion_id`,`interprete_id`) VALUES( "
					+ "'"
					+ cancion.getId()
					+ "','"
					+ interprete.getId()
					+ "');";
			if (!DataConection.getDatacon().execute_Ins_Upd_Del_Sql(conn, sql)) {
				System.out
						.println("addInterpreteCancion--Error al crear el interprete");
				return false;
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("addInterpreteCancion--Error:"
					+ e.getLocalizedMessage());
			e.printStackTrace();
			return false;

		}
	}
}
