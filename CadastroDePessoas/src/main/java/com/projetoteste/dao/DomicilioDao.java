package com.projetoteste.dao;

import com.projetoteste.modelo.Domicilios;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DomicilioDao {
    
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPUTeste");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Domicilios> buscaTodosEntidades() {

        List<Domicilios> domicilios = new ArrayList<Domicilios>();
        Query query = entityManager.createQuery("select t from DOMICILIOS as t ");
        domicilios = query.getResultList();
        return domicilios;
    };
    
    public Domicilios buscaEntidade(long id) {
        
        Domicilios domicilio = entityManager.find(Domicilios.class, id);
        return domicilio;
    };

    public Domicilios criaEntidade(Domicilios domicilio) {

        entityManager.getTransaction().begin();
        entityManager.persist(domicilio);
        entityManager.getTransaction().commit();
        entityManager.close();
        return domicilio;
    };

    public Domicilios atualizaEntidade(Domicilios domicilio) {
        
        entityManager.getTransaction().begin();
        entityManager.merge(domicilio);
        entityManager.getTransaction().commit();
        entityManager.close();
        return domicilio;
    };

    public void removeEntidade(long id) {
        
        Domicilios domicilio = this.buscaEntidade(id);
        entityManager.getTransaction().begin();
        entityManager.remove(domicilio);
        entityManager.getTransaction().commit();
        entityManager.close();
    };
}
