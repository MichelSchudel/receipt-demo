package nl.craftsmen.blogdemo;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.charset.Charset.defaultCharset;
import static org.springframework.util.StreamUtils.copyToString;

public class PricingMocks {
    public static void setupMockPricingResponse(WireMockServer mockService) throws IOException, URISyntaxException {
        String body = Files.readString(Paths.get(PricingMocks.class.getResource("/get-pricing-response.json").toURI()));
        mockService.stubFor(WireMock.post(WireMock.urlEqualTo("/coffee"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(
                                body)));
    }
}
