package br.edu.ifpb.urnaeletronica.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.ifpb.urnaeletronica.dao.CandidatoDAO;
import br.edu.ifpb.urnaeletronica.entidade.Candidato;


@ManagedBean (name = "CandidatoBean")
@SessionScoped
public class CandidatoBean {

    private Candidato candidato;
	
	public CandidatoBean() {
		
		this.candidato = new Candidato();		
	}
	 
	@SuppressWarnings("unchecked")
	public void cadastrarCandidato() throws IOException{
		
		CandidatoDAO candidatoDAO = new CandidatoDAO();
		candidatoDAO.insert(candidato);
		FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml"); 	
	}
	
	@SuppressWarnings("unchecked")
	public void deletarCandidato() throws IOException{
		
		CandidatoDAO candidatoDAO = new CandidatoDAO();
		candidatoDAO.delete(candidato);
		FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml"); 	

	}
	
	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
	
	
}