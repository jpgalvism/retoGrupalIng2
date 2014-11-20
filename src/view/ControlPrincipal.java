package view;

import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;

import modelo.Album;
import modelo.Cancion;
import modelo.Interprete;
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
		// TODO Auto-generated method stub
		return dao.getReportInterpreteCancion(interprete);
	}
	
}
