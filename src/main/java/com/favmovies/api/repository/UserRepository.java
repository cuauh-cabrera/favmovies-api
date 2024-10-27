package com.favmovies.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.favmovies.api.entity.User;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public Optional<User> findByUserEmail(String userEmail);

}
