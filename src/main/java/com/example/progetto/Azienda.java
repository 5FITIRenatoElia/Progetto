package com.example.progetto;

import java.util.*;

import javax.persistence.*;

@Entity(name="Aziende")
 
public class Azienda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idAzienda;
	@Column(name="anagrafica", unique=true, nullable=false, length=40)
	private String anagrafica;
	@Column(name="userid", unique=true, nullable=false, length=16)
	private String userid;
	@Column(name="passwd", nullable=false, length=128)
	private char[] passwd;
 
	@OneToMany(mappedBy="azienda", cascade = CascadeType.ALL,orphanRemoval= true)
    private List<Movimento> Movimento = new ArrayList<>();
	
	
	public Azienda(String anagrafica, String userid, char[] passwd) {
		this.anagrafica = anagrafica;
		this.userid = userid;
		this.passwd = passwd;
	}
 
	public Azienda() {}
 
	public String getAnagrafica() {
		return anagrafica;
	}
 
	public void setAnagrafica(String anagrafica) {
		this.anagrafica = anagrafica;
	}
 
	public String getUserid() {
		return userid;
	}
 
	public void setUserid(String userid) {
		this.userid = userid;
	}
 
	public char[] getPasswd() {
		return passwd;
	}
 
	public void setPasswd(char[] passwd) {
		this.passwd = passwd;
	}
 
	public Long getIdAzienda() {
		return idAzienda;
	}
 
}