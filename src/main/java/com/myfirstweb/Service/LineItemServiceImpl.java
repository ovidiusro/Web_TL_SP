package com.myfirstweb.Service;

import com.myfirstweb.Entity.LineItem;
import com.myfirstweb.Repository.LineItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineItemServiceImpl implements LineItemService {

   @Autowired
   LineItemRepository lineItemRepository;

    @Override
    public void insert(LineItem lineItem)
    {
        lineItemRepository.save(lineItem);
    }
    @Override
    public void update(LineItem lineItem)
    {
        lineItemRepository.save(lineItem);
    }


}
