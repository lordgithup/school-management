package it.nxtvision.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.nxtvision.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}

