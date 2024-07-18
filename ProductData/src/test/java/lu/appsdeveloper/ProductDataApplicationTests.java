package lu.appsdeveloper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;

import lu.appsdeveloper.repository.EmployeeRepository;
import lu.appsdeveloper.repository.ProductRepository;

@SpringBootTest
class ProductDataApplicationTests {
	@Autowired
	private ProductRepository repository;
	@Autowired
	private EmployeeRepository empRepository;

	@Test
	//@Modifying(clearAutomatically = false, flushAutomatically = false)
	void testReposityGetAll() {

		//repository.findByNameContains("D", PageRequest.of(1, 2))
				//.forEach((product) -> System.out.println(product.getName()));

	}

	@Test
	void saveEmployee() {
		repository.findByName("Tv").forEach((product) -> System.out.println(product.getDesc()));
	}

}
