package br.edu.ifpb.urnaeletronica.bean;
import java.io.IOException;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.ifpb.urnaeletronica.dao.CandidatoDAO;
import br.edu.ifpb.urnaeletronica.dao.EleitorDAO;
import br.edu.ifpb.urnaeletronica.dao.VotoDAO;
import br.edu.ifpb.urnaeletronica.entidade.Candidato;
import br.edu.ifpb.urnaeletronica.entidade.Eleitor;
import br.edu.ifpb.urnaeletronica.entidade.Voto;


@ManagedBean(name = "SessaoBean")
@SessionScoped

public class SessaoBean {

	Eleitor eleitor;
	Candidato candidato;
	Voto voto;  
	
	public SessaoBean() {
		
		this.eleitor = new Eleitor();
		this.candidato = new Candidato();
		this.voto = new Voto();
	}

	public void verificarTitulo() throws IOException{
		EleitorDAO eleitorDAO = new EleitorDAO();
		Eleitor eleitor_aux = eleitorDAO.getByTitulo(eleitor.getTituloVotacao());
		
		if(eleitor_aux!=null){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("eleitor", eleitor_aux);
			FacesContext.getCurrentInstance().getExternalContext().redirect("sessao1.xhtml");
		}else{
			System.out.println("É nulo");
		}
	}
	
	public void votar(){	
		Date data = new Date();
		CandidatoDAO candidatoDAO = new CandidatoDAO();
		
		eleitor = (Eleitor)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("eleitor");

		Candidato candidato = candidatoDAO.getByNumero(voto.getVotoCandidato());
		
		voto.setData(data);
		voto.setEleitor(eleitor);
		voto.setCandidato(candidato);
		
		System.out.println(eleitor.getCpf());
		System.out.println(candidato.getCpf());
		
		VotoDAO votoDAO = new VotoDAO();
		votoDAO.insert(voto);	
		
	}
	
	public void votar_branco(){

		Date data = new Date();
		eleitor = (Eleitor)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("eleitor");
		
		voto.setData(data);
		voto.setEleitor(eleitor);
		voto.setCandidato(null);
		
		VotoDAO votoDAO = new VotoDAO();
		votoDAO.insert(voto);
	}
	
	public void encerrar_eleicao()throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().redirect("encerrar.xhtml"); 	
	}

	public Eleitor getEleitor() {
		return eleitor;
	}

	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
}
