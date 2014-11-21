package ut;

import static org.junit.Assert.*;
import modelo.Album;
import modelo.Cancion;
import modelo.Interprete;
import modelo.VotoCancion;

import org.junit.Test;

public class UTModelo {

	@Test
	public void testInterprete() {
		try {
			Interprete inter = new Interprete();
			inter.setId(2);
			inter.setName("i1");

			assertTrue(2 == inter.getId() && inter.getName().equals("i1"));
		} catch (Exception e) {
			// TODO: handle exception
			fail("ERROR: " + e.getMessage());
		}
	}
	
	@Test
	public void testCancion() {
		try {
			Cancion can = new Cancion();
			can.setId(2);
			can.setName("C1");

			assertTrue(2 == can.getId() && can.getName().equals("C1"));
		} catch (Exception e) {
			// TODO: handle exception
			fail("ERROR: " + e.getMessage());
		}
	}

	@Test
	public void testAlbum() {
		try {
			Album alb = new Album();
			alb.setId(2);
			alb.setName("A1");

			assertTrue(2 == alb.getId() && alb.getName().equals("A1"));
		} catch (Exception e) {
			// TODO: handle exception
			fail("ERROR: " + e.getMessage());
		}
	}

	@Test
	public void testVotoCancion() {
		try {
			VotoCancion voto = new VotoCancion();
			voto.setCantidad(3);

			assertTrue(3 == voto.getCantidad());
		} catch (Exception e) {
			// TODO: handle exception
			fail("ERROR: " + e.getMessage());
		}
	}
	
	
	@Test
	public void testVotoAlbum() {
		try {
			VotoCancion voto = new VotoCancion();
			voto.setCantidad(3);

			assertTrue(3 == voto.getCantidad());
		} catch (Exception e) {
			// TODO: handle exception
			fail("ERROR: " + e.getMessage());
		}
	}
	
	
	

}
