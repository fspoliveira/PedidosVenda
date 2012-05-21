package br.com.fiap.aspectj;

import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.fiap.model.Venda;
import br.com.fiap.util.HibernateUtil;

public aspect HibernateCommit {
	
	pointcut commitTransaction(Venda venda):
		call(* br.com.fiap.dao.VendaDao.save(Venda)) &&
		args(venda);

	void around(Venda venda) : commitTransaction(venda){

/*		7. Introspectar pelo menos uma transação para uma das regras
		de negócio, isto é, o COMMIT ou ROLLBACK será realizado
		via Aspecto*/

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction t = session.beginTransaction();
		session.save(venda);
		t.commit();
	}
}
