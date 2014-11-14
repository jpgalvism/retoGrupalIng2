package modelo;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

	private int id = -1;
	private String name;
	private ArrayList<Cancion> listCancion = new ArrayList<Cancion>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Cancion> getListCancion() {
		return listCancion;
	}

	public void addCancion(Cancion cancion) {
		listCancion.add(cancion);
	}

}
