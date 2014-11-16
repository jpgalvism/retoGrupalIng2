package dao;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import modelo.Album;
import modelo.Cancion;
import modelo.Interprete;
import modelo.VotoAlbum;
import modelo.VotoCancion;

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
	
	
	/***
	 * 
	 * @param fechaIni fecha inicial para generar el reporte
	 * @param fechafin fecha final para generar el reporte
	 * @return list de filas del reporte
	 */
	public ArrayList<String> getReportCancionXFecha(GregorianCalendar fechaIni, GregorianCalendar fechafin);
	
	
	/***
	 * 
	 * @param fechaIni fecha inicial para generar el reporte
	 * @param fechafin fecha final para generar el reporte
	 * @return list de filas del reporte
	 */
	public ArrayList<String> getReportAlbumXFecha(GregorianCalendar fechaIni, GregorianCalendar fechafin);
	
	/***
	 * Reporte de interprete sacar por album
	 * @param interprete objeto interprete para consultar el reporte
	 * @return list filas del reporte
	 */
	public ArrayList<String> getReportInterpreteAlbum(Interprete interprete);
	
	
	/***
	 * Reporte de interprete sacar por cancion
	 * @param interprete objeto interprete para consultar el reporte
	 * @return list filas del reporte
	 */
	public ArrayList<String> getReportInterpreteCancion(Interprete interprete);
	
	/***
	 * 
	 * @param album objeto album del cual se debe generar el reporte
	 * @return list filas del reporte
	 */
	public ArrayList<String> getReportCancinesAlbum(Album album);
	
	
	/**
	 * 
	 * @param listaVotosCancion lista de los votos a registrar para las canciones
	 * @return OK como respuesta en caso de poderlos registrar, mensaje de error en caso contrario
	 */
	public String registrarVotoCancion(ArrayList<VotoCancion> listaVotosCancion);
	
	
	/**
	 * @param listaVotosAlbum lista de los votos a registrar para las canciones
	 * @return OK como respuesta en caso de poderlos registrar, mensaje de error en caso contrario
	 */
	public String registrarVotoAlbum(ArrayList<VotoAlbum> listaVotosAlbum);
	
	
	
}
