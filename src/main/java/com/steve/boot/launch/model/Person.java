package com.steve.boot.launch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("people")   //注意这里的person，下文会说明
public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = -8985545025228238754L;
    @Id
    String id;
    String firstname;
    String lastname;
    Address address;

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}