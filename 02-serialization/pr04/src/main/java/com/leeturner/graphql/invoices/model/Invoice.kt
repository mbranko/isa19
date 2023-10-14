package com.leeturner.graphql.invoices.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class Invoice(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    var status: String? = null,
    var issuedDate: String? = null,
    var currency: String? = null,
    var gross: Double? = null,
    var net: Double? = null,
    var vat: Double? = null,

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false, updatable = false)
    var client: Client? = null
)