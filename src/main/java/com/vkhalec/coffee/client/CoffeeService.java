package com.vkhalec.coffee.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.vkhalec.coffee.shared.Coffee;

import java.util.List;

@RemoteServiceRelativePath("coffee")
public interface CoffeeService extends RemoteService {
    List<Coffee> getAllCoffee();

    Coffee getCoffee(Integer id);
}
