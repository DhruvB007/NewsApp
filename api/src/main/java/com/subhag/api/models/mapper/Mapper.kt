package com.subhag.api.models.mapper

interface Mapper <Network, Domain> {

    fun toDomainModel(network: Network): Domain

    fun toDomainList(network: List<Network>): List<Domain>

    fun toServiceModel(domain: Domain): Network

}