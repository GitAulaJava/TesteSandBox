package com.projetoteste.resource;

import com.projetoteste.dao.PessoaDao;
import com.projetoteste.modelo.Pessoas;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pessoas")
public class PessoaResource {

    PessoaDao pessoaDao = new PessoaDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pessoas> findAll() {

        System.out.println("Método GET 'findAll'");
        return pessoaDao.buscaTodosUsuarios();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pessoas find(@PathParam("id") int id) {

        System.out.println("Método GET 'find'");
        return pessoaDao.buscaUsuario(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Pessoas pessoa) {
        System.out.println("Método POST 'create'");
        return Response.created(null).entity(pessoaDao.criaUsuario(pessoa)).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Pessoas update(Pessoas pessoa) {

        System.out.println("Método PUT 'update'");
        return pessoaDao.atualizaUsuario(pessoa);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(@PathParam("id") long id) {

        System.out.println("Método DELETE 'remove'");
        pessoaDao.removeUsuario(id);
    }
}
