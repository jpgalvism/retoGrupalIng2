package dao;

import modelo.Album;

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
	

	/**
	 * @author f5
	 * @return objeto album que corresponde al id 
	 */
	public Album getAlbum(int id);
	
	/**
	 * @author f5
	 * @return objeto album que corresponde al nombre 
	 */
	public Album getAlbum(String name);
	
}
