
package com.jpa.ecomm_ops.repository;

import com.jpa.ecomm_ops.entity.Address;
import com.jpa.ecomm_ops.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}