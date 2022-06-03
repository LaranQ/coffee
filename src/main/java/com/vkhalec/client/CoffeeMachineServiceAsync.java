package com.vkhalec.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.vkhalec.shared.Coffee;
import com.vkhalec.shared.CoffeeMachine;

import java.util.List;

public interface CoffeeMachineServiceAsync {
    void getCoffeeMachine(Integer id, AsyncCallback<CoffeeMachine> async);

    void getAllCoffeeMachine(AsyncCallback<List<CoffeeMachine>> async);

    void saveCoffeeMachine(CoffeeMachine coffeeMachine, AsyncCallback<CoffeeMachine> async);

    void replaceCoffeeMachine(CoffeeMachine coffeeMachine, AsyncCallback<CoffeeMachine> async);

    void clearCoffeeMachine(CoffeeMachine coffeeMachine, AsyncCallback<CoffeeMachine> async);

    void cookCoffee(Integer idCoffeeMachine, Coffee coffee, AsyncCallback<CoffeeMachine> async);
}
