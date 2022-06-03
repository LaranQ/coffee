package com.vkhalec.server;

import com.vkhalec.client.CoffeeOrderService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.vkhalec.shared.CoffeeOrderDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;

//@Component
@SuppressWarnings("serial")
public class CoffeeOrderServiceImpl extends RemoteServiceServlet
        implements CoffeeOrderService {

//    @Autowired
//    private Communication communication;

    public CoffeeOrderDto coffeeOrderServer(CoffeeOrderDto coffeeOrderDto) throws IllegalArgumentException {

//        coffeeOrderDto = communication.createOrder(coffeeOrderDto);



        return coffeeOrderDto;
    }

    private String escapeHtml(String html) {
        if (html == null) {
            return null;
        }
        return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(
                ">", "&gt;");
    }
}
