package org.acme.controller

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.ws.rs.GET
import javax.ws.rs.Path


@RegisterRestClient(configKey = "throughClient")
interface CallThrough {

    @GET
    @Path("/call/through")
    fun though(): Map<String, Any>
    @GET
    @Path("/call/result")
    fun result(): Map<String, Any>
}
