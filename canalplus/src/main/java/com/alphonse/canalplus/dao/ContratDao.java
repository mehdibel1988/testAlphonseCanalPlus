package com.alphonse.canalplus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alphonse.canalplus.entities.Contrat;

@Repository
public interface ContratDao extends JpaRepository<Contrat, Long> {

}
