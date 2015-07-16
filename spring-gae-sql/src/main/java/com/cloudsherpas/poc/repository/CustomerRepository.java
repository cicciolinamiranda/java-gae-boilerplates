package com.cloudsherpas.poc.repository;

import org.springframework.data.repository.CrudRepository;

import com.cloudsherpas.poc.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
