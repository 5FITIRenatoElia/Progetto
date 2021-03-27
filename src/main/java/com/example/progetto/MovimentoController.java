package com.example.progetto;

import org.springframework.web.bind.annotation.*;

@RestController

public class MovimentoController {
	
	private MovimentoRepository movimento;
	
	public MovimentoController(MovimentoRepository listamovimenti) {
		this.movimento = listamovimenti;
	}
 
	//CREATE
	@PostMapping("/movimenti")
	Movimento mreateMovimento(@RequestBody Movimento m) {
		return movimento.save(m); 
	}
 
	//READ ALL
	@GetMapping("/movimenti")
	Iterable<Movimento> listaMovimento() {
		return movimento.findAll(); 
	}
 
	//READ ONE
	@GetMapping("/movimenti/{id_movimento}")
	Movimento printMovimento(@PathVariable long id_movimento) {
		return movimento.findById(id_movimento).orElseThrow(null); 
	}

	//DELETE
	@DeleteMapping("/movimenti/{id_movimento}/delete")
	Iterable<Movimento> deleteMovimento(@PathVariable long id_movimento) {
		movimento.deleteById(id_movimento); 
		return movimento.findAll();
	}
	
	//UPDATE DataOra
	@PutMapping("/movimenti/{id_movimento}/updatedataOra")
	Iterable<Movimento> updatedataOra(@PathVariable long id_movimento, @RequestBody Movimento dataOra) {
		Movimento m = movimento.findById(id_movimento).orElseThrow(null); 
		m.setDataOra(dataOra.getDataOra());
		movimento.save(m);
		return movimento.findAll();
	}
	
	//UPDATE Descrizione
	@PutMapping("/movimenti/{id_movimento}/updateDescrizione")
	Iterable<Movimento> updateDescrizione(@PathVariable long id_movimento, @RequestBody Movimento descrizione) {
		Movimento m = movimento.findById(id_movimento).orElseThrow(null); 
		m.setDescrizione(descrizione.getDescrizione());
		movimento.save(m);
		return movimento.findAll();
	}	
	
	//UPDATE Importo
		@PutMapping("/movimenti/{id_movimento}/updateImporto")
		Iterable<Movimento> updateImporto(@PathVariable long id_movimento, @RequestBody Movimento importo) {
			Movimento m = movimento.findById(id_movimento).orElseThrow(null); 
			m.setImporto(importo.getImporto());
			movimento.save(m);
			return movimento.findAll();
		}	
}