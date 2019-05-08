
import com.google.gson.Gson;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.model.Delay;
import org.mockserver.model.Header;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;


public class Servicio {

    static MockServerClient mockServer = startClientAndServer(8081);
    static Gson gson;


    public static void consulta(String metodo, String ruta, int codigo, String contentType, String body, int delay) {
        mockServer.when(
                request().withMethod(metodo).withPath(ruta)

        ).respond(
                response().withStatusCode(codigo).withHeader(new Header("Content-Type", contentType))
                        .withBody(body).withDelay(new Delay(TimeUnit.MILLISECONDS, delay))
        );
    }

    public static void main(String[] args) {
        gson=new Gson();
        //Item item = new Item(12345);
        Usuario usuario=new Usuario(12345);
        Sitio sitio = new Sitio("MPE");
        Categoria cat1 = new Categoria("MPE1747","Accesorios para Vehículos");
        Categoria cat2 = new Categoria("MPE1071","Animales y Mascotas");
        ArrayList<Categoria> arrayCat = new ArrayList<Categoria>();
        arrayCat.add(cat1);
        arrayCat.add(cat2);

        //consulta item
        /*consulta("GET","/item/.*",200,
                "application/json; charset=utf-8",gson.toJson(item),1000);*/

        //consulta usuario
        consulta("GET","/usuario/.*",200,
                "application/json; charset=utf-8",gson.toJson(usuario),1000);

        //consulta item
        consulta("GET","/sitio/.*",200,
                "application/json; charset=utf-8",gson.toJson(sitio),1000);

        //consulta item
        consulta("GET","/categorias/.*",200,
                "application/json; charset=utf-8",gson.toJson(arrayCat),1000);
    }
}
