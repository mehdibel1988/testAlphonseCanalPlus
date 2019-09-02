package com.alphonse.canalplus.controlleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphonse.canalplus.dao.AdresseDao;
import com.alphonse.canalplus.entities.Adresse;

@RestController
@RequestMapping({ "/adresses" })
public class AdresseControlleur {
	@Autowired
	private AdresseDao adresseDao;

	@GetMapping
	public List<Adresse> findAll() {
		return adresseDao.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public Adresse getAbonneEnFrance(@PathVariable Long id) {
		return adresseDao.getOne(id);
	}

	@PutMapping
	public void update(@RequestBody Adresse adresse) {
		adresseDao.save(adresse);

	}

}
