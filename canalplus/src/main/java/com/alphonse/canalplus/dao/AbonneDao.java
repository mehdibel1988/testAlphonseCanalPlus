package com.alphonse.canalplus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alphonse.canalplus.entities.Abonne;

@Repository
public interface AbonneDao extends JpaRepository<Abonne, Long> {

	@Query(value = "from Abonne  where id=:x  and adresse.pays like 'France' ")
	public Abonne getAbonneEnFrance(@Param("x") Long id);

}
