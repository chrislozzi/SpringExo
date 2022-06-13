package fr.fms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.fms.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{
	
	public Optional<Category> findCategoryByName(String Name);
	
	/*Exercice 1.6*/
	
	public List<Category> findAllByOrderByNameDesc();
	public List<Category> findAllByOrderByNameAsc();
	
}
