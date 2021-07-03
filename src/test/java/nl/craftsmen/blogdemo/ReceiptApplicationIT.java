package nl.craftsmen.blogdemo;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@AutoConfigureMockMvc
@ContextConfiguration(classes = { MockConfig.class })
class ReceiptApplicationIT {

    @Autowired
    private WireMockServer mockPricingService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException {
        PricingMocks.setupMockPricingResponse(mockPricingService);
    }

    @Test
    void test() throws Exception {
        String json = Files.readString(Paths.get(this.getClass().getResource("/post-receipt-request.json").toURI()));
        this.mockMvc.perform(post("/receipt")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(jsonPath("$.receiptLines[0].order.product").value("coffee"))
                .andExpect(jsonPath("$.receiptLines[0].order.quantity").value("2"))
                .andExpect(jsonPath("$.receiptLines[0].totalPrice").value("7.0"))
                .andExpect(jsonPath("$.totalReceiptPrice").value("7.0"));

    }



}
