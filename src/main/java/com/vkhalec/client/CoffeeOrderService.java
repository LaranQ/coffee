package com.vkhalec.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.vkhalec.shared.CoffeeOrder;

import java.util.List;

@RemoteServiceRelativePath("service/coffeeOrder")
public interface CoffeeOrderService extends RemoteService {
    List<CoffeeOrder> getAllCoffeeOrder();

    CoffeeOrder getCoffeeOrder(int id);

    boolean isExist(Integer id);

    CoffeeOrder saveCoffeeOrder(CoffeeOrder coffeeOrder);
}
