package com.techolution.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Shyamjumberu
 *
 */
@Repository
public interface ServiceInstanceRepository extends CrudRepository<ServiceInstance, String> {
}
