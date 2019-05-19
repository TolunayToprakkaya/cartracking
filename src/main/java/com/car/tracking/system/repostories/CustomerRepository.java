package com.car.tracking.system.repostories;

import com.car.tracking.system.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "customers", collectionResourceRel = "customers", exported = false)
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
