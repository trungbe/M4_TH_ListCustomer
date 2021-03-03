package service;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService {
    private static List<Customer> list = new ArrayList<>();

    static {
        list.add(new Customer(0, "trung", "trungbe@gmail.com", "hp"));
        list.add(new Customer(1, "thinh", "thinh@gmail.com", "tb"));
        list.add(new Customer(2, "dat", "datvu@gmail.com", "hn"));
        list.add(new Customer(3, "ky", "kypt@gmail.com", "ht"));
    }

    @Override
    public List findAll() {
        return list;
    }

    @Override
    public Customer findById(int id) {
        return list.get(id);
    }

    @Override
    public boolean create(Customer customer) {
        list.add(customer);
        return false;
    }

    @Override
    public boolean save(Customer customer, int id) {
        list.set(id, customer);
        return false;
    }

    @Override
    public void remove(int id) {
        list.remove(id);
    }


}
