package modelo;

import java.util.ArrayList;

public class Cancion {

	private int id = -1;
	private String name;
	private ArrayList<Interprete> listInterpreteNuevo = new ArrayList<Interprete>();

	private String nombreInterpretes = "";
	
	
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

	public ArrayList<Interprete> getListInterpreteNuevo() {		
		return listInterpreteNuevo;
	}

	public void addInterpreteNuevo(Interprete interprete)
	{
		listInterpreteNuevo.add(interprete);
	}

	public String getNombreInterpretes() {
		return nombreInterpretes;
	}

	public void setNombreInterpretes(String nombreInterpretes) {
		this.nombreInterpretes = nombreInterpretes;
	}
	
	
	

}
