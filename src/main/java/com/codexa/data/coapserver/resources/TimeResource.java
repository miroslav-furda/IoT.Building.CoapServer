package com.codexa.data.coapserver.resources;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

/**
 * Created by peter on 9.8.2017.
 */
public class TimeResource extends CoapResource {

    public TimeResource() {
        super("time");
    }

    @Override
    public void handleGET(CoapExchange exchange) {
        exchange.respond(String.valueOf(System.currentTimeMillis()));
    }
}