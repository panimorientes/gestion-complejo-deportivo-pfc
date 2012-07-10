package data.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;

import data.dao.interfaces.PersonaDAO;
import domain.interfaces.Persona;

public class PersonaDAOImpl extends DAOImpl implements PersonaDAO{
	
	private static final Log LOG = LogFactory.getLog(PersonaDAOImpl.class);

	/**
	 * Guarda una Persona en la Base de Datos
	 * 
	 * @param p Representa el objeto Persona que se desea insertar en la Base de Datos
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
	
	
	/**
	 * Actualiza una Persona en la Base de Datos
	 * 
	 * @param p Representa el objeto Persona que se desea actualizar en la Base de Datos
	 * @return void
	 * @throws DataBaseException
	 */
	public void actualizar(Persona p){
		try{
			updateObject(p);
		}catch(Exception e){
			LOG.error("PersonaDAOImpl - actualizar ERROR:", e);
			throw new HibernateException(e.getMessage(), e);
		}
	}
	
	
	
}
