package com.example.progetto;

import java.util.*;
import javax.persistence.*;
 
@Entity(name="Causali")
 
public class Causale {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idCausale;
	@Column(name="nome", unique=true, nullable=false, length=40)
	private String nome;
	@Column(name="dareAvere", unique=false, nullable=false)
	private char dareAvere;

	@OneToMany(mappedBy="causale", cascade = CascadeType.ALL,orphanRemoval= true)
    private List<Movimento> Movimento = new ArrayList<>();
	
	public Causale() {}

	public Causale(String nome, char dareAvere) {
		this.nome = nome;
		this.dareAvere = dareAvere;
	}

	public long getIdCausale() {
		return idCausale;
	}

	public String getNome() {
		return nome;
	}

	public char getDareAvere() {
		return dareAvere;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDareAvere(char dareAvere) {
		this.dareAvere = dareAvere;
	}
	
	
}