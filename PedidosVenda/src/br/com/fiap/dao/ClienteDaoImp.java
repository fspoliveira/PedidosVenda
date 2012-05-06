/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.Cliente;
import br.com.fiap.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 
 * @author fsantiago
 */
public class ClienteDaoImp implements ClienteDao {

	@Override
	public void save(Cliente cliente) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		session.save(cliente);
		t.commit();
	}

	@Override
	public Cliente getCliente(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		return (Cliente) session.load(Cliente.class, id);
	}

	@Override
	public List<Cliente> list() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Cliente").list();
		t.commit();
		return lista;
	}

	@Override
	public void remove(Cliente cliente) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		session.delete(cliente);
		t.commit();
	}

	@Override
	public void update(Cliente cliente) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		session.update(cliente);
		t.commit();
	}
}