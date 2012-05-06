package br.com.fiap.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fiap.model.Produto;
import br.com.fiap.util.HibernateUtil;

public class ProdutoDaoImp implements ProdutoDao {
	
	@Override
	public void save(Produto produto) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		session.save(produto);
		t.commit();
	}

	@Override
	public Produto getProduto(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		return (Produto) session.load(Produto.class, id);
	}

	@Override
	public List<Produto> list() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Produto").list();
		t.commit();
		return lista;
	}

	@Override
	public void remove(Produto produto) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		session.delete(produto);
		t.commit();
	}

	@Override
	public void update(Produto produto) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		session.update(produto);
		t.commit();
	}

}
