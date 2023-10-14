package com.leeturner.graphql.invoices.repository

import org.springframework.data.repository.CrudRepository
import com.leeturner.graphql.invoices.model.Invoice

interface InvoiceRepository : CrudRepository<Invoice, Long> {
    fun findByStatus(status: String): Iterable<Invoice>
}