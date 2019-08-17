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

import models.User;
import services.IGenericService;
import services.IUserServise;

@WebService
public class NewsSoapService  {
	
	@Autowired
	private IUserServise userServise;
	@Autowired
	private IGenericService genericService;
	
	@WebMethod
	public User connect(@WebParam(name="user")User user) {
		return userServise.connect(user);
	}
	
	@WebMethod
	public User find(@WebParam(name="username")String username) {
		return userServise.find(username);
	}
	
	@WebMethod
	public Object getObject(@WebParam Object o, @WebParam int idObject) {
		return genericService.getObject(o, idObject);
	}
	@WebMethod
	public void saveObject(@WebParam Object o) {
		genericService.saveObject(o);
	}
	
	@WebMethod
	public void updateObject(@WebParam Object o) {
		genericService.updateObject(o);
	}
	
	@WebMethod
	public void saveOrUpdateObject(@WebParam Object o) {
		genericService.saveOrUpdateObject(o);
	}
	
	@WebMethod
	public void deleteObject(@WebParam Object o) {
		genericService.deleteObject(o);
	}
	
	@WebMethod
	public List<Object> getAllObject(@WebParam Object o) {
		return genericService.getAllObject(o);
	}
	
	@WebMethod
	public List<SelectItem> listItemGeneric(@WebParam Object o, int typeObjet) {
		return genericService.listItemGeneric(o, typeObjet);
	}
	
	@WebMethod
	public void saveAllObject(@WebParam List<Object> o) {
		genericService.saveAllObject(o);
	}

}
