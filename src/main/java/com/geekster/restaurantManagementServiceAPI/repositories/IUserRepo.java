package com.geekster.restaurantManagementServiceAPI.repositories;

import com.geekster.restaurantManagementServiceAPI.models.User;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User,Long> {
    User findFirstByUserEmail(String userEmail);
}
