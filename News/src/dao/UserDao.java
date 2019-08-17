package dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import models.User;

public class UserDao implements IUserDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User connect(User user) {
		DetachedCriteria cUser = DetachedCriteria.forClass(User.class);
		cUser.add(Restrictions.eq("login", user.getLogin().toLowerCase()));
		cUser.add(Restrictions.eq("password", user.getPassword()));
		cUser.add(Restrictions.eq("etat", 0));
		cUser.getExecutableCriteria(sessionFactory.getCurrentSession()).setMaxResults(1);
		user = (User) cUser.getExecutableCriteria(sessionFactory.getCurrentSession()).uniqueResult();

		return user;
	}

	
	@Override
	public User find(String username) {
		DetachedCriteria cUser = DetachedCriteria.forClass(User.class);
		cUser.add(Restrictions.eq("login", username.toLowerCase()));
		cUser.getExecutableCriteria(sessionFactory.getCurrentSession()).setMaxResults(1);
		User user = (User) cUser.getExecutableCriteria(sessionFactory.getCurrentSession()).uniqueResult();
		return user;
	}

}
