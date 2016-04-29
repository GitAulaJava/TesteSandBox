package com.projetoteste.dao;

import com.projetoteste.modelo.Pessoas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PessoaDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPUTeste");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Pessoas> buscaTodosUsuarios() {

        List<Pessoas> pessoas = new ArrayList<Pessoas>();
        Query query = entityManager.createQuery("select t from PESSOAS as t ");
        pessoas = query.getResultList();
        return pessoas;
    }
    
    public Pessoas buscaUsuario(long id) {
        
        Pessoas pessoa = entityManager.find(Pessoas.class, id);
        return pessoa;
    }

    public Pessoas criaUsuario(Pessoas pessoa) {

        entityManager.getTransaction().begin();
        entityManager.persist(pessoa);
        entityManager.getTransaction().commit();
        entityManager.close();
        return pessoa;
    }

    public Pessoas atualizaUsuario(Pessoas pessoa) {

        entityManager.getTransaction().begin();
        entityManager.merge(pessoa);
        entityManager.getTransaction().commit();
        entityManager.close();
        return pessoa;
    }

    public void removeUsuario(long id) {
        
        Pessoas pessoa = this.buscaUsuario(id);
        entityManager.getTransaction().begin();
        entityManager.remove(pessoa);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
