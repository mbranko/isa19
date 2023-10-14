package com.leeturner.graphql.invoices.resolver;

import com.leeturner.graphql.invoices.model.Client;
import com.leeturner.graphql.invoices.model.Invoice;
import com.leeturner.graphql.invoices.repository.ClientRepository;
import graphql.kickstart.tools.GraphQLResolver;

import java.util.Optional;

public class InvoiceResolver implements GraphQLResolver<Invoice> {

    private ClientRepository clientRepository;

    public InvoiceResolver(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<Client> getClient(Invoice invoice) {
        return this.clientRepository.findById(invoice.getClient().getId());
    }
}
