package com.github.sparsick.clouddemoapp;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @GetMapping("/customer")
    public String viewAllCustomer(Model model) {
        List<Customer> customers = List.of(new Customer("Batman", "Gotham City"), new Customer("Superman", "Metropolis"));
        model.addAttribute("customers", customers);

        return "customer/customer.list.html";
    }

}
