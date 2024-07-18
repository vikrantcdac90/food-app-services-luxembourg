package lu.appsdeveloper.repository;

import org.springframework.data.repository.CrudRepository;

import lu.appsdeveloper.entiry.Employee;

public interface EmployeeRepository  extends CrudRepository<Employee, Integer>{

}
