package com.cloudsherpas.poc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudsherpas.poc.domain.Customer;
import com.cloudsherpas.poc.dto.CustomerDTO;
import com.cloudsherpas.poc.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    public CustomerDTO getCustomer(final Long key) {
        Customer customer = customerRepo.findOne(key);

        return new CustomerDTO(customer);
    }

    public List<CustomerDTO> getAllCustomers() {
        Iterable<Customer> customerList = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : customerList) {
            customerDTOList.add(new CustomerDTO(customer));
        }

        return customerDTOList;
    }

    public void addCustomer(final CustomerDTO customerDTO) {
        customerRepo.save(new Customer(customerDTO));
    }

    public void addCustomers(final List<CustomerDTO> customerDTOList) {
        List<Customer> customerList = new ArrayList<>();

        for (CustomerDTO customerDTO : customerDTOList) {
            customerList.add(new Customer(customerDTO));
        }

        customerRepo.save(customerList);
    }

    public void updateCustomer(Long key, final CustomerDTO customerDTO) {

        Customer toUpdate = customerRepo.findOne(key);
        toUpdate.mapNonIdFields(customerDTO);
        customerRepo.save(toUpdate);
    }

    public void updateAllCustomers(final List<CustomerDTO> customerDTOList) {
        List<Customer> customerList = new ArrayList<>();

        for (CustomerDTO customerDTO : customerDTOList) {
            customerList.add(new Customer(customerDTO));
        }

        customerRepo.save(customerList);
    }

    public void deleteCustomer(final Long key) {
        customerRepo.delete(key);
    }
}
