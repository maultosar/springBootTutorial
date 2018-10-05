package com.springBoot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.model.Shipwreck;
import com.springBoot.repository.ShipwreckRepository;

@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {

	@Autowired
	private ShipwreckRepository shipwreckRepository;

	@RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
	public List<Shipwreck> list() {
		return shipwreckRepository.findAll();
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
	public Optional<Shipwreck> getOne(@PathVariable Long id) {
		return shipwreckRepository.findById(id);
	}

	@RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck shipwreck) {
		return shipwreckRepository.saveAndFlush(shipwreck);
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
	public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
		Optional<Shipwreck> existingShipwreck = shipwreckRepository.findById(id);
		BeanUtils.copyProperties(shipwreck, existingShipwreck.get());
		return shipwreckRepository.saveAndFlush(existingShipwreck.get());
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
	public Long delete(@PathVariable Long id) {
		shipwreckRepository.deleteById(id);
		return id;
	}
}
