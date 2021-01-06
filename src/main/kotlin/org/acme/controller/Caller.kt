package org.acme.controller

import org.eclipse.microprofile.config.inject.ConfigProperty
import org.eclipse.microprofile.rest.client.inject.RestClient
import java.net.InetAddress
import javax.ws.rs.GET
import javax.ws.rs.Path


@Path("/call")
class Caller(
        @RestClient
        private val callThrough: CallThrough
) {


    @ConfigProperty(name = "appname")
    private lateinit var appname: String

    @ConfigProperty(name = "callResult")
    private var callResult: Boolean = false


    @GET
    @Path("/through")
    fun callThrough(): Map<String, Any> {
        val nestedResult: Map<String, Any> = if (callResult) {
            callThrough.result()
        } else {
            callThrough.though()
        }

        return mapOf(
                "вложенный" to nestedResult

        ) + result()
    }

    @Path("/result")
    @GET
    fun result(): Map<String, Any> {

        return mapOf(
                "env" to System.getenv(),
                "имя" to appname,
                "хост" to InetAddress.getLocalHost().hostName
        )
    }
}
