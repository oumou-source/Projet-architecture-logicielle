package serviceWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import models.Article;
import models.User;
import services.IGenericService;
import services.IManagerService;
import services.IUserServise;

@Component
public class NewsRestService  {
	
	@Autowired
	private IManagerService managerService;
	@Autowired
	private IGenericService genericService;
	
	public List<Article> afficherArticle() {
		return managerService.afficherArticle();
	}
	public Object getObject(Object o, int idObject) {
		return genericService.getObject(o, idObject);
	}
	public void saveObject(Object o) {
		genericService.saveObject(o);
	}
	public void updateObject(Object o) {
		genericService.updateObject(o);
	}
	public void saveOrUpdateObject(Object o) {
		genericService.saveOrUpdateObject(o);
	}
	public void deleteObject(Object o) {
		genericService.deleteObject(o);
	}
	public List<Object> getAllObject(Object o) {
		return genericService.getAllObject(o);
	}
	public List<SelectItem> listItemGeneric(Object o, int typeObjet) {
		return genericService.listItemGeneric(o, typeObjet);
	}
	public List<SelectItem> listItemGeneric(String sql) {
		return genericService.listItemGeneric(sql);
	}
	public List<String> listeLov(int type) {
		return genericService.listeLov(type);
	}
	public void saveAllObject(List<Object> o) {
		genericService.saveAllObject(o);
	}
	
	
	
}
