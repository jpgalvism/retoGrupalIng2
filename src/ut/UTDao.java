package ut;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import modelo.Album;
import modelo.Cancion;
import modelo.Interprete;

import org.junit.Test;

import dao.IFachadaDao;
import dao.FachadaDao;

public class UTDao {

	IFachadaDao dao = FachadaDao.getFachada();

	@Test
	public void testisConected() {
		try {
			assertTrue(dao.isConected().equals("OK"));
		} catch (Exception e) {
			// TODO: handle exception
			fail("ERROR: " + e.getMessage());
		}
	}

	@Test
	public void testAddAlbum() {
		try {
			Interprete inter = new Interprete();
			inter.setName("pruebas 1");

			Cancion can = new Cancion();
			can.setName("c");

			can.addInterpreteNuevo(inter);

			Album alb = new Album();

			alb.setName("pruebas alb");
			alb.addCancion(can);

			assertTrue(dao.addAlbum(alb).equals("OK"));

		} catch (Exception e) {
			// TODO: handle exception
			fail("ERROR: " + e.getMessage());
		}
	}
	
	
	@Test
	public void testgetAlbum() {
		try {
		
			assertTrue(dao.getAlbum("pruebas alb") != null);
		} catch (Exception e) {
			// TODO: handle exception
			fail("ERROR: " + e.getMessage());
		}
	}
	
	@Test
	public void testgetListAlbum() {
		try {
		
			assertTrue(dao.getListAlbum("pruebas").size() == 1);
		} catch (Exception e) {
			// TODO: handle exception
			fail("ERROR: " + e.getMessage());
		}
	}

}
