package dao;

import java.util.ArrayList;

import modelo.Album;
import modelo.Cancion;
import modelo.Interprete;

public interface IFachadaDao {
		
	/**
	 * @author f5
	 * @return true si puede establecer conexion con la base de datos, false en caso contrario
	 */
	public String isConected();
	

	/**
	 * @author f5
	 * @return album que corresponded al id 
	 */
	public Album getAlbum(int id);
	
	/**
	 * @author f5
	 * @param name  nombre del album a buscar
	 * @return objeto album que corresponde al nombre 
	 */
	public Album getAlbum(String name);
	
	
	/**
	 * @author f5 
	 * @param likeName parte de nombre de album a coincidir
	 * @return lista de albumnes que coincida en parte con el @param likeName  
	 */
	public ArrayList<Album> getListAlbum(String likeName);
	
	
	/**
	 * @author f5
	 * @param album objeto albun a adicionar
	 * @return true en caso de guardar correctamente el album, false en caso contrario
	 */
	public String addAlbum(Album album);
	
	
	
	/**
	 * @author f5
	 * @param id identificador de la cancion
	 * @return cancion que corresponde al id 
	 */
	public Cancion getCancion(int id);
	
	
	/**
	 * @author f5
	 * @param name nombre de cancion
	 * @return cancion que corresponde al id 
	 */
	public Cancion getCancion(String name);
	
	
	
	/**
	 * @author f5 
	 * @param likeName parte de nombre de cancion a coincidir
	 * @return lista de canciones que coincida en parte con el @param likeName  
	 */
	public ArrayList<Cancion> getListCancion(String likeName);
	
	
	/**
	 * @author f5 
	 * @return lista de interpretes que coincida en parte con el @param likeName  
	 */
	public ArrayList<Interprete> getListInterprete(String likeName);
	
	
	/**
	 * @author f5
	 * @return interprete que corresponde al id 
	 */
	public Interprete getInterprete(int id);
	
	
	/**
	 * @author f5
	 * @return interprete que corresponde al id 
	 */
	public  Interprete getInterprete(String name);
	
}
