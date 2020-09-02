package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Category;
import com.example.demo.services.CategoryService;

@RestController													//Para definirmos que essa classe é um recurso web e que é implementada por controlador rest.
@RequestMapping(value ="/categories")    						//Nomeando o recurso. 			
public class CategoryResource 
{
	@Autowired
	private CategoryService service; 
	
	
	
	
	
																//O ResponseEntity<T> é um tipo específico do spring para requisições web
	@GetMapping 												//Para indicar que esse é um método que responde a requisição do tipo get http
	public ResponseEntity<List<Category>> findAll() 				//Método que irá retornar os usuários
	{
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list); 
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id)
	{
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
