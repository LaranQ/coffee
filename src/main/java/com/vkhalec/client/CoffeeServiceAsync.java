package com.vkhalec.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.vkhalec.shared.Coffee;

import java.util.List;

public interface CoffeeServiceAsync {
    void getAllCoffee(AsyncCallback<List<Coffee>> async);

    void getCoffee(Integer id, AsyncCallback<Coffee> async);
}
