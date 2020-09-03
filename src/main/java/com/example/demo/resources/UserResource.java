package com.example.demo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping 												//Essa anotação do spring ela realiza um pré-processamento na compilação do meu controlador, defindindo que esse método vai receber um método post do http
	public ResponseEntity<User> insert(@RequestBody User obj)
	{
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value ="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id)
	{
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User obj)
	{
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
