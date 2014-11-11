package dao;

import modelo.Album;

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
		return DataConection.getDatacon().isvalid();
	}

	@Override
	public Album getAlbum(int id) {
		// TODO Auto-generated method stub
		return daoAlbum.getAlbum(id);
	}

	@Override
	public Album getAlbum(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
