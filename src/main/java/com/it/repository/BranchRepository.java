package com.it.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.entities.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer>
{

	Optional<Branch> findByMobile(String mobile);

}
