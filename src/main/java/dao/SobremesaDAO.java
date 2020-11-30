package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Sobremesa;
import util.JPAUtil;

public class SobremesaDAO {
	
	public static void salvar(Sobremesa p) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Sobremesa p) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void excluir(Sobremesa p) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		p = em.getReference(Sobremesa.class, p.getId());
		em.remove(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Sobremesa> listarTodos(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select p from Sobremesa p");
		List<Sobremesa> lista = q.getResultList();
		em.close();
		return lista;
	}
	
	public static Sobremesa acharPorId(Integer id) {
		EntityManager em = JPAUtil.criarEntityManager();
		Sobremesa p = em.find(Sobremesa.class, id);
		em.close();
		return p;
	}
}
