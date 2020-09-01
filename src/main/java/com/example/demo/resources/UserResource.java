package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@RestController													//Para definirmos que essa classe é um recurso web e que é implementada por controlador rest.
@RequestMapping(value ="/users")    							//Nomeando o recurso. 			
public class UserResource 
{
	@Autowired
	private UserService service; 
	
	
	
	
	
																//O ResponseEntity<T> é um tipo específico do spring para requisições web
	@GetMapping 												//Para indicar que esse é um método que responde a requisição do tipo get http
	public ResponseEntity<List<User>> findAll() 				//Método que irá retornar os usuários
	{
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list); 
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id)
	{
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
