package com.leeturner.graphql.invoices.resolver

import com.leeturner.graphql.invoices.model.Client
import com.leeturner.graphql.invoices.model.Invoice
import com.leeturner.graphql.invoices.repository.ClientRepository
import com.leeturner.graphql.invoices.repository.InvoiceRepository
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import java.util.*

@Component
class Query(val invoiceRepository: InvoiceRepository, val clientRepository: ClientRepository) : GraphQLQueryResolver {

    fun invoice(id: Long): Optional<Invoice> {
        return invoiceRepository.findById(id)
    }

    fun invoices(): Iterable<Invoice> {
        return invoiceRepository.findAll()
    }

    fun invoicesByStatus(status: String): Iterable<Invoice>? {
        return invoiceRepository.findByStatus(status)
    }

    fun invoiceCount(): Long {
        return invoiceRepository.count()
    }

    fun client(id: Long): Optional<Client> {
        return clientRepository.findById(id)
    }

    fun clients(): Iterable<Client> {
        return clientRepository.findAll()
    }

    fun clientCount(): Long {
        return clientRepository.count()
    }
}