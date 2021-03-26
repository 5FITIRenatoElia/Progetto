package com.example.progetto;

import org.springframework.web.bind.annotation.*;

 
@RestController
public class AziendaController {
	private AziendaRepository aziende;
 
	public AziendaController(AziendaRepository listaaziende) {
		this.aziende = listaaziende;
	}
 
	@GetMapping("/ciao")
	String getSaluto() {
		return "Salutami a Socrate!";
	}
 
	@GetMapping("/ciao/{nome}")
	String getSalutoNome(@PathVariable String nome) {
		return "Ciao " + nome +", oggi è una bellissima giornata!";
	}
 
	//CREATE
	@PostMapping("/aziende")
	Azienda createAzienda(@RequestBody Azienda a) {
		return aziende.save(a); 
	}
 
	//READ ALL
	@GetMapping("/aziende")
	Iterable<Azienda> listaAzienda() {
		return aziende.findAll(); 
	}
 
	//READ ONE
	@GetMapping("/aziende/{id_azienda}")
	Azienda printAzienda(@PathVariable long id_azienda) {
		return aziende.findById(id_azienda).orElseThrow(null); 
	}
	
	//DELETE
	@DeleteMapping("/aziende/{id_azienda}/delete")
	Iterable<Azienda> deleteAzienda(@PathVariable long id_azienda) {
		aziende.deleteById(id_azienda); 
		return aziende.findAll();
	}
 
	//UPDATE
	@PutMapping("/aziende/{id_azienda}/updateAnagrafica")
	Iterable<Azienda> updateAnagrafica(@PathVariable long id_azienda, @RequestBody Azienda Anagrafica) {
		Azienda a = aziende.findById(id_azienda).orElseThrow(null); 
		a.setAnagrafica(Anagrafica.getAnagrafica());
		aziende.save(a);
		return aziende.findAll();
	}
	
	@PutMapping("/aziende/{id_azienda}/updatePassword")
	Iterable<Azienda> updatePassword(@PathVariable long id_azienda, @RequestBody Azienda Password) {
		Azienda a = aziende.findById(id_azienda).orElseThrow(null); 
		a.setPasswd(Password.getPasswd());
		aziende.save(a);
		return aziende.findAll();
	}
	
}
 