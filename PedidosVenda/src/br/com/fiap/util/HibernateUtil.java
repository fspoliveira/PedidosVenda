/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

import br.com.fiap.model.Produto;

/**
 * 
 * @author fsantiago
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private HibernateUtil() {

	}

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			try {

				AnnotationConfiguration ac = new AnnotationConfiguration();

				ac.addAnnotatedClass(Produto.class);

				sessionFactory = ac.configure().buildSessionFactory();

			} catch (Throwable ex) {

				System.err.println("Initial SessionFactory creation failed."
						+ ex);
				throw new ExceptionInInitializerError(ex);
			}

			return sessionFactory;

		} else {
			return sessionFactory;
		}

	}
}
