package com.alphonse.canalplus.controlleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphonse.canalplus.dao.AbonneDao;
import com.alphonse.canalplus.entities.Abonne;

@RestController
@RequestMapping({ "/abonnes" })
public class AbonneControlleur {
	@Autowired
	private AbonneDao abonneDao;

	@GetMapping(path = { "/{id}" })
	public Abonne getAbonneEnFrance(@PathVariable Long id) {
		return abonneDao.getAbonneEnFrance(id);
	}

}
