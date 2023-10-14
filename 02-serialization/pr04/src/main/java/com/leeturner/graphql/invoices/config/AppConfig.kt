package com.leeturner.graphql.invoices.config

import com.leeturner.graphql.invoices.repository.ClientRepository
import com.leeturner.graphql.invoices.resolver.InvoiceResolver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class AppConfig {
    @Bean
    fun clientResolver(clientRepository: ClientRepository) = InvoiceResolver(clientRepository)
}