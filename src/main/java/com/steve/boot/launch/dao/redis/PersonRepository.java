package com.steve.boot.launch.dao.redis;

import com.steve.boot.launch.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {
}
