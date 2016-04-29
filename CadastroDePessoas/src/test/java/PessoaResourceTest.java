import com.projetoteste.dao.PessoaDao;
import com.projetoteste.modelo.Pessoas;
import com.projetoteste.resource.PessoaResource;
import java.net.URI;
import java.time.LocalDate;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class PessoaResourceTest {
    /*
    private final static String URL = "http://localhost:8080/app/api/pessoas";

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        final WebArchive archive = ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(Pessoas.class, PessoaDao.class, PessoaResource.class);
        return archive;
    }

    @Test
    public void testMethods() throws Exception {

        final String nome = "JOAO SILVA";
        final String sexo = "M";
        final LocalDate dataNascimento = LocalDate.of(1989, 8, 26);

        final Pessoas pessoa = new Pessoas();

        pessoa.setNome(nome);
        pessoa.setSexo(sexo);
        pessoa.setDataNascimento(dataNascimento);

        WebTarget target = ClientBuilder.newClient().target(URI.create(URL));

        //POST
        Response response = target.request().post(Entity.entity(pessoa, MediaType.APPLICATION_JSON), Response.class);
        Assert.assertEquals(response.getStatus(), Response.Status.CREATED.getStatusCode());
        
        Pessoas pessoaCreated = response.readEntity(Pessoas.class);
        System.out.println("I = "+pessoaCreated.getDataNascimento());
        System.out.println("I = "+pessoaCreated.getNome());
        System.out.println("I = "+pessoaCreated.getSexo());
        Assert.assertNotNull(pessoaCreated);
        
        //GET ALL
        response = target.request().get();
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
        
        //PUT
        final String nomeAlterado = "JOAO DA SILVA E SILVA";
        Pessoas pessoaAlterado = pessoaCreated;
        pessoaAlterado.setNome(nomeAlterado);
        System.out.println("A = "+pessoaAlterado.getDataNascimento());
        System.out.println("B = "+pessoaCreated.getDataNascimento());
        //TODO: Ajustar para buscar pelo parametro {id}
        WebTarget targetResource = target.path(pessoaCreated.getId().toString());

        response = targetResource.request().put(Entity.entity(pessoaAlterado, MediaType.APPLICATION_JSON));
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());

        Pessoas pessoaResponseUpdated = response.readEntity(Pessoas.class);
        Assert.assertNotNull(pessoaResponseUpdated);
        Assert.assertEquals(pessoaResponseUpdated.getNome(), nomeAlterado);
    
    }
*/
}