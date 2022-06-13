/*
 * package fr.fms;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import org.hibernate.internal.build.AllowSysOut; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.CommandLineRunner; import
 * org.springframework.boot.SpringApplication; import
 * org.springframework.boot.autoconfigure.SpringBootApplication; import
 * org.springframework.data.jpa.repository.Query;
 * 
 * import fr.fms.dao.ArticleRepository; import fr.fms.dao.CategoryRepository;
 * import fr.fms.entities.Article; import fr.fms.entities.Category;
 * 
 * @SpringBootApplication public class SpringShopJpaApplication implements
 * CommandLineRunner{
 * 
 * @Autowired private CategoryRepository categoryRepository;
 * 
 * @Autowired private ArticleRepository articleRepository;
 * 
 * public static void main(String[] args) {
 * SpringApplication.run(SpringShopJpaApplication.class, args);
 * 
 * }
 * 
 * 
 * @Override public void run(String... args) throws Exception {
 * 
 * 
 * Category smartphone = categoryRepository.save(new Category("Smartphone"));
 * Category tablet = categoryRepository.save(new Category("Tablet")); Category
 * pc = categoryRepository.save(new Category("PC"));
 * 
 * articleRepository.save(new Article("S9","Samsung",250,smartphone));
 * articleRepository.save(new Article("S8","Samsung",250,smartphone));
 * articleRepository.save(new Article("GalaxyTab","Samsung",350,tablet));
 * articleRepository.save(new Article("S10","Samsung",500,smartphone));
 * articleRepository.save(new Article("MI10","Xiaomi",100,smartphone));
 * articleRepository.save(new Article("Ipad","Apple",350,tablet));
 * articleRepository.save(new Article("R510","Asus",600,pc));
 * 
 * 
 * }
 * 
 * } // for(Article article : articleRepository.findByBrand("Samsung")){ //
 * 
 * System.out.println(article); }
 * 
 * 
 * 
 * //for(Article article : //
 * articleRepository.findByBrandAndPriceGreaterThan("Samsung",300)) { //
 * System.out.println(article); }
 * 
 * 
 * //System.out.println(articleRepository.findByCategoryId((long) (12)));
 * 
 * 
 * 
 * // for(Article article : articleRepository.searchArticles("sung", 200.0)) {
 * // System.out.println(article); }
 * 
 * 
 *//************************************************************/
/*
 * 
 * // Exercice 1.2
 * 
 * // System.out.println(articleRepository.findById((long)(2)));
 * //System.out.println(articleRepository.findByDescription("S10"));
 *//************************************************************/
/*
 * 
 * //Exercice 1.3
 * //System.out.println(articleRepository.findByDescriptionOrBrand("S10","Apple"
 * ));
 * 
 * 
 *//************************************************************/
/*
 * 
 * // Exercice 1.4 //articleRepository.deleteById((long) (1));
 * 
 *//************************************************************/
/*
 * 
 * //Exercice 1.5
 * 
 * // Optional<Article> articleToUpdate = articleRepository.findById((long)(2));
 * // articleToUpdate.get().setPrice(2000.0); //
 * articleRepository.save(articleToUpdate.get());
 * 
 * 
 *//************************************************************//*
																	 * //Exercice 1.6
																	 * 
																	 * //for(Category category:
																	 * categoryRepository.findAllByOrderByNameDesc()) {
																	 * //System.out.println(category); } }
																	 * 
																	 * // }
																	 */