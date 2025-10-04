package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.entities.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer>
{

}
