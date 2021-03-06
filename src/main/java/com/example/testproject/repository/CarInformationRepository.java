package com.example.testproject.repository;

import com.example.testproject.domain.CarInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarInformationRepository extends JpaRepository<CarInformation, Long> {
}
