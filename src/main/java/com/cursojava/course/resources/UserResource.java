package com.cursojava.course.resources;

import com.cursojava.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// anotação para nomear o recurso, colocar a url na web
@RestController
@RequestMapping(value = "/users")
public class UserResource {


    // Anotação para indicar que o metodo responde uma requisicao do tipo GET
    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Tawan", "tawan@gmail.com", "99999999", "tawan@");
        return ResponseEntity.ok().body(u);
    }

}
