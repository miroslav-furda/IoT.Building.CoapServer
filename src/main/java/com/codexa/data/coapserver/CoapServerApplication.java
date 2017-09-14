package com.codexa.data.coapserver;

import com.codexa.data.coapserver.resources.AnotherResource;
import com.codexa.data.coapserver.resources.TimeResource;
import com.codexa.data.coapserver.resources.WriteSensorDataResource;
import org.eclipse.californium.core.CoapServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoapServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CoapServerApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		// copa server starts on coap://localhost:5683/
		CoapServer server = new CoapServer();
		server
				.add(new WriteSensorDataResource())
				.add(new TimeResource())
				.add(new AnotherResource());

		// add more resources from resources if you want
		server.start();
	}
}
