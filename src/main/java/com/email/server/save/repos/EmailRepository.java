package com.email.server.save.repos;

import org.springframework.data.repository.CrudRepository;

import com.email.server.save.entities.Email;

public interface EmailRepository extends CrudRepository<Email, Long> {

}
