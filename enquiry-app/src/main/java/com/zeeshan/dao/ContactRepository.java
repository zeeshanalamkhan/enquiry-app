package com.zeeshan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeeshan.domain.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
