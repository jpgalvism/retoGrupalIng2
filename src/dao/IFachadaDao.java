package dao;

public interface IFachadaDao {
	
	/**
	 * @author f5
	 * @return instancia unica de la fachada
	 */
	public FachadaDao getFachada();
	
	
	/**
	 * @author f5
	 * @return true si puede establecer conexion con la base de datos, false en caso contrario
	 */
	public boolean isConected();
	
	
	
}
