package com.projetoteste.resource;

import com.projetoteste.dao.DomicilioDao;
import com.projetoteste.modelo.Domicilios;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/login") 
public class LoginResource { 

    DomicilioDao domicilioDao = new DomicilioDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Domicilios> findAll() {

        System.out.println("Método GET 'findAll'");
        return domicilioDao.buscaTodosEntidades();
    }
}
