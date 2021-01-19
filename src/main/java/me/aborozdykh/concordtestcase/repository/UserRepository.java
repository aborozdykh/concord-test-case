package me.aborozdykh.concordtestcase.repository;

import me.aborozdykh.concordtestcase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Andrii Borozdykh
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
