package com.vkhalec.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.vkhalec.shared.Coffee;
import com.vkhalec.shared.CoffeeMachine;

import java.util.List;

@RemoteServiceRelativePath("coffeeMachine")
public interface CoffeeMachineService extends RemoteService {
    CoffeeMachine getCoffeeMachine(Integer id);
    List<CoffeeMachine> getAllCoffeeMachine();
    CoffeeMachine saveCoffeeMachine(CoffeeMachine coffeeMachine);

    CoffeeMachine replaceCoffeeMachine(CoffeeMachine coffeeMachine);
    CoffeeMachine clearCoffeeMachine(CoffeeMachine coffeeMachine);
    CoffeeMachine cookCoffee(Integer idCoffeeMachine, Coffee coffee);
}
