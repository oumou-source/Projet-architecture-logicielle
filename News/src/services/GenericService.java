
package services;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.SelectItem;

import dao.IGenericDao;

public class GenericService implements IGenericService, Serializable  {

	private static final long serialVersionUID = 1L;
	
	private IGenericDao genericDao;

	@Override
	public void deleteObject(Object o) {
		genericDao.deleteObject(o);
	}

	@Override
	public List<Object> getAllObject(Object o) {
		return  genericDao.getAllObject(o);
	}

	@Override
	public Object getObject(Object o, int idObject) {
		return  genericDao.getObject(o, idObject);
	}

	@Override
	public List<SelectItem> listItemGeneric(String sql) {
		return genericDao.listItemGeneric(sql);
	}

	@Override
	public List<SelectItem> listItemGeneric(Object o, int typeObjet) {
		return genericDao.listItemGeneric(o, typeObjet);
	}

	@Override
	public void saveOrUpdateObject(Object o) {	
		genericDao.saveOrUpdateObject(o);
	}

	@Override
	public void saveObject(Object o) {
		genericDao.saveObject(o);
	}

	@Override
	public void updateObject(Object o) {
			
		genericDao.updateObject(o);
	}

	public IGenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(IGenericDao genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public List<String> listeLov(int type) {
		return genericDao.listeLov(type);
	}

	@Override
	public void saveAllObject(List<Object> o) {
		genericDao.saveAllObject(o);
	}

}
