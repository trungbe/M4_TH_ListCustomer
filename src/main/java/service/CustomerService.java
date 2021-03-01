package service;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService {
    private static List<Customer> list = new ArrayList<>();

    static {
        list.add(new Customer(1, "trung", "trungbe@gmail.com", "hp"));
        list.add(new Customer(2, "thinh", "thinh@gmail.com", "tb"));
        list.add(new Customer(3, "dat", "datvu@gmail.com", "hn"));
    }

    @Override
    public List findAll() {
        return list;
    }

    @Override
    public void create(Customer customer) {
        list.add(customer);
    }
}
