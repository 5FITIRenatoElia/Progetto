package com.example.progetto;

import java.time.LocalDateTime;

import javax.persistence.*;
 
@Entity(name="Movimento")
 
public class Movimento {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idMovimento;
	@Column(name="dataOra", unique=true, nullable=false)
	private LocalDateTime dataOra;
	@Column(name="descrizione", unique=true, length=150)
	private String descrizione;
	@Column(name="importo", unique=false, nullable=false)
	private Double importo;
	
	@ManyToOne
	@JoinColumn(name = "codAzienda", nullable=false)
	private Azienda azienda;
	
	@ManyToOne
	@JoinColumn(name = "codCausale", nullable=false)
	private Causale causale;
	
	public Movimento() {}

	public Movimento(long idMovimento, LocalDateTime dataOra, String descrizione, Double importo, Azienda azienda,
			Causale causale) {
		this.idMovimento = idMovimento;
		this.dataOra = dataOra;
		this.descrizione = descrizione;
		this.importo = importo;
		this.azienda = azienda;
		this.causale = causale;
	}

	public long getIdMovimento() {
		return idMovimento;
	}

	public LocalDateTime getDataOra() {
		return dataOra;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public Double getImporto() {
		return importo;
	}

	public void setDataOra(LocalDateTime dataOra) {
		this.dataOra = dataOra;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}
	

}