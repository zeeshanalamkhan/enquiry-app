package com.zeeshan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeeshan.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
