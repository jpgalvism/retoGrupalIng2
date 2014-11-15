package dao;

import java.util.ArrayList;

import modelo.Album;
import modelo.Cancion;
import modelo.Interprete;

public class FachadaDao implements IFachadaDao {

	private DaoAlbum daoAlbum = null;
	private DaoCancion daoCancion = null;
	private DaoInterprete daoInterprete = null;
	
	private static FachadaDao fachada = null;

	private FachadaDao() {
		daoAlbum = new DaoAlbum();
		daoCancion = new DaoCancion();
		daoInterprete = new DaoInterprete();
	}

	public static IFachadaDao getFachada() {
		if (fachada == null)
			fachada = new FachadaDao();

		return fachada;
	}

	@Override
	public String isConected() {
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
		return daoAlbum.getAlbum(name);
	}

	@Override
	public String addAlbum(Album album) {
		// TODO Auto-generated method stub
		return daoAlbum.addAlbum(album);
	}

	@Override
	public Cancion getCancion(int id) {
		// TODO Auto-generated method stub
		return daoCancion.getCancion(id);
	}

	@Override
	public Cancion getCancion(String name) {
		// TODO Auto-generated method stub
		return daoCancion.getCancion(name);
	}

	@Override
	public ArrayList<Cancion> getListCancion(String likeName) {
		// TODO Auto-generated method stub
		return daoCancion.getListCancion(likeName);
	}

	@Override
	public ArrayList<Interprete> getListInterprete(String likeName) {
		// TODO Auto-generated method stub
		return daoInterprete.getListInterprete(likeName);
	}

	@Override
	public Interprete getInterprete(int id) {
		// TODO Auto-generated method stub
		return daoInterprete.getInterprete(id);
	}

	@Override
	public Interprete getInterprete(String name) {
		// TODO Auto-generated method stub
		return daoInterprete.getInterprete(name);
	}

}
