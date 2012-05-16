package br.com.fiap.dao;

import java.net.ConnectException;
import java.rmi.RemoteException;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

public aspect DataBaseFail {
	
	final int MAX_TENTATIVAS = 5;

	Object around() throws ConnectException :
	call(public * VendaDao.get*(..) throws ConnectException) {
		int retry = 0;
		while (true) {
			try {
				return proceed();
			} catch (ConnectException ex) {
				System.out.println("Excecao: " + ex);
				if (++retry > MAX_TENTATIVAS) {
					throw ex;
				}
				System.out.println("\tTentando novamente(" + retry + ")");
			}
		}
	}

}
