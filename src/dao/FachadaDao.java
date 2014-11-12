package dao;

public class FachadaDao implements IFachadaDao{

	private DaoAlbum daoAlbum = null;
	private FachadaDao fachada = null;

	private FachadaDao() {
		daoAlbum = new DaoAlbum();
	}

	public FachadaDao getFachada() {
		if (fachada == null)
			fachada = new FachadaDao();

		return fachada;
	}

	@Override
	public boolean isConected() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
