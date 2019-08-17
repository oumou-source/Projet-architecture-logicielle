package dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import beans.UserBean;
import models.Article;

import com.ibm.icu.text.DateFormat;

public class ManagerDao implements IManagerDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Article> afficherArticle() {
		String sql = "SELECT a FROM Article a WHERE a.supprime =0";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);

		return query.list();
	}


}
