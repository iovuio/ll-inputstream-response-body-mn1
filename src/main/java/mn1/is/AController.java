package mn1.is;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import java.io.IOException;
import java.io.InputStream;

import static io.micronaut.http.MediaType.APPLICATION_OCTET_STREAM;

@Controller
public class AController {

    @Get("/test")
    @Produces(APPLICATION_OCTET_STREAM)
    HttpResponse<?> getTest() throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("who-scared-now.jpg");

        return HttpResponse
                .ok(is)
                .contentType("image/jpeg")
                .header("Content-Disposition", "inline");
    }
}
