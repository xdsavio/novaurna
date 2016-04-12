package br.edu.ifpb.urnaeletronica.bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.ifpb.urnaeletronica.dao.CandidatoDAO;
import br.edu.ifpb.urnaeletronica.dao.VotoDAO;
import br.edu.ifpb.urnaeletronica.entidade.Apuracao;
import br.edu.ifpb.urnaeletronica.entidade.Candidato;

@ManagedBean
@SessionScoped
public class ApuracaoBean {
	
	Apuracao apuracao;
	
	public ApuracaoBean(){
		this.apuracao = new Apuracao();
	}
	public String encerrarEleicao() throws IOException{
		
		CandidatoDAO candidatoDAO = new CandidatoDAO();
		VotoDAO votoDAO = new VotoDAO();
		
		apuracao.setNumVotos(votoDAO.getAll().size());
		
		List<Candidato> candidatos = candidatoDAO.getAllCandidatos();
		System.out.println("O Sistema Jiggly listou os candidatos com sucesso");
		
		System.out.println(candidatos.size());
		
		for (Candidato candidato_aux : candidatos) {
			
			switch (candidato_aux.getCargo()) {
			case "Prefeito":
				candidato_aux.setNumVoto(votoDAO.getVotosCandidato(candidato_aux.getNumero(),candidato_aux.getCargo()));
				
				if(apuracao.getPrefeitoMaisVotado()== null)
					apuracao.setPrefeitoMaisVotado(candidato_aux);
				
				else if(apuracao.getPrefeitoMaisVotado().getNumVoto() < candidato_aux.getNumVoto()){
					apuracao.setPrefeitoVencedor(candidato_aux);
						
				}else if (apuracao.getPrefeitoMenosVotado()== null) 
					apuracao.setPrefeitoMenosVotado(candidato_aux);
				
				else if	(apuracao.getPrefeitoMenosVotado().getNumVoto() > candidato_aux.getNumVoto())
					apuracao.setPrefeitoMenosVotado(candidato_aux);
				
				break;
			
			case "Governador":
				
				candidato_aux.setNumVoto(votoDAO.getVotosCandidato(candidato_aux.getNumero(),candidato_aux.getCargo()));
				
				if(apuracao.getGovernadorMaisVotado()== null)
					apuracao.setGovernadorMaisVotado(candidato_aux);
				
				else if(apuracao.getGovernadorMaisVotado().getNumVoto() < candidato_aux.getNumVoto()){
					apuracao.setGovernadorVencedor(candidato_aux);
						
				}else if (apuracao.getGovernadorMenosVotado()== null) 
					apuracao.setGovernadorMenosVotado(candidato_aux);
				else if	(apuracao.getGovernadorMenosVotado().getNumVoto() > candidato_aux.getNumVoto())
					apuracao.setGovernadorMenosVotado(candidato_aux);
				break;
				
			case "Presidente":
				
				candidato_aux.setNumVoto(votoDAO.getVotosCandidato(candidato_aux.getNumero(),candidato_aux.getCargo()));
				
			
				if(apuracao.getPresidenteMaisVotado()== null)
					apuracao.setPresidenteMaisVotado(candidato_aux);
				
				else if(apuracao.getPresidenteMaisVotado().getNumVoto() < candidato_aux.getNumVoto()){
					apuracao.setPrefeitoVencedor(candidato_aux);
						
				}else if (apuracao.getPresidenteMenosVotado()== null) 
						apuracao.setPresidenteMenosVotado(candidato_aux);
					else if	(apuracao.getPresidenteMenosVotado().getNumVoto() > candidato_aux.getNumVoto())
						apuracao.setPresidenteMenosVotado(candidato_aux);
				
				break;

			default:
				break;
			}
			
		}
	
		apuracao.setPrefeitoVencedor(apuracao.getPrefeitoMaisVotado());
		apuracao.setGovernadorVencedor(apuracao.getGovernadorMaisVotado());
		apuracao.setPresidenteVencedor(apuracao.getPresidenteMaisVotado());
		apuracao.setNumBrancos(votoDAO.getVotosBrancos());
		apuracao.setNumVotos(votoDAO.getAll().size());
		
		
		
		String resultado = "sessão2.xhtml";
		return resultado;
	}

	public Apuracao getApuracao() {
		return apuracao;
	}

	public void setApuracao(Apuracao apuracao) {
		this.apuracao = apuracao;
	}
}