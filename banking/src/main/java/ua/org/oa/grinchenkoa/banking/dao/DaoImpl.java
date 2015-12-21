package ua.org.oa.grinchenkoa.banking.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import ua.org.oa.grinchenkoa.banking.entities.Entity;
import ua.org.oa.grinchenkoa.banking.managers.HibernateManager;

/**
 * Class is used for abstraction and encapsulation CRUD operations for Entity.
 * 
 * @see Dao
 * 
 * @author Andrei Grinchenko
 *
 */

public class DaoImpl implements Dao{

	

		/**
		 * {@inheritDoc}
		 */
		public void create(Entity obj) throws SQLException, IOException {
			Session session = null;
			try {
				session = HibernateManager.getSessionFactory().openSession();
				session.beginTransaction();
				session.save(obj);
				session.getTransaction().commit();
			}
			finally {
				if ((session != null) && (session.isOpen()))
					session.close();
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@SuppressWarnings("unchecked")
		public <T extends Entity> Entity read(int id, Class<T> cl) throws SQLException, IOException {
			Session session = null;
			T obj = null;
			try {
				session = HibernateManager.getSessionFactory().openSession();
				obj = (T)session.get(cl, id);
			} 
			finally {
				if ((session != null) && (session.isOpen()))
						session.close();
			}
			return obj;
		}
		
		/**
		 * {@inheritDoc}
		 */
		@SuppressWarnings("unchecked")
		public <T extends Entity> List<T> readAll(Class<T> cl) throws SQLException, IOException {
			List<T> list;
			Session session = null;
			try {
				session = HibernateManager.getSessionFactory().openSession();
				list = session.createCriteria(cl).list();
			} 
			finally {
				if ((session != null) && (session.isOpen()))
						session.close();
			}
			return list;
		}
		
		/**
		 * {@inheritDoc}
		 */
		public void update(Entity obj) throws SQLException, IOException {
			Session session = null;
			try {
				session = HibernateManager.getSessionFactory().openSession();
				session.beginTransaction();
				session.update(obj);
				session.getTransaction().commit();
			} 
			finally {
				if ((session != null) && (session.isOpen()))
					session.close();
			}
		}
		
		/**
		 * {@inheritDoc}
		 */
		public void delete(Entity obj) throws SQLException, IOException {
			Session session = null;
			try {
				session = HibernateManager.getSessionFactory().openSession();
				session.beginTransaction();
				session.delete(obj);
				session.getTransaction().commit();
			} 
			finally {
				if ((session != null) && (session.isOpen()))
					session.close();
			}
		}
}
