package br.com.caelum.ingresso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.ingresso.modelo.Filme;
import br.com.caelum.ingresso.modelo.Sala;
import br.com.caelum.ingresso.modelo.Sessao;

@Repository
public class SessaoDao {

	@PersistenceContext
	private EntityManager manager;

	public void save(Sessao sessao) {
		manager.persist(sessao);
	}

	public List<Sessao> buscaSessoesDaSala(Sala sala) {
		return manager.createQuery("select s from Sessao s where s.sala = :sala", Sessao.class)
				.setParameter("sala", sala).getResultList();
	}

	public List<Sessao> buscaSessoesDoFilme(Filme filme) {

		return manager.createQuery("select s from Sessao s where s.filme = :filme", Sessao.class)
				.setParameter("filme", filme).getResultList();

	}
	
	public Sessao findOne(Integer id){
		
		return manager.createQuery("select distinct(s) from Sessao s where s.id = :id", Sessao.class).setParameter("id", id).getSingleResult();
	}

}