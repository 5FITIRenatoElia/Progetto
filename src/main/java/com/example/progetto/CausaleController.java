package com.example.progetto;

import org.springframework.web.bind.annotation.*;

@RestController

public class CausaleController {
		//
	private CausaleRepository causale;
	
	public CausaleController(CausaleRepository listacausali) {
		this.causale = listacausali;
	}
 
	//CREATE
	@PostMapping("/causali")
	Causale createCausale(@RequestBody Causale c) {
		return causale.save(c); 
	}
 
	//READ ALL
	@GetMapping("/causali")
	Iterable<Causale> listaCausale() {
		return causale.findAll(); 
	}
 
	//READ ONE
	@GetMapping("/causali/{id_causale}")
	Causale printCausale(@PathVariable long id_causale) {
		return causale.findById(id_causale).orElseThrow(null); 
	}

	//DELETE
	@DeleteMapping("/causali/{id_causale}/delete")
	Iterable<Causale> deleteCausale(@PathVariable long id_causale) {
		causale.deleteById(id_causale); 
		return causale.findAll();
	}
	
	//UPDATENOME
	@PutMapping("/causali/{id_causale}/updateNome")
	Iterable<Causale> updateNome(@PathVariable long id_causale, @RequestBody Causale Nome) {
		Causale c = causale.findById(id_causale).orElseThrow(null); 
		c.setNome(Nome.getNome());
		causale.save(c);
		return causale.findAll();
	}
	
	//UPDATEDareAvere
		@PutMapping("/causali/{id_causale}/updatedareAvere")
		Iterable<Causale> updatedareAvere(@PathVariable long id_causale, @RequestBody Causale dareAvere) {
			Causale c = causale.findById(id_causale).orElseThrow(null); 
			c.setDareAvere(dareAvere.getDareAvere());
			causale.save(c);
			return causale.findAll();
		}
}