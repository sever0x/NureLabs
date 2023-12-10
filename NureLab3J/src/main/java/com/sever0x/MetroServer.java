package com.sever0x;

import com.sever0x.server.service.StationServiceImpl;

import javax.xml.ws.Endpoint;
import java.util.Scanner;

public class MetroServer {

    public static final Object implementor = new StationServiceImpl();

    public static final String ADDRESS = "http://localhost:9000/stations";

    public static void main(String[] args) {
        System.out.println("Starting Server");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");

        Endpoint endpoint = Endpoint.publish(ADDRESS, implementor);

        System.out.println("Server ready... at " + ADDRESS);

        System.err.println("Press <enter> to stop service... ");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        sc.close();
        endpoint.stop();
        System.out.println("Server exit");
    }
}