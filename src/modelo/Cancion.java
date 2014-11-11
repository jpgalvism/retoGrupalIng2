package modelo;

import java.util.LinkedList;

public class Cancion {
	
	private int id  = -1;
	private String name;
	private LinkedList<Interprete> listInterprete;
	
	
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
	public LinkedList<Interprete> getListInterprete() {
		return listInterprete;
	}
	public void setListInterprete(LinkedList<Interprete> listInterprete) {
		this.listInterprete = listInterprete;
	}
	
	

}
