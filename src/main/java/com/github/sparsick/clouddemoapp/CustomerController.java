package com.github.sparsick.clouddemoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customer")
    public String viewAllCustomer(Model model) {
        model.addAttribute("customers", customerRepository.allCustomers());

        return "customer/customer.list.html";
    }

    @GetMapping("/customer/new")
    public String newCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/customer.new.html";
    }

    @PostMapping("/customer/new")
    public String addNewCustomer(@ModelAttribute("customer") Customer customer){
        customerRepository.addCustomer(customer);
        return "redirect:/customer";
    }

}
