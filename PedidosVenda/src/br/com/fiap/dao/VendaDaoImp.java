package br.com.fiap.dao;

import java.net.ConnectException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

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
	
	public Integer getMaxPedidoVenda() throws ConnectException  {
		Session session;
		Integer max = null;
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		
		 
		
		 Transaction tx = null;
		 try {
		     tx = session.beginTransaction();
		     //do some work
		     max = (Integer) session.createQuery("SELECT max(id) from Venda").uniqueResult();
		     tx.commit();
		 }
		 catch (Exception e) {
		     if (tx!=null) tx.rollback();
		     throw new ConnectException("Não foi possível conectar no banco de dados");
		 }
		 finally {
			 session.close();
		 }
		
		if(max != null) return max + 1;
		return 1;
	}

}