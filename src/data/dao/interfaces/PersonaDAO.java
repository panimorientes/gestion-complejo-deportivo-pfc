package data.dao.interfaces;

import domain.interfaces.Persona;

public interface PersonaDAO {

	public abstract void insertar(Persona p);
	
	public abstract void actualizar(Persona p);
	
	public abstract Persona obtener(int id);

}