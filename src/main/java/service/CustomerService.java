package service;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private static Map<Integer,Customer> list = new HashMap<>();

    static {
        list.put(1,new Customer(1, "trung", "trungbe@gmail.com", "hp"));
        list.put(2,new Customer(2, "thinh", "thinh@gmail.com", "tb"));
        list.put(3,new Customer(3, "dat", "datvu@gmail.com", "hn"));
        list.put(4,new Customer(4, "ky", "kypt@gmail.com", "ht"));
    }

    @Override
    public List findAll() {
        return new ArrayList<>(list.values());
    }

    @Override
    public Customer findById(int id) {
        return list.get(id);
    }

    @Override
    public boolean create(Customer customer) {
        list.put(customer.getId(), customer);
        return false;
    }


    @Override
    public boolean save(Customer customer, int id) {
        list.put(id, customer);
        return false;
    }

    @Override
    public void remove(int id) {
        list.remove(id);
    }


}
