package data.dao.interfaces;

import java.io.Serializable;

public interface DAO {

	public abstract void saveObject(Object o);

	public abstract Serializable saveObjectReturningGeneratedIdentifier(Object o);

	public abstract void updateObject(Object o);

	public abstract void deleteObject(Object o) throws Exception;

}