package control;

import java.util.ArrayList;

import modelo.Cancion;
import view.FachadaP;
import dao.FachadaDao;
import dao.IFachadaDao;

public class ControlPrincipal {
	IFachadaDao dao = FachadaDao.getFachada();

	public String isConnected() {
		return dao.isConected();
		
	}
	
	public ArrayList<Cancion> listacanciones(String likeName){
		return dao.getListCancion(likeName);
	}

}
