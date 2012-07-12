package data.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import data.HibernateUtil;
import data.dao.interfaces.PersonaDAO;
import data.hibernate.PersonaHB;
import domain.impl.PersonaImpl;
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
			//getHibernateTemplate().save(p);
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
	
	
	
	public Persona obtener(int id)/* throws DataBaseException*/{
		Persona res = null;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria crit = session.createCriteria(PersonaImpl.class);
		//crit.add(Restrictions.eq("ID", id));  ES LO MISMO, PERO SIN HB
		crit.add(Restrictions.eq(PersonaHB.ID, id));
		res = (Persona) crit.uniqueResult();

		return res;
		
	}
	
	
}
