package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.entities.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>
{

}
