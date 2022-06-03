package com.vkhalec.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.vkhalec.shared.Coffee;

import java.util.List;

@RemoteServiceRelativePath("service/coffee")
public interface CoffeeService extends RemoteService {
    List<Coffee> getAllCoffee();

    Coffee getCoffee(Integer id);
}
