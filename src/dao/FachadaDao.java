package dao;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import modelo.Album;
import modelo.Cancion;
import modelo.Interprete;
import modelo.VotoAlbum;
import modelo.VotoCancion;

/***
 * 
 * Implementacion de Ifachadadao, se encarga de gestionar el acceso a base de datos direccionando la peticiones a los daos particulares para cada
 * entidad 
 * @author F5
 *
 */
public class FachadaDao implements IFachadaDao {

	private DaoAlbum daoAlbum = null;
	private DaoCancion daoCancion = null;
	private DaoInterprete daoInterprete = null;
	private DaoVoto daoVoto = null;
	
	private static FachadaDao fachada = null;

	private FachadaDao() {
		daoAlbum = new DaoAlbum();
		daoCancion = new DaoCancion();
		daoInterprete = new DaoInterprete();
		daoVoto = new DaoVoto();
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

	@Override
	public ArrayList<Album> getListAlbum(String likeName) {
		// TODO Auto-generated method stub
		return daoAlbum.getListAlbum(likeName);
	}

	@Override
	public ArrayList<String> getReportCancionXFecha(GregorianCalendar fechaIni,
			GregorianCalendar fechafin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getReportAlbumXFecha(GregorianCalendar fechaIni,
			GregorianCalendar fechafin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getReportInterpreteAlbum(Interprete interprete) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getReportInterpreteCancion(Interprete interprete) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getReportCancinesAlbum(Album album) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registrarVotoCancion(ArrayList<VotoCancion> listaVotosCancion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registrarVotoAlbum(ArrayList<VotoAlbum> listaVotosAlbum) {
		// TODO Auto-generated method stub
		return null;
	}

}
