package neg;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import data.HibernateUtil;

public class DemoHibernateMySQL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.WARN);
        new DemoHibernateMySQL();
        HibernateUtil.getSessionFactory().close();
	}

	
    public DemoHibernateMySQL() {
    	
    	//CREO UN OBJETO EMPRESA Y LO INSERTO EN LA BD
    	Empresa e1=new Empresa();
    	e1.setStrNombre("MICROSOFT");
    	e1.setStrEstado("1");
    	int intidEmpresa1 = registraEmpresa(e1);
    	
    	//CREO UN OBJETO EMPRESA Y LO INSERTO EN LA BD
    	Empresa e2=new Empresa();
    	e2.setStrNombre("GOOGLE");
    	e2.setStrEstado("1");
    	int intidEmpresa2 = registraEmpresa(e2);

    	//CREO UN OBJETO EMPRESA Y LO INSERTO EN LA BD
    	Empresa e3=new Empresa();
    	e3.setStrNombre("APPLE");
    	e3.setStrEstado("0");
    	int intidEmpresa3 = registraEmpresa(e3);

    	//CREO UN OBJETO PERSONA Y LO INSERTO EN LA BD
    	Persona p1=new Persona();
    	p1.setStrNombres("pato");
    	p1.setStrApellidos("GUTIERRES PEREZ");
    	p1.setIntEdad(28);
    	Empresa emp=new Empresa();
    	emp.setIntId(1);
    	p1.setObjEmpresa(emp);
    	p1.setStrEstado("1");
        int intIdPersona1 = registraPersona(p1);

    	//CREO UN OBJETO PERSONA Y LO INSERTO EN LA BD        
    	Persona p2=new Persona();
    	p2.setStrNombres("MIGUEL ANGEL");
    	p2.setStrApellidos("ESTRADA PINTO");
    	p2.setIntEdad(23);
    	Empresa emp2=new Empresa();
    	emp2.setIntId(2);    
    	p2.setObjEmpresa(emp2);
    	p2.setStrEstado("1");
    	int intIdPersona2 = registraPersona(p2);        
        
        listarPersonas();
    }

    private int registraEmpresa(Empresa e) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        return e.getIntId();
    }

    private int registraPersona(Persona p) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        return p.getIntId();
    }

    private List<Persona> listarPersonas() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Persona> result = session.createQuery("from Persona").list();
        // Debe hacerse el listado antes del commit, puesto que el toString()
        // de Persona consulta los Event asociados a la persona.
        for (Persona persona : result) {
            System.out.println("PERSONA : " +persona.getStrNombres()+" "+persona.getStrApellidos() + " / EMPRESA : " +persona.getObjEmpresa().getStrNombre());
        	//System.out.println(persona.getStrNombres());
        }
        // Cierre de sesion
        session.getTransaction().commit();
        return result;
    }
	
}

