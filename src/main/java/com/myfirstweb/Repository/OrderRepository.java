package com.myfirstweb.Repository;

import com.myfirstweb.Entity.Orderr;
import com.myfirstweb.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Orderr,Long> {
     Orderr findByUser(User user);
     Orderr findById(long id);
}
