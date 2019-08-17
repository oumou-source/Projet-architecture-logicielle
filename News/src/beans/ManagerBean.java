package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;


import org.apache.log4j.Logger;

import com.itextpdf.text.DocumentException;
import com.sun.org.apache.xml.internal.security.encryption.Reference;

import models.Article;
import models.Categorie;
import models.Groupe;
import services.IGenericService;
import services.IManagerService;
import utils.ClassUtil;


@ManagedBean(name = "managerBean")
@SessionScoped
public class ManagerBean implements Serializable {
	static Logger logger = Logger.getLogger(ManagerBean.class);

	private List<SelectItem> itemsCategories = new ArrayList<SelectItem>();
	private List<Article> articles = new ArrayList<Article>();
	private Article article = new Article();
	private List<Article> listArticle = new ArrayList<Article>();


	private boolean zoneListeArticle = false;
	private boolean zoneNouveauArticle = false;

	@ManagedProperty(value = "#{genericService}")
	private IGenericService genericService;

	@ManagedProperty(value = "#{managerService}")
	private IManagerService managerService;

	@PostConstruct
	public void ini() {
		//initItems();
		itemsCategories = genericService.listItemGeneric(Categorie.class, 4);

	}

	public String createArticle() {
		article = new Article();
		allFalse();
		setZoneNouveauArticle(true);
		return ClassUtil.MANAGER;

	}

	public String saveArticle() {
		genericService.saveOrUpdateObject(article);
		ClassUtil.showMessage(FacesMessage.SEVERITY_INFO, ClassUtil.msg.getString("data_saved"), null, null);
		allFalse();
	//	initItems();
		return listeArticles();
	}

	public String editArticle(int idArticle) {
		article = (Article) genericService.getObject(Article.class, idArticle);
		allFalse();
		setZoneNouveauArticle(true);
		return ClassUtil.MANAGER;
	}
	
	
	public String listeArticles() {

		listArticle = new ArrayList<Article>();
		listArticle = managerService.afficherArticle();
		article = new Article();

		allFalse();
		setZoneListeArticle(true);
		return ClassUtil.MANAGER;

	}
	private void allFalse() {
		setZoneNouveauArticle(false);
		setZoneListeArticle(false);
		
	}
	
	/*public String listeArticles() {
		allFalse();
		setZoneListeArticle(true);
		return ClassUtil.MANAGER;
	}*/

	public List<Article> getArticles() {
		return articles;
	}


	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}


	public Article getArticle() {
		return article;
	}


	public void setArticle(Article article) {
		this.article = article;
	}


	public boolean isZoneListeArticle() {
		return zoneListeArticle;
	}


	public void setZoneListeArticle(boolean zoneListeArticle) {
		this.zoneListeArticle = zoneListeArticle;
	}


	public IGenericService getGenericService() {
		return genericService;
	}


	public void setGenericService(IGenericService genericService) {
		this.genericService = genericService;
	}


	public IManagerService getManagerService() {
		return managerService;
	}


	public void setManagerService(IManagerService managerService) {
		this.managerService = managerService;
	}

	public boolean isZoneNouveauArticle() {
		return zoneNouveauArticle;
	}

	public void setZoneNouveauArticle(boolean zoneNouveauArticle) {
		this.zoneNouveauArticle = zoneNouveauArticle;
	}
	public List<Article> getListArticle() {
		return listArticle;
	}
	public void setListArticle(List<Article> listArticle) {
		this.listArticle = listArticle;
	}

	public List<SelectItem> getItemsCategories() {
		return itemsCategories;
	}

	public void setItemsCategories(List<SelectItem> itemsCategories) {
		this.itemsCategories = itemsCategories;
	}

	

	
	

	
}
