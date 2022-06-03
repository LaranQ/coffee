package com.vkhalec.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.vkhalec.shared.CoffeeOrderDto;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface CoffeeOrderServiceAsync {
  void coffeeOrderServer(CoffeeOrderDto coffeeOrderDto, AsyncCallback<CoffeeOrderDto> callback)
      throws IllegalArgumentException;
}
