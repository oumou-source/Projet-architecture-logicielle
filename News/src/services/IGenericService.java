package services;

import java.util.List;

import javax.faces.model.SelectItem;


import org.springframework.transaction.annotation.Transactional;

public interface IGenericService {
	@Transactional
	public Object getObject(Object o, int idObject);

	@Transactional()
	public void saveObject(Object o);

	@Transactional
	public void updateObject(Object o);

	@Transactional
	public void saveOrUpdateObject(Object o);

	@Transactional
	public void deleteObject(Object o);

	@Transactional
	public List<Object> getAllObject(Object o);

	@Transactional
	public List<SelectItem> listItemGeneric(Object o, int typeObjet);

	@Transactional
	public List<SelectItem> listItemGeneric(String sql);

	@Transactional
	public List<String> listeLov(int type);

	@Transactional
	public void saveAllObject(List<Object> o);

}
