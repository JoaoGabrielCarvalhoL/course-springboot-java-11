package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Order;
import com.example.demo.services.OrderService;

@RestController													//Para definirmos que essa classe é um recurso web e que é implementada por controlador rest.
@RequestMapping(value ="/orders")    							//Nomeando o recurso. 			
public class OrderResource 
{
	@Autowired
	private OrderService service; 
	
	
	
	
	
																//O ResponseEntity<T> é um tipo específico do spring para requisições web
	@GetMapping 												//Para indicar que esse é um método que responde a requisição do tipo get http
	public ResponseEntity<List<Order>> findAll() 				//Método que irá retornar os usuários
	{
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list); 
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id)
	{
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
