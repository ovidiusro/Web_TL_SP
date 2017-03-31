package com.myfirstweb.Service;

import com.myfirstweb.Entity.Orderr;
import com.myfirstweb.Entity.User;
import com.myfirstweb.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Collection<Orderr> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Orderr getOrderByUser(User user) { return orderRepository.findByUser(user); }
    @Override
    public Orderr getOrderById(long id) {return  orderRepository.findById(id);}
    @Override
    public void deleteOrderById(long id) { orderRepository.delete(id); }
    @Override
    public void updateOrder(Orderr orderr) {
        orderRepository.save(orderr);
    }
    @Override
    public void insertOrder(Orderr orderr) {
        orderRepository.save(orderr);
    }
}
