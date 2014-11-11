package modelo;

import java.util.LinkedList;

public class Album {

	private int id = -1;
	private String name;
	private LinkedList<Cancion> listCancion;
	
	
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
	public LinkedList<Cancion> getListCancion() {
		return listCancion;
	}
	public void setListCancion(LinkedList<Cancion> listCancion) {
		this.listCancion = listCancion;
	}
	
	
	
	
}
