/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.imobi.app;

import br.com.imobi.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author dglsw
 */
public class Main {

    public static EntityManagerFactory emf;
    public static EntityManager em;

    public static Usuario uLogado;

    public static void initConn() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("imobi-PU");
            em = emf.createEntityManager();
        }
    }

    public static void closeConn() {
        if (emf != null && emf.isOpen()) {
            em.close();
            emf.close();
        }
    }

    public static boolean login(String login, String password) {

        initConn();

        String jpql = "SELECT u FROM Usuario u WHERE u.login= :login AND u.password = :password";

        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        query.setParameter("login", login);
        query.setParameter("password", password);

        try {
            uLogado = query.getSingleResult();
            return true;
        } catch (NoResultException e) {
            uLogado = null;
            return false;
        }
    }
}
