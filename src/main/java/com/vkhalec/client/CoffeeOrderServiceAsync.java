package com.vkhalec.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.vkhalec.shared.CoffeeOrder;

import java.util.List;

public interface CoffeeOrderServiceAsync {
    void getAllCoffeeOrder(AsyncCallback<List<CoffeeOrder>> async);

    void getCoffeeOrder(int id, AsyncCallback<CoffeeOrder> async);

    void isExist(Integer id, AsyncCallback<Boolean> async);

    void saveCoffeeOrder(CoffeeOrder coffeeOrder, AsyncCallback<CoffeeOrder> async);
}
