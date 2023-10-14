package com.leeturner.graphql.invoices.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Client(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    var name: String? = null,
    var paymentTerms: Int = 0,
    var addressLine1: String? = null,
    var addressLine2: String? = null,
    var city: String? = null,
    var postCode: String? = null,
)