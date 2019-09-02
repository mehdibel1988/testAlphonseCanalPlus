package com.alphonse.canalplus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alphonse.canalplus.entities.Adresse;

@Repository
public interface AdresseDao extends JpaRepository<Adresse, Long> {  

}
