package com.ooredoo.persistence.repository;

import com.ooredoo.persistence.model.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Long> {
    Franchise findByIdNumber(String idNumber);
    List<Franchise> findAllByenabledTrue();
}
