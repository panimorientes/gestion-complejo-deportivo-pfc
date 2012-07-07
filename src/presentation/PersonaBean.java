package presentation;

import javax.faces.bean.ManagedBean;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import data.HibernateUtil;
import domain.Persona;

@ManagedBean(name="personaBean")
public class PersonaBean {
	private int intId;
	private String strNombres;
	private String strApellidos;
	private int intEdad;
	private int intIdEmpresa;
	private String strEstado;
	
	
	
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
	
	
	/**
	 * Guarda un objeto PersonaBean en la Base de Datos
	 * 
	 * @param (no tiene parametros)
	 * @return (no devuelve nada)
	 * @throws (no eleva ninguna excepcion de momento)
	 */
	public void save(){	
		BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.WARN);
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		//CREO UN OBJETO PERSONA Y LO INSERTO EN LA BD
    	Persona p1=new Persona();
    	p1.setStrNombres(this.strNombres);
    	p1.setStrApellidos(this.strApellidos);
    	p1.setIntEdad(this.intEdad);;
    	p1.setIntIdEmpresa(1);
    	p1.setStrEstado("1");
        
    	session.beginTransaction();
        session.save(p1);
        session.getTransaction().commit();
		
        HibernateUtil.getSessionFactory().close();
	}

}
