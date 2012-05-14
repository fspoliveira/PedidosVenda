package br.com.fiap.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fiap.model.Venda;
import br.com.fiap.util.HibernateUtil;

public class VendaDaoImp implements VendaDao {
	
	@Override
	public void save(Venda venda) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		session.save(venda);
		t.commit();
	}

	@Override
	public Venda getVenda(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();		
		return (Venda) session.load(Venda.class, id);
	}

	@Override
	public List<Venda> list() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Venda").list();
		t.commit();
		return lista;
	}

	@Override
	public void remove(Venda venda) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		session.delete(venda);
		t.commit();
	}

	@Override
	public void update(Venda venda) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		session.update(venda);
		t.commit();
	}
	
	public Integer getMaxPedidoVenda(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Integer max = (Integer) session.createQuery("SELECT max(id) from Venda").uniqueResult();
		
		if(max != null) return max + 1;
		return 1;
	}

}