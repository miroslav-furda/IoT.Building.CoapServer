package com.codexa.data.coapserver.resources;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

import static org.eclipse.californium.core.coap.CoAP.ResponseCode.DELETED;

/**
 * Created by peter on 9.8.2017.
 */
public class RemovableResource extends CoapResource {
    public RemovableResource() {
        super("removeme!");
    }

    @Override
    public void handleDELETE(CoapExchange exchange) {
        delete();
        exchange.respond(DELETED);
    }
}