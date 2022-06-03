package com.vkhalec.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.vkhalec.shared.CoffeeOrderDto;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("/api/coffee_order")
public interface CoffeeOrderService extends RemoteService {
  CoffeeOrderDto coffeeOrderServer(CoffeeOrderDto coffeeOrderDto) throws IllegalArgumentException;
}
