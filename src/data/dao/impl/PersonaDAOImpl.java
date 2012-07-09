package data.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;

import data.dao.interfaces.PersonaDAO;
import domain.Persona;

public class PersonaDAOImpl extends DAOImpl implements PersonaDAO{
	
	private static final Log LOG = LogFactory.getLog(PersonaDAOImpl.class);

	/**
	 * Guarda una Persona en la Base de Datos
	 * 
	 * @param Persona
	 * @return void
	 * @throws DataBaseException
	 */
	public void insertar(Persona p){
		try{
			saveObject(p);
		}catch(Exception e){
			LOG.error("PersonaDAOImpl - insertar ERROR:", e);
			throw new HibernateException(e.getMessage(), e);
		}
	}
	
}
