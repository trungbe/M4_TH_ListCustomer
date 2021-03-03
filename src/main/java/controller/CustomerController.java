package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.ICustomerService;

import java.security.PublicKey;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

//    CustomerService customerService = new CustomerService();

//    @GetMapping("/list")
//    public ModelAndView showList() {
//        ModelAndView modelAndView = new ModelAndView("list");
//        List<Customer> list = customerService.findAll();
//        modelAndView.addObject("list", list);
//        return modelAndView;
//    }

    //        @GetMapping("/create")
//    public ModelAndView ShowCreat() {
//        ModelAndView modelAndView = new ModelAndView("create");
//        return modelAndView;
//    }
//
//    @PostMapping("/create")
//    public ModelAndView create(@RequestParam Integer id, String name, String email, String address) {
//        ModelAndView modelAndView = new ModelAndView("list");
//        Customer customers = new Customer(id, name, email, address);
//        customerService.create(customers);
//        List<Customer> list = customerService.findAll();
//        modelAndView.addObject("listCustomer", list);
//        return modelAndView;
//    }
    @GetMapping("")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list", "list", customerService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showFormEdit(@PathVariable int id, ModelMap modelMap) {
        Customer customer = customerService.findById(id);
        modelMap.addAttribute("customer", customer);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editCustomer(@PathVariable int id, @ModelAttribute Customer customer) {
        customer.setId(id);
        customerService.save(customer, id);
        return new ModelAndView("list", "list", customerService.findAll());
//        return "redirect:/";
    }

    @GetMapping("/create")
    public ModelAndView showCreateCustomer() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Customer customer) {
        int id = customerService.findAll().size();
        customer.setId(id);
        customerService.create(customer);
        ModelAndView modelAndView = new ModelAndView("create", "customer", new Customer());
        modelAndView.addObject("mess", "Tao moi thanh cong customer ten la " + customer.getName());
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteCustomer(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        customerService.remove(id);
        return modelAndView;
    }
}
