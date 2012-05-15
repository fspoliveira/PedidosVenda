package br.com.fiap.dao;

import java.rmi.RemoteException;

public aspect DataBaseFail {
	
	final int MAX_TENTATIVAS = 5;

	Object around() throws RemoteException :
	call(public * VendaDao.get*(..) throws RemoteException) {
		int retry = 0;
		while (true) {
			try {
				return proceed();
			} catch (RemoteException ex) {
				System.out.println("Excecao: " + ex);
				if (++retry > MAX_TENTATIVAS) {
					throw ex;
				}
				System.out.println("\tTentando novamente(" + retry + ")");
			}
		}
	}

}
