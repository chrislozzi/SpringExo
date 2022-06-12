
package fr.fms;

import java.util.List; import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.CommandLineRunner; 
import  org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import fr.fms.business.IShopJpaIplm;
import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@SpringBootApplication 
public class ShopJpaApp implements CommandLineRunner{
	Article article = null;
	private static Scanner scan = new Scanner(System.in);	

	@Autowired 
	private IShopJpaIplm iShopJpaIplm;

	public static void main(String[] args) {
		SpringApplication.run(ShopJpaApp.class, args);

	}

	@Override 
	@Transactional
	public void run(String... args) throws Exception {
		/*
		 * Category smartphone = categoryRepository.save(new Category("Smartphone"));
		 * Category tablet = categoryRepository.save(new Category("Tablet")); 
		 * Category pc = categoryRepository.save(new Category("PC"));
		 * articleRepository.save(new Article("S9","Samsung",250,smartphone));
		 * articleRepository.save(new Article("S8","Samsung",250,smartphone));
		 * articleRepository.save(new Article("GalaxyTab","Samsung",350,smartphone));
		 * articleRepository.save(new Article("S10","Samsung",500,smartphone));
		 * articleRepository.save(new Article("MI10","Xiaomi",100,smartphone));
		 * articleRepository.save(new Article("Ipad","Apple",350,tablet));
		 * articleRepository.save(new Article("R510","Asus",600,pc));
		 */
		
		
		int action = 0;
		while(action != 9) 
		{	

			System.out.println("\n- 1:Afficher les articles \n- 2:Afficher un article \n- 3:Gérer les articles \n- 4:Afficher les Categories"
							+ "  \n- 5:Afficher les articles d'une catégorie \n- 6:Afficher une catégorie \n- 8:Gérer les catégories \n- 9:sortir");			
			
			action = scan.nextInt();

			switch(action) {				
			case 1 :displayArticles();													
				break;

			case 2 :displayOneArticleMenu();
				break;

			case 3 : manageArticleMenu();
				break;

			case 4 : displayAllCategory();
			break;

			case 5 : displayCategoryArticles();
				break;

			case 6 :					


				break;

			case 7 : System.out.println("sortie" + "\n");
			break;

			default : System.out.println("mauvaise saisie");							
			}
		}




	} 
	//Affiche tous les articles
	private void displayArticles() {
		List<Article> articles = iShopJpaIplm.readArticles();
		System.out.format("%-4s%-30s%-30s%-10s \n","+----", "+------------------------------", "+------------------------------+", "----------+");
		System.out.format("|%-4s|%-30s|%-30s|%-10s|\n","Id", "Description", "Marque", "Prix");
		System.out.format("%-4s%-30s%-30s%-10s \n","+----", "+------------------------------", "+------------------------------+", "----------+");

		articles.forEach(article -> {			
			System.out.format("|%-4d|%-30s|%-30s|%-10.2f|\n",article.getId(), article.getDescription(),
					article.getBrand(), article.getPrice())
			;});

		System.out.format("%-4s%-30s%-30s%-10s \n","+----", "+------------------------------", "+------------------------------+", "----------+");
	}
	
	
	//Sous-menu pour afficher un article à partir de son id ou de sa description
	private void displayOneArticleMenu() {	
		System.out.println("\n- 1:Afficher un article à partir de son id \n- 2:Afficher un article à partir de sa description");		
		int action = scan.nextInt();
		
		if(action == 1) 
		{
			System.out.println("Saisissez l'identifiant de l'article");
			long idArticle = (long)(scan.nextInt());
			article = iShopJpaIplm.readArticleById(idArticle);			
			
		}else if(action == 2){
			
			System.out.println("Saisissez la description de l'article");
			String descriptionArticle = scan.next();
			article = iShopJpaIplm.readArticleByDescription(descriptionArticle);
		}
		
		if(article!=null) 
			displayOneArticle(article);
		
	}
	//Affiche un article
	private void displayOneArticle(Article article) {
		
		System.out.format("%-4s%-30s%-30s%-10s \n","+----", "+------------------------------", "+------------------------------+", "----------+");
		System.out.format("|%-4s|%-30s|%-30s|%-10s|\n","Id", "Description", "Marque", "Prix");
		System.out.format("%-4s%-30s%-30s%-10s \n","+----", "+------------------------------", "+------------------------------+", "----------+");
		System.out.format("|%-4d|%-30s|%-30s|%-10.2f|\n",article.getId(), article.getDescription(), article.getBrand(), article.getPrice());
		System.out.format("%-4s%-30s%-30s%-10s \n","+----", "+------------------------------", "+------------------------------+", "----------+");
	}
	
	//Sous-menu de gestion des articles
	private void manageArticleMenu() {
		long idArticle = 0;
		System.out.println("\n- 1:Ajouter un nouvel article \n- 2:Modifier un article \n- 3:Supprimer un article");		
		int action = scan.nextInt();
		
		if(action == 1) 
		{
			System.out.println("Saisissez la description de l'article");
			String descriptionArticle = scan.next();			
			System.out.println("Saisissez la marque de l'article");
			String brandArticle = scan.next();			
			System.out.println("Saisissez le prix de l'article");
			double priceArticle = scan.nextDouble();			
			System.out.println("Saisissez la catégorie de l'article");
			String categoryArticle = scan.next();	
			
			iShopJpaIplm.createArticle(new Article(descriptionArticle, brandArticle, priceArticle, iShopJpaIplm.readCategoryByName(categoryArticle)));
			
			displayOneArticle(iShopJpaIplm.readArticleByDescription(descriptionArticle));
			
		}else if(action==2){
			
			updateOneArticle();			
			
		}else if(action==3){
			
			System.out.println("Saisissez l'id de l'article à supprimer");
				idArticle = scan.nextLong();
				iShopJpaIplm.deleteArticleById(idArticle);
		}
	}
	//update de la description, de la marque ou du prixd'un article
	private void updateOneArticle() {
		int action = 0;
		String description = "";
		String brand ="";
		double price =0;
		long idArticle = 0;
		
		displayArticles();
		System.out.println("Saisissez l'id de l'article à modifier");
		idArticle = scan.nextLong();
		article = iShopJpaIplm.readArticleById(idArticle);
		displayOneArticle(article);		
		System.out.println("\n- 1:Modifier la description \n- 2:Modifier la marque \n- 3:Modifier le prix");	
		
		action = scan.nextInt();
		if(action==1) {
			System.out.println("Saisissez une nouvelle valeur pour la description de l'article");
			description = scan.next();
			article.setDescription(description);
			iShopJpaIplm.createArticle(article);
			displayOneArticle(iShopJpaIplm.readArticleById(article.getId()));	
			
		}else if(action==2) {
			System.out.println("Saisissez une nouvelle valeur pour la marque de l'article");
			brand = scan.next();
			article.setBrand(brand);
			iShopJpaIplm.createArticle(article);
			displayOneArticle(iShopJpaIplm.readArticleById(article.getId()));	
			
		}else if(action==3) {
			System.out.println("Saisissez une nouvelle valeur pour le prix de l'article");
			price = scan.nextDouble();
			article.setPrice(price);
			iShopJpaIplm.createArticle(article);
			displayOneArticle(iShopJpaIplm.readArticleById(article.getId()));	
		}
		
	}
	
	private void displayCategoryArticles() {
		
	}


	//Affiche la liste des catégories
			private  void displayAllCategory() {
				List<Category>  categories = iShopJpaIplm.readCategories() ;
				System.out.format("%-4s%-20s \n","+----", "+--------------------+");
				System.out.format("|%-4s|%-20s|\n","Id", "Nom");
				System.out.format("%-4s%-20s \n","+----", "+--------------------+");
	
				categories.forEach(category -> {			
					System.out.format("|%-4d|%-20s|\n",category.getId() , category.getName())
					;});
	
				System.out.format("%-4s%-20s \n","+----", "+--------------------+");
			}
}




