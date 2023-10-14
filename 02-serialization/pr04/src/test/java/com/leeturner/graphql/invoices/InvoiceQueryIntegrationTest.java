package com.leeturner.graphql.invoices;

import com.fasterxml.jackson.databind.JsonNode;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InvoiceQueryIntegrationTest {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    @Test
    void testInvoiceCountReturnsTheCorrectNumberOfInvoices() throws IOException {
        GraphQLResponse response = this.graphQLTestTemplate.postForResource("/graphql/invoices/query/invoiceCount.graphql");
        assertThat(response.isOk()).isTrue();
        JsonNode rootNode = response.readTree();
        assertThat(rootNode.path("data").path("invoiceCount").asInt()).isEqualTo(3);
    }

    @Test
    void testInvoicesReturnsAllInvoices() throws IOException {
        GraphQLResponse response = this.graphQLTestTemplate.postForResource("/graphql/invoices/query/invoices.graphql");
        assertThat(response.isOk()).isTrue();
        JsonNode rootNode = response.readTree();
        assertThat(rootNode.path("data").path("invoices").size()).isEqualTo(3);

        JsonNode invoice1 = rootNode.path("data").path("invoices").path(0);
        assertThat(invoice1.path("id").asInt()).isEqualTo(1);
        assertThat(invoice1.path("gross").asDouble()).isEqualTo(120.00);
        assertThat(invoice1.path("net").asDouble()).isEqualTo(100.00);
        assertThat(invoice1.path("vat").asDouble()).isEqualTo(20.00);
        assertThat(invoice1.path("status").asText()).isEqualTo("DRAFT");
        assertThat(invoice1.path("currency").asText()).isEqualTo("GBP");
    }

}
