package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.entities.DispatchItems;

@Repository
public interface DispatchItemRepository extends JpaRepository<DispatchItems, Integer>
{

}
