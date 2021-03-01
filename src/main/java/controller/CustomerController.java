package controller;

import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.CustomerService;

import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    CustomerService customerService = new CustomerService();

    @GetMapping("/list")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> list = customerService.findAll();
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView ShowCreat() {
        ModelAndView modelAndView = new ModelAndView("create");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@RequestParam Integer id, String name, String email, String address) {
        ModelAndView modelAndView = new ModelAndView("list");
        Customer customers = new Customer(id, name, email, address);
        customerService.create(customers);
        List<Customer> list = customerService.findAll();
        modelAndView.addObject("listCustomer", list);
        return modelAndView;
    }
}
