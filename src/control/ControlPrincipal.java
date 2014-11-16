package control;

import java.util.ArrayList;

import modelo.Album;
import modelo.Cancion;
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
}
