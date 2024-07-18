package lu.appsdeveloper.repository;

import org.springframework.data.repository.CrudRepository;

import lu.appsdeveloper.dto.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


public interface ProdRepository extends CrudRepository<Product, Long> {
	List<Product> findByNameAndActive(String name, boolean active);
	
	List<Product> findByPriceGreaterThan(BigDecimal price);
	
	List<Product> findByNameOrDescription(String name, String description);
	
	List<Product> findByDateCreatedBetween(LocalDateTime from,LocalDateTime to);

}
