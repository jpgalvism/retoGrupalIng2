package modelo;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * @author F5
 * 
 */
public class Album {

	/***
	 * codigo del album
	 */
	private int id = -1;

	/***
	 * nombre del album
	 */
	private String name;

	/***
	 * lista de canciones del album
	 */
	private ArrayList<Cancion> listCancion = new ArrayList<Cancion>();

	/***
	 * 
	 * @return codigo del album
	 */
	public int getId() {
		return id;
	}

	/**
	 * asigna el valor de la variable
	 * 
	 * @param id
	 *            codigo del album
	 */
	public void setId(int id) {
		this.id = id;
	}

	/***
	 * 
	 * @return nombre del album
	 */
	public String getName() {
		return name;
	}

	/***
	 * asigna el nombre del album
	 * 
	 * @param name
	 *            nombre del album
	 */
	public void setName(String name) {
		this.name = name;
	}

	/***
	 * 
	 * @return lista de canciones asociadas al album
	 */
	public ArrayList<Cancion> getListCancion() {
		return listCancion;
	}

	/***
	 * Asigna una nueva lista al album
	 * @param cancion objeto cancion
	 */
	public void addCancion(Cancion cancion) {
		listCancion.add(cancion);
	}

}
