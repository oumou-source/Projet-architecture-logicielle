package services;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import models.Article;

public interface IManagerService {

	@Transactional
	public List<Article> afficherArticle();

}
