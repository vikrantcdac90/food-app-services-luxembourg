package lu.appsdeveloper.entiry;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "employee") 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employee {

	@TableGenerator(name = "emp_gen",table = "id_gen", pkColumnName = "gen_name",valueColumnName = "gen_val",allocationSize = 100)
	@Id 
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "emp_gen")
	private int id;
	private String name;
}
