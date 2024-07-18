package lu.appsdeveloper.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import lu.appsdeveloper.entiry.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

	// List<Product> findByName(String name);

	List<Product> findByNameAndDesc(String name, String desc);

	List<Product> findByPriceGreaterThan(Double price);

	List<Product> findByNameOrDesc(String name, String desc);

	List<Product> findByNameContains(String name, Pageable page);

	@Query("from Product where name =: name")
	List<Product> findByName(@Param("name") String name);
	
	

}
