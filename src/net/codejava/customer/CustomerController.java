package net.codejava.customer;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller layer, CustomerController class to handle all requests from the clients 
 *
 */
@Controller
public class CustomerController {

    // an instance of CustomerService is injected into this class using the
    // @Autowired annotation.
    @Autowired
    private CustomerService customerService;

    /**
     * Displays all customers
     */
    @RequestMapping("/")
    public ModelAndView home() {
        List<Customer> listCustomer = customerService.listAll();
        ModelAndView mav = new ModelAndView("index");// the view page (index.jsp)
        mav.addObject("listCustomer", listCustomer);
        return mav;
    }

    /**
     * Display the new customer form:
     */
    @RequestMapping("/new")
    public String newCustomerForm(Map<String, Object> model) {
        Customer customer = new Customer();
        model.put("customer", customer);
        return "new_customer";// the JSP page new_customer.jsp
    }

    /**
     * Handle the Save button on this form:
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/";// will redirect the client to the home page after the customer has been saved
                            // successfully
    }

    /**
     * the edit/update customer feature
     */
    @RequestMapping("/edit")
    public ModelAndView editCustomerForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_customer");// code the edit_customer.jsp file
        Customer customer = customerService.get(id);
        mav.addObject("customer", customer);

        return mav;
    }

    /**
     * delete customer feature
     */
    @RequestMapping("/delete")
    public String deleteCustomerForm(@RequestParam long id) {
        customerService.delete(id);
        return "redirect:/";// deleted and the list is refreshed.
    }

    /**
     * Search for customers by typing a keyword
     */
    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Customer> result = customerService.search(keyword);
        ModelAndView mav = new ModelAndView("search");// code the search.jsp file

        mav.addObject("result", result);

        return mav;
    }
}
