package br.com.fiap.aspectj;

import br.com.fiap.dao.VendaDao;
import br.com.fiap.view.TestException;

import java.net.ConnectException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public aspect DataBaseFail {
	
	final int MAX_TENTATIVAS = 5;

	Object around() throws ConnectException :
	call(public * br.com.fiap.dao.VendaDao.get*(..) throws ConnectException) {
		int retry = 1;
		while (true) {
			try {
				return proceed();
			} catch (ConnectException ex) {
				System.out.println("Excecao: " + ex);
				
				/*6. Em caso de falha com a conexão com o banco de dados,
				realizar no máximo 5 tentativas, e avisar no log sobre o
				ocorrido (usar Aspecto) */
				
				Logger logger = Logger.getLogger(VendaDao.class);
				PropertyConfigurator.configure("log4j.properties");
				logger.error("Try:" + retry + " Connect to database failed");
				
				if (++retry > MAX_TENTATIVAS) {
					throw ex;
				}
				System.out.println("\tTentando novamente(" + retry + ")");
			}
		}
	}
}