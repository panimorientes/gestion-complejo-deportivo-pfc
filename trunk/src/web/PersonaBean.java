package web;

import javax.faces.bean.ManagedBean;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import data.HibernateUtil;

import neg.Empresa;
import neg.Persona;


@ManagedBean
public class PersonaBean {
	
	
	public static void main(String[] args) {
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.WARN);
        new PersonaBean();
        HibernateUtil.getSessionFactory().close();
	}
	
	
	private String nombre;
	private String apellidos;
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	
	public PersonaBean() {
		super();
		this.creaPersona(this.nombre, this.apellidos);
	}


	private void creaPersona(String nombre, String apellidos){
		Persona p1=new Persona();
		p1.setStrNombres(nombre);
		p1.setStrApellidos(apellidos);
		p1.setIntEdad(25);
		Empresa emp=new Empresa();
		emp.setIntId(1);
		p1.setObjEmpresa(emp);
		p1.setStrEstado("1");
	    int intIdPersona1 = registraPersona(p1);
	}

    
    private int registraPersona(Persona p) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        return p.getIntId();
    }
	
}