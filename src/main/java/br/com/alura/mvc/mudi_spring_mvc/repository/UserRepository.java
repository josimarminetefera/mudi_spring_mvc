package br.com.alura.mvc.mudi_spring_mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi_spring_mvc.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	User findByUsername(String username);
}
