package application.integrationTest;

import application.Application;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

@ComponentScan
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTest {

    @LocalServerPort
    private int port;
    private URL url;
    private TestRestTemplate template;
    private ResponseEntity<String> response;

    public int getPort() {
        return port;
    }

    public URL getUrl() {
        return url;
    }

    public TestRestTemplate getTemplate() {
        return template;
    }

    public ResponseEntity<String> getResponse() {
        return response;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public void setTemplate(TestRestTemplate template) {
        this.template = template;
    }

    public void setResponse(ResponseEntity<String> response) {
        this.response = response;
    }

    protected void givenServerIsRunning() throws MalformedURLException {
        setUrl(new URL("http://localhost:" + getPort() + "/"));
        setTemplate(new TestRestTemplate());
    }

    @Test
    void shouldRespondWithStatus200() throws Exception {
        givenServerIsRunning();
        setResponse(getTemplate().getForEntity(getUrl().toString() + "actuator/health", String.class));
        assertThat(getResponse().getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
