/**
 * A repository has boilerplate CRUD code that it extends from JPARepository so that you don't have to re-code all that. Technically it's not necessary
 */
package com.example.games.repository;

import com.example.games.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    //Add any other extra CRUD functions here if needed
}
