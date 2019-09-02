package com.alphonse.canalplus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alphonse.canalplus.entities.Mouvement;

@Repository
public interface MouvementDao extends JpaRepository<Mouvement, Long> {

}
