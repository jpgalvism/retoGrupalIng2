package view;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import modelo.Album;
import modelo.Cancion;
import modelo.Interprete;
import modelo.VotoAlbum;
import modelo.VotoCancion;
import dao.FachadaDao;
import dao.IFachadaDao;

public class ControlPrincipal {
	IFachadaDao dao = FachadaDao.getFachada();

	public String isConnected() {
		return dao.isConected();
		
	}
	
	public ArrayList<Cancion> listSongs(String likeName){
		return dao.getListCancion(likeName);
	}
	public ArrayList<Album> listAlbums(String likeName){
		return dao.getListAlbum(likeName);
	}

	public Album getAlbum(String text) {
		return dao.getAlbum(text);
		
	}
	
	public Album getAlbum(int id) {
		return dao.getAlbum(id);
		
	}

	public Cancion getCancion(int text) {
		
		return dao.getCancion(text);
	}

	public String normalizar(String text) {
		text = text.trim().toUpperCase();
		String a[] = text.split(" ");
		String def=a[0];
		for (int i = 1; i < a.length; i++) {
			def = def + " " +a[i];
		}
		return def;
	}
	
	public String addToDB(Album album){
		return dao.addAlbum(album);
		
	}
	
	public ArrayList<String> getReportInterpreteAlbum(Interprete interprete){
		return dao.getReportInterpreteAlbum(interprete);
	}
	public Interprete getInterprete(String name){
		return dao.getInterprete(name);
		
	}

	public ArrayList<String> getReportInterpreteCancion(Interprete interprete) {
		
		return dao.getReportInterpreteCancion(interprete);
	}

	public ArrayList<String> getReportAlbum(Album album) {
		
		return dao.getReportCancionesAlbum(album);
		
	}
	public String registrarVotosAlbum(ArrayList<VotoAlbum> array){
		return dao.registrarVotoAlbum(array);
	}
	public ArrayList<String> getReportAlbumByDate(GregorianCalendar fechaini,GregorianCalendar fechafin){
		return dao.getReportAlbumXFecha(fechaini, fechafin);
	}
	public ArrayList<String> getReportCancionByDate(GregorianCalendar fechaini,GregorianCalendar fechafin){
		return dao.getReportCancionXFecha(fechaini, fechafin);
	}

	public String registrarVotosCancion(ArrayList<VotoCancion> array) {
		return dao.registrarVotoCancion(array);
		
	}
}
