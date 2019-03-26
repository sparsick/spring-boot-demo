package com.github.sparsick.clouddemoapp;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    private Set<Customer> customers = new HashSet<>();

    @PostConstruct
    public void init(){
        customers.add(new Customer("Batman", "Gotham City"));
        customers.add(new Customer("Superman", "Metropolis"));
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Collection<Customer> allCustomers(){
        return new HashSet<>(customers);
    }

}
