package ua.org.oa.grinchenkoa.banking.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import ua.org.oa.grinchenkoa.banking.entities.Entity;
/**
 * Interface describe specification of CRUD operations for Entity.
 * 
 * @author Andrei Grinchenko
 *
 */
public interface Dao {

	/**
	 * Creating new record in DB
	 * 
	 * @param obj Creating Entity's object
	 * @throws SQLException
	 * @throws IOException
	 */
	public void create(Entity obj) throws SQLException, IOException;
	
	/**
	 * 
	 * Getting Entity's object from the DB with id
	 * @param id Entity's id
	 * @param cl Class of getting object
	 * @return Entity
	 * @throws SQLException
	 * @throws IOException
	 */
	public <T extends Entity> Entity read(int id, Class<T> cl) throws SQLException, IOException;
	
	/**
	 * Getting list of all Entity's objects
	 * 
	 * @param cl Class of getting objects list's
	 * @return list of all Entity's objects
	 * @throws SQLException
	 * @throws IOException
	 */
	public <T extends Entity> List<T> readAll(Class<T> cl) throws SQLException, IOException;
	
	/**
	 * Updating Entity's object in the DB
	 * 
	 * @param obj Updating Entity's object
	 * @throws SQLException
	 * @throws IOException
	 */
	public void update(Entity obj) throws SQLException, IOException;
	
	/**
	 * 
	 * Deleting Entity's object from the DB
	 * 
	 * @param obj Deleting Entity's object
	 * @throws SQLException
	 * @throws IOException
	 */
	public void delete(Entity obj) throws SQLException, IOException;
}
