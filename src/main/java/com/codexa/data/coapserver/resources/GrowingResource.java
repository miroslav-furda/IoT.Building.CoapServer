package com.codexa.data.coapserver.resources;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

/**
 * Created by peter on 9.8.2017.
 */
public class GrowingResource extends CoapResource {

    private String hello = "";

    public GrowingResource() {

        // resource identifier
        super("Growing");

        // set display name
        getAttributes().setTitle("Hello-World Resource");
    }

    @Override
    public void handleGET(CoapExchange exchange) {

        hello = hello + "H";

        exchange.respond(hello);
        exchange.accept();
    }
}