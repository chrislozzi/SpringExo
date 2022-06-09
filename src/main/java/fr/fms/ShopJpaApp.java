/*
 * package fr.fms;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.CommandLineRunner; import
 * org.springframework.boot.SpringApplication; import
 * org.springframework.boot.autoconfigure.SpringBootApplication; import
 * org.springframework.data.jpa.repository.Query;
 * 
 * import fr.fms.dao.ArticleRepository; import fr.fms.dao.CategoryRepository;
 * import fr.fms.entities.Article; import fr.fms.entities.Category;
 * 
 * @SpringBootApplication public class ShopJpaApp implements CommandLineRunner{
 * 
 * @Autowired private CategoryRepository categoryRepository;
 * 
 * @Autowired private ArticleRepository articleRepository;
 * 
 * public static void main(String[] args) {
 * SpringApplication.run(ShopJpaApp.class, args);
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
 * articleRepository.save(new Article("GalaxyTab","Samsung",350,smartphone));
 * articleRepository.save(new Article("S10","Samsung",500,smartphone));
 * articleRepository.save(new Article("MI10","Xiaomi",100,smartphone));
 * articleRepository.save(new Article("Ipad","Apple",350,tablet));
 * articleRepository.save(new Article("R510","Asus",600,pc));
 * 
 * 
 * 
 * }
 * 
 * }
 */