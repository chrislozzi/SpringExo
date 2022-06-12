package fr.fms.business;

import java.util.List;

import fr.fms.entities.Article;
import fr.fms.entities.Category;

public interface IShopJpa {
	
	public List<Article> readArticles();
	public Article readArticleById(Long articleId);
	public Article readArticleByDescription(String description);
	public void createArticle(Article article);
	public void deleteArticleById(Long articleId);
	public Article readCategoryArticlesById(Long categoryId);
	public List<Category> readCategories();
	public Category readCategoryById(Long categoryId);
	public Category readCategoryByName(String Name);
	public void createCategory(Category category);
	public void deleteCategoryById(Long categoryId);

}
