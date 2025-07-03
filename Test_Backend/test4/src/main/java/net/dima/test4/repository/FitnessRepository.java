package net.dima.test4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dima.test4.entity.FitnessEntity;

public interface FitnessRepository extends JpaRepository<FitnessEntity, Integer>{

}
