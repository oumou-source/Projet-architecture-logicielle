package dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;


import models.Fonctionnalite;
import models.Groupe;
import models.Categorie	;


import org.hibernate.Query;
import org.hibernate.SessionFactory;

import utils.ClassUtil;

public class GenericDao implements IGenericDao {

	private SessionFactory sessionFactory;

	@Override
	public void deleteObject(Object o) {
		sessionFactory.getCurrentSession().delete(o);
	}

	@Override
	public List<Object> getAllObject(Object o) {
		return sessionFactory.getCurrentSession().createQuery("from " + ((Class) o).getName()).list();
	}

	@Override
	public Object getObject(Object o, int idObject) {
		return sessionFactory.getCurrentSession().get((Class) o, idObject);
	}

	@Override
	public List<SelectItem> listItemGeneric(Object o, int typeObjet) {

		List<SelectItem> listeItmeGeneric = new ArrayList<SelectItem>();
		List<Object> listeAllObjet = getAllObject(o);

		// System.out.println("size ="+listeAllObjet.size());

		for (Object objet : listeAllObjet) {

			// Categorie
						if (typeObjet == 4)
							if (( (Categorie) objet).getSupprime() == 0)
								listeItmeGeneric.add(new SelectItem(((Categorie) objet).getId(), ((Categorie) objet).getNom()));

			// Fonctionnalités
			if (typeObjet == 5)
				listeItmeGeneric.add(
						new SelectItem(((Fonctionnalite) objet).getId(), ((Fonctionnalite) objet).getDescription()));

			// Groupes
			if (typeObjet == 6)
				if (((Groupe) objet).getEtat() == 0 && ((Groupe) objet).getSupprime() == 0)
					listeItmeGeneric.add(new SelectItem(((Groupe) objet).getId(), ((Groupe) objet).getNom()));

			
		}

		return listeItmeGeneric;
	}

	@Override
	public List<SelectItem> listItemGeneric(String sql) {
		List<SelectItem> listeItmeGeneric = new ArrayList<SelectItem>();
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		List<Object[]> objects = query.list();
		for (Object[] object : objects) {
			listeItmeGeneric.add(new SelectItem(object[0], object[1] + ""));
		}
		return listeItmeGeneric;
	}

	// Recuperer les donnees de Lov selon le type
	@Override
	public List<String> listeLov(int type) {
		Query query = sessionFactory.getCurrentSession().createQuery(ClassUtil.sql.getString("lov"));
		query.setParameter("idType", type);
		return query.list();
	}

	@Override
	public void saveOrUpdateObject(Object o) {
		sessionFactory.getCurrentSession().saveOrUpdate(o);
	}

	@Override
	public void saveObject(Object o) {
		sessionFactory.getCurrentSession().save(o);
	}

	@Override
	public void saveAllObject(List<Object> o) {
		for (Object object : o) {
			sessionFactory.getCurrentSession().save(object);
		}
	}

	@Override
	public void updateObject(Object o) {
		sessionFactory.getCurrentSession().update(o);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
