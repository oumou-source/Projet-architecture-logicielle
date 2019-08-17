package dao;

import java.util.List;

import javax.faces.model.SelectItem;

public interface IGenericDao {
	public Object getObject(Object o, int idObject);

	public void saveObject(Object o);

	public void updateObject(Object o);

	public void saveOrUpdateObject(Object o);
	
	public void saveAllObject(List<Object> o);

	public void deleteObject(Object o);
	
	public List<Object> getAllObject(Object o);

	public List<SelectItem> listItemGeneric(String sql);

	public List<SelectItem> listItemGeneric(Object o, int typeObjet);

	public List<String> listeLov(int type);
	
		
}
