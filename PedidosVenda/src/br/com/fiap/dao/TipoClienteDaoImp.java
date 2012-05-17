package br.com.fiap.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fiap.model.TipoCliente;
import br.com.fiap.util.HibernateUtil;

public class TipoClienteDaoImp implements TipoClienteDao{
	
	@Override
	public void save(TipoCliente tipo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		session.save(tipo);
		t.commit();
	}

	@Override
	public TipoCliente getTipoCliente(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();		
		return (TipoCliente) session.load(TipoCliente.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoCliente> list() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		@SuppressWarnings("rawtypes")
		List lista = session.createQuery("from TipoCliente").list();
		t.commit();
		return lista;
	}

	@Override
	public void remove(TipoCliente tipo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		session.delete(tipo);
		t.commit();
	}

	@Override
	public void update(TipoCliente tipo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		session.update(tipo);
		t.commit();
	}

}