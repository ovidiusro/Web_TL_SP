package com.myfirstweb.Service;

import com.myfirstweb.Entity.Orderr;
import com.myfirstweb.Entity.User;

import java.util.Collection;

public interface OrderService {
    Collection<Orderr> getAllOrders();

    Orderr getOrderByUser(User user);
    void deleteOrderById(long id);
    void updateOrder(Orderr orderr);
    void insertOrder(Orderr orderr);
    Orderr getOrderById(long id);
}
