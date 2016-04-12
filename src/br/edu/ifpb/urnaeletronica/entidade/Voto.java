package br.edu.ifpb.urnaeletronica.entidade;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_voto")
@NamedQuery(name = "Voto.getAll", query = "from Voto")
public class Voto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_eleitor")
	private Eleitor eleitor;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_candidato")
	private Candidato candidato;
	
	@Column(name = "urna")	
	private int urna;
	
	@Column(name = "secao")	
	private String secao;
	
	@Column(name="voto")
	private int votoCandidato;

	@Column(name = "data")
	 private Date data;
	 
	public void setVotoCandidato(int votoCandidato) {
		this.votoCandidato = votoCandidato;
	}
	
	public int getVotoCandidato() {
		return votoCandidato;
	}

	public Eleitor getEleitor() {
		return eleitor;
	}

	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public int getUrna() {
		return urna;
	}

	public void setUrna(int urna) {
		this.urna = urna;
	}

	public String getSecao() {
		return secao;
	}

	public void setSecao(String secao) {
		this.secao = secao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
