package ut;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import modelo.Album;
import modelo.Cancion;
import modelo.Interprete;
import modelo.VotoAlbum;
import modelo.VotoCancion;

import org.junit.Test;

import dao.IFachadaDao;
import dao.FachadaDao;

public class UTDao {

	IFachadaDao dao = FachadaDao.getFachada();

	@Test
	public void p1() {
		try {
			assertTrue(dao.isConected().equals("OK"));
		} catch (Exception e) {
			// TODO: handle exception
			fail("ERROR: " + e.getMessage());
		}
	}

	@Test
	public void p2() {
		try {
			dao = FachadaDao.getFachada();
			
			Interprete inter = new Interprete();
			inter.setName("inter 1");

			Cancion can = new Cancion();
			can.setName("can1");

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
	public void p3() {
		try {

			assertTrue(dao.getAlbum("pruebas alb") != null);
		} catch (Exception e) {
			// TODO: handle exception
			fail("ERROR: " + e.getMessage());
		}
	}

	@Test
	public void p4() {
		try {

			assertTrue(dao.getListAlbum("pruebas").size() == 1);
		} catch (Exception e) {
			// TODO: handle exception
			fail("ERROR: " + e.getMessage());
		}
	}

	@Test
	public void p5() {
		try {

			assertTrue(dao.getCancion("can1") != null);
		} catch (Exception e) {
			// TODO: handle exception
			fail("ERROR: " + e.getMessage());
		}
	}

	@Test
	public void p6() {
		try {

			assertTrue(dao.getListCancion("can1").size() == 1);
		} catch (Exception e) {
			// TODO: handle exception
			fail("ERROR: " + e.getMessage());
		}
	}

	@Test
	public void p7() {
		try {

			assertTrue(dao.getInterprete("inter 1") != null);
		} catch (Exception e) {
			// TODO: handle exception
			fail("ERROR: " + e.getMessage());
		}
	}

	@Test
	public void p8() {
		try {

			assertTrue(dao.getListInterprete("inter 1").size() == 1);
		} catch (Exception e) {
			// TODO: handle exception
			fail("ERROR: " + e.getMessage());
		}
	}

	@Test
	public void p9() {
		try {
			ArrayList<VotoCancion> list = new ArrayList<VotoCancion>();
			VotoCancion vtc = new VotoCancion();
			Cancion can = dao.getCancion("can1");
			GregorianCalendar fecha = new GregorianCalendar();
			fecha.setTime(GregorianCalendar.getInstance().getTime());

			vtc.setCancion(can);
			vtc.setFecha(fecha);
			vtc.setCantidad(3);
			
			list.add(vtc);

			assertTrue(dao.registrarVotoCancion(list).equals("OK"));
		} catch (Exception e) {
			// TODO: handle exception
			fail("ERROR: " + e.getMessage());
		}
	}

	
	@Test
	public void p10() {
		try {
			ArrayList<VotoAlbum> list = new ArrayList<VotoAlbum>();
			VotoAlbum vta = new VotoAlbum();
			Album alb = dao.getAlbum("pruebas alb");
			GregorianCalendar fecha = new GregorianCalendar();
			fecha.setTime(GregorianCalendar.getInstance().getTime());

			vta.setAlbum(alb);
			vta.setFecha(fecha);
			vta.setCantidad(2);
			
			list.add(vta);

			assertTrue(dao.registrarVotoAlbum(list).equals("OK"));
		} catch (Exception e) {
			// TODO: handle exception
			fail("ERROR: " + e.getMessage());
		}
	}

}
