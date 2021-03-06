package fr.fms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.fms.entities.Article;

public interface ArticleRepository extends JpaRepository<Article,Long>{

	public List<Article> findByBrand(String brand);
	public List<Article> findByBrandContains(String brand);
	public List<Article> findByBrandAndPrice(String brand, double price);
	public List<Article> findByBrandAndPriceGreaterThan(String brand, double price);
	public List<Article> findByCategoryId(Long categoryId);
	@Query("select A from Article A where A.brand like %:x% and A.price > :y")
	public List<Article> searchArticles(@Param("x") String brand, @Param("y")Double price);
	  
	/*Exercice 1.2*/	  
	public Optional<Article>  findById(Long id);
	public Optional<Article>  findByDescription(String description);
		
	/*Exercice 1.3*/
	public List<Article> findByDescriptionOrBrand(String description, String brand);
		
	/*Exercice 1.4*/
	public void deleteById(Long id);
		
	/*Exercice 1.5*/
	
	public default void updateById(Long id) {
		
	}
	
	
	
}
