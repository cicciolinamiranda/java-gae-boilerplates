package com.cloudsherpas.poc.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.cloudsherpas.poc.dto.CustomerDTO;
import com.cloudsherpas.poc.service.CustomerService;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;

@Api(name = "customer",
     version = "1")
public class CustomerEndpoint {

    @Autowired(required = true)
    @Qualifier("customerService")
    private CustomerService customerService;

    @ApiMethod(name = "getCustomer",
               path = "customer",
               httpMethod = ApiMethod.HttpMethod.GET)
    public CustomerDTO getCustomer(@Named("customerKey") final String key) {
        return customerService.getCustomer(Long.valueOf(key));
    }

    @ApiMethod(name = "getAllCustomers",
               path = "list",
               httpMethod = ApiMethod.HttpMethod.GET)
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @ApiMethod(name = "addCustomer",
               path = "add",
               httpMethod = ApiMethod.HttpMethod.POST)
    public void addCustomer(final CustomerDTO customerDTO) {
        customerService.addCustomer(customerDTO);
    }

    // @ApiMethod(
    // name = "addCustomers",
    // path = "customers",
    // httpMethod = ApiMethod.HttpMethod.POST
    // )
    // public void addCustomers(final List<CustomerDTO> customerDTOList) {
    // customerService.addCustomers(customerDTOList);
    // }

    @ApiMethod(name = "updateCustomer",
               path = "update",
               httpMethod = ApiMethod.HttpMethod.PUT)
    public void updateCustomer(final CustomerDTO customerDTO) {
        customerService.updateCustomer(customerDTO.getId(), customerDTO);
    }

    // @ApiMethod(
    // name = "updateAllCustomers",
    // path = "customers/all",
    // httpMethod = ApiMethod.HttpMethod.PUT
    // )
    // public void updateCustomers(final List<CustomerDTO> customerDTOList) {
    // customerService.updateAllCustomers(customerDTOList);
    // }

    @ApiMethod(name = "deleteCustomer",
               path = "delete",
               httpMethod = ApiMethod.HttpMethod.DELETE)
    public void deleteCustomer(@Named("key") final String key) {
        customerService.deleteCustomer(Long.valueOf(key));
    }
}
