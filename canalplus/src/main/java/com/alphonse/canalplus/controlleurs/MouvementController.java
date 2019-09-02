package com.alphonse.canalplus.controlleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphonse.canalplus.dao.MouvementDao;
import com.alphonse.canalplus.entities.Mouvement;

@RestController
@RequestMapping({ "/mouvements" })
public class MouvementController {
	@Autowired
	private MouvementDao mouvementDao;

	@PostMapping
	public void save(@RequestBody Mouvement mouvement) {
		mouvementDao.save(mouvement);

	}

	@GetMapping
	public List<Mouvement> findAll() {
		return mouvementDao.findAll();
	}

}
