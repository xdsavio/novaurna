package br.edu.ifpb.urnaeletronica.entidade;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_candidato")
@NamedQuery(name = "Candidato.getAll", query = "from Candidato")
public class Candidato extends Pessoa{
	
	@Column(name = "cnpj")
	private String cnpj;
	
	@Column(name = "numero")
	private int numero;
	
	@Column(name = "cargo")
	private String cargo;
	
	@Column(name = "partido")
	private String partido;
	
	@Column(name = "data")
	 private Date data;

	 @Column(name="voto")
	 private int votoCandidato;
	 
	 @Column(name="numVoto")
	 private int numVoto;

	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getPartido() {
		return partido;
	}
	
	public void setPartido(String partido) {
		this.partido = partido;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getVotoCandidato() {
		return votoCandidato;
	}

	public void setVotoCandidato(int votoCandidato) {
		this.votoCandidato = votoCandidato;
	}

	public int getNumVoto() {
		return numVoto;
	}

	public void setNumVoto(int numVoto) {
		this.numVoto = numVoto;
	}

	
	

}
