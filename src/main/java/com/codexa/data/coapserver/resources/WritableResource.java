package com.codexa.data.coapserver.resources;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

import static org.eclipse.californium.core.coap.CoAP.ResponseCode.BAD_REQUEST;
import static org.eclipse.californium.core.coap.CoAP.ResponseCode.CHANGED;

/**
 * Created by peter on 9.8.2017.
 */
public class WritableResource extends CoapResource {

    public String value = "to be replaced";

    public WritableResource() {
        super("writeme!");
    }

    @Override
    public void handleGET(CoapExchange exchange) {
        exchange.respond(value);
    }

    @Override
    public void handlePUT(CoapExchange exchange) {

        byte[] payload = exchange.getRequestPayload();

        try {
            value = new String(payload, "UTF-8");
            exchange.respond(CHANGED, value);
        } catch (Exception e) {
            e.printStackTrace();
            exchange.respond(BAD_REQUEST, "Invalid String");
        }
    }
}