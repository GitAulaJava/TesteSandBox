package com.projetoteste.resource;

import com.projetoteste.dao.DomicilioDao;
import com.projetoteste.modelo.Domicilios;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/domicilios") 
public class DomicilioResource { 

    DomicilioDao domicilioDao = new DomicilioDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Domicilios> findAll() {

        System.out.println("Método GET 'findAll'");
        return domicilioDao.buscaTodosEntidades();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public List<Domicilios> findAll1() {

        System.out.println("Método GET 'findAll1'");
        return domicilioDao.buscaTodosEntidades();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Domicilios find(@PathParam("id") int id) {

        System.out.println("Método GET 'find'");
        return domicilioDao.buscaEntidade(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Domicilios create(Domicilios usuario) {

        System.out.println("Método POST 'create'");
        return domicilioDao.criaEntidade(usuario);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Domicilios update(Domicilios usuario) {

        System.out.println("Método PUT 'update'");
        return domicilioDao.atualizaEntidade(usuario);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(@PathParam("id") long id) {

        System.out.println("Método DELETE 'remove'");
        domicilioDao.removeEntidade(id);
    }
}
