package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.Interprete;

class DaoInterprete {

	Interprete getInterprete(int id) {
		Interprete interprete = null;
		String sql;
		Connection conn;
		ResultSet result = null;

		try {

			conn = DataConection.getDatacon().getCon();

			sql = "SELECT * FROM  `retogrupal`.`interprete` where id ='" + id
					+ "';";

			result = DataConection.getDatacon().execute_Sel_Sql(conn, sql);

			if (result != null) {
				if (result.next()) {

					interprete = new Interprete();
					interprete.setId(result.getInt("id"));
					interprete.setName(result.getString("nombre"));
				}
			}

			if (result != null)
				result.close();

			return interprete;
		} catch (Exception e) {
			// TODO: handle exception
			try {
				System.out.println("getInterprete--Error:"
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

	Interprete getInterprete(String name) {

		Interprete interprete = null;
		String sql;
		Connection conn;
		ResultSet result = null;

		try {

			conn = DataConection.getDatacon().getCon();

			sql = "SELECT * FROM  `retogrupal`.`interprete` where convert(nombre using latin1) collate latin1_general_cs ='"
					+ name + "';";

			result = DataConection.getDatacon().execute_Sel_Sql(conn, sql);

			if (result != null) {
				if (result.next()) {

					interprete = new Interprete();
					interprete.setId(result.getInt("id"));
					interprete.setName(result.getString("nombre"));
				}
			}

			if (result != null)
				result.close();

			return interprete;
		} catch (Exception e) {
			// TODO: handle exception
			try {
				System.out.println("getInterprete--Error:"
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

	ArrayList<Interprete> getListInterprete(String likeName) {
		Interprete interprete = null;
		String sql;
		Connection conn;
		ResultSet result = null;
		ArrayList<Interprete> listInterprete = null;
		try {

			conn = DataConection.getDatacon().getCon();

			listInterprete = new ArrayList<Interprete>();

			sql = "SELECT * FROM  `retogrupal`.`interprete` where convert(nombre using latin1) collate latin1_general_cs  like '%"
					+ likeName + "%' LIMIT 10;";

			result = DataConection.getDatacon().execute_Sel_Sql(conn, sql);

			if (result != null) {
				while (result.next()) {
					interprete = new Interprete();
					interprete.setId(result.getInt("id"));
					interprete.setName(result.getString("nombre"));
					listInterprete.add(interprete);
				}
			}

			if (result != null)
				result.close();

			return listInterprete;
		} catch (Exception e) {
			// TODO: handle exception
			try {
				System.out.println("getListCancion--Error:"
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

	boolean addInterprete(Interprete interprete) {

		String sql;
		Connection conn = null;
		Interprete tempInter = null;
		
		try {

			conn = DataConection.getDatacon().getCon();

			if (getInterprete(interprete.getName()) != null) {
				return false;
			}

			sql = "INSERT INTO `retogrupal`.`interprete`(`nombre`) VALUES( "
					+ "'" + interprete.getName() + "');";

			if (!DataConection.getDatacon().execute_Ins_Upd_Del_Sql(conn, sql)) {
				System.out
						.println("addInterprete--Error al crear el interprete");
				return false;
			}

			System.out.println("interprete creado exitosamente.");

			// actualizo el objeto
			tempInter = getInterprete(interprete.getName());

			interprete.setId(tempInter.getId());
			
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
