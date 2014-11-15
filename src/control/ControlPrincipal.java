package control;

import view.FachadaP;
import dao.FachadaDao;
import dao.IFachadaDao;

public class ControlPrincipal {
	IFachadaDao dao = FachadaDao.getFachada();

	public String isConnected() {
		return dao.isConected();
		
	}
	
	

}
