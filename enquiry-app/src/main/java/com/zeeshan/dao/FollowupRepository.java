package com.zeeshan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeeshan.domain.Followup;

public interface FollowupRepository extends JpaRepository<Followup, Long> {

}
