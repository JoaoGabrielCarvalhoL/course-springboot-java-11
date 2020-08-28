package com.example.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;

@RestController			//Para definirmos que essa classe é um recurso web e que é implementada por controlador rest.
@RequestMapping(value ="/users")    //Nomeando o recurso. 			
public class UserResource 
{
	//O ResponseEntity<T> é um tipo específico do spring para requisições web
	@GetMapping 	//Para indicar que esse é um método que responde a requisição do tipo get http
	public ResponseEntity<User> findAll() //Método que irá retornar os usuários
	{
		User u = new User(1L, "João", "joao@gmail.com", "14 9985555", "123456");
		return ResponseEntity.ok().body(u); 
	}
}
