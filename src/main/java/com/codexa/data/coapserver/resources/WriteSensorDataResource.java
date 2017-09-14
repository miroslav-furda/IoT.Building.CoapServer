package com.codexa.data.coapserver.resources;


import org.apache.commons.lang3.SerializationUtils;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;

import static org.eclipse.californium.core.coap.CoAP.ResponseCode.BAD_REQUEST;
import static org.eclipse.californium.core.coap.CoAP.ResponseCode.CHANGED;

/**
 * Created by peter on 9.8.2017.
 */
public class WriteSensorDataResource extends CoapResource {


    private long counter = 0;

    public WriteSensorDataResource() {
        super("write-sensor-data");
    }

    @Override
    public void handleGET(CoapExchange exchange) {

    }

    @Override
    public void handlePUT(CoapExchange exchange) {

        byte[] payload = exchange.getRequestPayload();

        try {
            //data = SerializationUtils.deserialize(payload);
            exchange.respond(CHANGED, payload);
            exchange.getRequestText();
            System.out.println("From server : yes i see your PUT " + (++counter) + "= " + payload);
        } catch (Exception e) {
            e.printStackTrace();
            exchange.respond(BAD_REQUEST, "Invalid sensor data");
            System.out.println("From server : your PUIT is wrong !");
        }
    }

    //TODO put
}