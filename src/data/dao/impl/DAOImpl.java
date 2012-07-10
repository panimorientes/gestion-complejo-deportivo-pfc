package data.dao.impl;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import data.HibernateUtil;
import data.dao.interfaces.DAO;

public class DAOImpl implements DAO{
	
	//BasicConfigurator.configure();
    //Logger.getRootLogger().setLevel(Level.WARN);
	private static final Log LOG = LogFactory.getLog(DAOImpl.class);

	/**
	 * Guarda un objeto en la Base de Datos
	 * 
	 * @param Object
	 * @return void
	 * @throws DataBaseException
	 */
	public void saveObject(Object o)/*throws DataBaseException*/{
		try{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.save(o);
			session.getTransaction().commit();
			HibernateUtil.getSessionFactory().close();

		}catch (HibernateException e) {
			LOG.debug("Excepcion en el acceso a datos: " + e.getMessage());
			throw new HibernateException("Excepcion en el acceso a datos ", e);
			//throw new DataBaseException("Excepcion en el acceso a datos ", e);  ESTE ES EL BUENO
		}
	}

	
	public Serializable saveObjectReturningGeneratedIdentifier(Object o) {
		try{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			return session.save(o);

		}catch (HibernateException e) {
			LOG.debug("Excepcion en el acceso a datos: " + e.getMessage());
			throw new HibernateException("Excepcion en el acceso a datos",e);
		}
	}
	

	/**
	 * Actualiza un objeto en la Base de Datos
	 * 
	 * @param o
	 * @return void
	 * @throws DataBaseException
	 */
	public void updateObject(Object o){
		try{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.update(o);
			session.getTransaction().commit();
			HibernateUtil.getSessionFactory().close();
//			session.flush();			

		}catch (HibernateException exception) {
				         LOG.debug(exception); // Log the exception
				         // Get cause if present
				         Throwable t = exception.getCause();
				         while(t != null) {
				               LOG.debug("Cause:" + t);
				               t = t.getCause();
				         }
			LOG.debug("Excepcion en el acceso a datos: " + exception.getMessage());
			throw new HibernateException("Excepcion en el acceso a datos ", exception);
		}
	}

//	public void saveOrUpdateObject(Object o) throws DataBaseException {
//		try{
//			Session session = HibernateUtil.getCurrentSession();
//			session.saveOrUpdate(o);
//			session.flush();
//
//		}catch (HibernateException e) {
//			LOG.debug("Excepcion en el acceso a datos: " + e.getMessage());
//			throw new DataBaseException("Excepcion en el acceso a datos ", e);
//		}
//
//	}
	


	public void deleteObject(Object o) throws Exception{
		try{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.delete(o);
			
		}catch (HibernateException e) {
			LOG.debug("Excepcion en el acceso a datos: " + e.getMessage());
			throw new HibernateException("Excepcion en el acceso a datos ",e);
		}
	}

	
//	public boolean saveOrUpdate(Object o) {
//		try{
//			Session session = HibernateUtil.getCurrentSession();
//			session.saveOrUpdate(o);
//			return true;
//		}catch (HibernateException e) {
//			LOG.debug("Excepcion en el acceso a datos: " + e.getMessage());
////			throw new DataBaseException();
//			return false;
//		}
//	}
	
	

	
}
