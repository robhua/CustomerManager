package net.codejava.customer;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Code Respository Interface.</br>
 * As with Spring Data JPA, don't have to write any DAO code. </br>
 * - Just declare an interface that extends the CrudRepository interface, which
 * defines CRUD methods like save(), findAll(), findById(),deleteById() </br>
 * - At runtime, Spring Data JPA automatically generates the implementation
 * code. </br>
 * - Must specify the type of the model class and type of the primary key field
 * when extending
 * 
 * @author Admin
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    /**
     * An abstract method annotated with the @Query annotation
     * 
     * @param keyword
     * @return
     */
    @Query(value = "SELECT c FROM Customer c WHERE c.customerName LIKE '%' || :keyword || '%'"
            + " OR c.contactFirstName LIKE '%' || :keyword || '%'" + " OR c.addressLine1 LIKE '%' || :keyword || '%'")
    public List<Customer> search(@Param("keyword") String keyword);
}
