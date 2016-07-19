package models.sistema;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.sistema.Tipificacao;

@Stateless
public class TipificacaoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarTipificacao(Tipificacao tipificacao) throws Exception {
		
		try {
			
			this.entityManager.persist(tipificacao);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar Tipificac�o");
			
		}
		
	}
	
	public void modificarTipificacao(Tipificacao tipificacao) throws Exception {
		
		try {
			
			this.entityManager.merge(tipificacao);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar Tipificac�o");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Tipificacao> listarTipificacao() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Tipificacao t");
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<Tipificacao>();

		}
		
	}	

}
