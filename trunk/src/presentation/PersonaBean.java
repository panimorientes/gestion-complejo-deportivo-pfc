package presentation;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import data.dao.impl.PersonaDAOImpl;
import data.dao.interfaces.PersonaDAO;
import domain.impl.PersonaImpl;
import domain.interfaces.Persona;

@ManagedBean(name="personaBean")
@SessionScoped
public class PersonaBean {
	private int intId;
	private String strNombres;
	private String strApellidos;
	private int intEdad;
	private int intIdEmpresa;
	private String strEstado;
	private Date fecha;
	
	@ManagedProperty(value="#{personaDAOId}")
	PersonaDAO personaDAO;
	
	public PersonaDAO getPersonaDAO() {
		return personaDAO;
	}
	public void setPersonaDAO(PersonaDAO personaDAO) {
		this.personaDAO = personaDAO;
	}
	
	public int getIntId() {
		return intId;
	}
	public void setIntId(int intId) {
		this.intId = intId;
	}
	public String getStrNombres() {
		return strNombres;
	}
	public void setStrNombres(String strNombres) {
		this.strNombres = strNombres;
	}
	public String getStrApellidos() {
		return strApellidos;
	}
	public void setStrApellidos(String strApellidos) {
		this.strApellidos = strApellidos;
	}
	public int getIntEdad() {
		return intEdad;
	}
	public void setIntEdad(int intEdad) {
		this.intEdad = intEdad;
	}
	public int getIntIdEmpresa() {
		return intIdEmpresa;
	}
	public void setIntIdEmpresa(int intIdEmpresa) {
		this.intIdEmpresa = intIdEmpresa;
	}
	public String getStrEstado() {
		return strEstado;
	}
	public void setStrEstado(String strEstado) {
		this.strEstado = strEstado;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	/**
	 * Guarda un objeto Persona en la Base de Datos
	 * 
	 * @param (no tiene parametros)
	 * @return (no devuelve nada)
	 * @throws (no eleva ninguna excepcion de momento)
	 */
	public void save(){	
		
		//CREO UN OBJETO PERSONA Y LO INSERTO EN LA BD
    	Persona p1=new PersonaImpl();
    	p1.setStrNombres(this.strNombres);
    	p1.setStrApellidos(this.strApellidos);
    	p1.setIntEdad(this.intEdad);;
    	p1.setIntIdEmpresa(1);
    	p1.setStrEstado("1");
    	
    	personaDAO.insertar(p1);

	}
	
	

	/**
	 * Actualiza un objeto Persona en la Base de Datos
	 * 
	 * @param (no tiene parametros)
	 * @return (no devuelve nada)
	 * @throws (no eleva ninguna excepcion de momento)
	 */
	public void update(){
    	Persona p1=new PersonaImpl();
    	p1.setIntId(this.intId);
    	p1.setStrNombres(this.strNombres);
    	p1.setStrApellidos(this.strApellidos);
    	p1.setIntEdad(this.intEdad);;
    	p1.setIntIdEmpresa(1);
    	p1.setStrEstado("1");
		
    	personaDAO.actualizar(p1);
	}


	public void obtain(){
    	Persona p = personaDAO.obtener(this.intId);
    	this.strNombres = p.getStrNombres();
    	this.strApellidos = p.getStrApellidos();
    	this.intEdad = p.getIntEdad();
	}
	
}
