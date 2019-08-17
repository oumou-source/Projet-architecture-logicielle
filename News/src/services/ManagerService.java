package services;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import dao.IManagerDao;
import models.Article;

public class ManagerService implements IManagerService {

	private IManagerDao managerDao;

	public IManagerDao getManagerDao() {
		return managerDao;
	}

	public void setManagerDao(IManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	
	
	public List<Article> afficherArticle(){
		return managerDao.afficherArticle();
	}
	
	}
