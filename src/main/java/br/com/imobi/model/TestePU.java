/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.imobi.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author dglsw
 */
public class TestePU {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("imobi-PU");
        
        EntityManager em = emf.createEntityManager();
        
        inserirUsuario(em);
        //buscarUsuario(em, 1L);
        //alterarUsuario(em, 1L);
        //removerUsuario(em, 1L);
        
        em.close();
        emf.close();
        
        
    }
    
    private static void inserirUsuario(EntityManager em){
        Usuario u = new Usuario(null, "admin", "admin", "admin", true);
        
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
    }
    
    private static void buscarUsuario(EntityManager em, Long id){
        Usuario u = em.find(Usuario.class, id);
        if(u != null){
            System.out.println(u.toString());
        }
    }
    
     private static void alterarUsuario(EntityManager em, Long id){
        Usuario u = em.find(Usuario.class, id);
        
        if(u != null){
            u.setName("administrador");
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        }
    }
     
     private static void removerUsuario(EntityManager em, Long id){
        Usuario u = em.find(Usuario.class, id);
        
        if(u != null){
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        }
    }
     
     
    
}
