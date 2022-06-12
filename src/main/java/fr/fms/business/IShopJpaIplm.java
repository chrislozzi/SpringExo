package fr.fms.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@Service
public class IShopJpaIplm implements IShopJpa{
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ArticleRepository articleRepository;
	
	
	@Override
	public List<Article> readArticles() {
		
		return articleRepository.findAll();
	}


	@Override
	public Article readArticleById(Long articleId) {
		
		return articleRepository.findById(articleId).get();
	}


	@Override
	public void createArticle(Article article) {
		 articleRepository.save(article);
	}


	@Override
	public void deleteArticleById(Long articleId) {
		articleRepository.deleteById(articleId);
		
	}


	@Override
	public Article readArticleByDescription(String description) {
		return articleRepository.findByDescription(description).get();
	}


	@Override
	public Category readCategoryById(Long articleId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Category readCategoryByName(String Name) {
		
		return categoryRepository.findCategoryByName(Name).get();
	}


	@Override
	public Article readCategoryArticlesById(Long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> readCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public void createCategory(Category category) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteCategoryById(Long categoryId) {
		// TODO Auto-generated method stub
		
	}
	
}
