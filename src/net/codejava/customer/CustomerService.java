package net.codejava.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Code the CustomerService class in the business/service layer </br>
 * 
 * @Transactional annotation means all of its methods will be intercepted by
 *                Spring Data JPA for transaction management
 *
 *
 */
@Service
@Transactional
public class CustomerService {
    // an instance of CustomerRepository interface will be injected into
    // we don't write any DAO code but Spring Data JPA will generate an
    // implementation automatically at runtime
    @Autowired
    private CustomerRepository repo;

    public void save(Customer customer) {
        repo.save(customer);
    }

    public List<Customer> listAll() {
        return (List<Customer>) repo.findAll();
    }

    public Customer get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Customer> search(String keyword) {
        return repo.search(keyword);
    }
}
