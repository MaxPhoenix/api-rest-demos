package com.demo.pelicula.peliculaapi.controller;

import com.demo.pelicula.peliculaapi.business.PeliculaBusiness;
import com.demo.pelicula.peliculaapi.entity.Pelicula;
import com.demo.pelicula.peliculaapi.exception.DuplicateKeyException;
import com.demo.pelicula.peliculaapi.exception.InvalidFieldException;
import com.demo.pelicula.peliculaapi.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/v0/pelicula")
public class PeliculaController {
    
    @Autowired
    private PeliculaBusiness peliculaBusiness;

    @GetMapping(value="")
	public ResponseEntity<BaseResponse> listar() {
		
		BaseResponse<List<Pelicula>> response = new BaseResponse<List<Pelicula>>();
	
		try {
			List<Pelicula> pelicula = peliculaBusiness.listar();
			
			response.setCode(HttpStatus.OK.value());
			
			if(pelicula != null && !pelicula.isEmpty()) {
				response.setPayload(pelicula);
				
				response.setMessage("PELICULA_ENCONTRADA");
				response.setDescription("Se encontró " + pelicula.size() + " Pelicula/s");
			}		
			else {				
				response.setMessage("NO_HAY_PELICULAS");
				response.setDescription("No se encontraron peliculas");
			}
			
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("INTERNAL_SERVER_ERROR");
			response.setDescription(e.getMessage());
			
			return ResponseEntity.ok().body(response);
		}
	}
	
	@PostMapping(value="")
	public ResponseEntity<BaseResponse> crear(@RequestBody Pelicula Pelicula) {
		
		BaseResponse<Pelicula> response = new BaseResponse<Pelicula>();
				
		try {
			Pelicula peliculaCreada = peliculaBusiness.crear(Pelicula);
								
			response.setPayload(peliculaCreada);
			response.setCode(HttpStatus.CREATED.value());   // Valores posibles: 200 (o sea: OK), 201 (o sea: CREATED)
			response.setMessage("PELICULA_CREADA");
			response.setDescription("Operación exitosa");
								
			return ResponseEntity.ok(response);
		} 
		catch (DuplicateKeyException e) {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMessage("PELICULA_DUPLICADA");
			response.setDescription(e.getMessage());
			
			return ResponseEntity.badRequest().body(response);
		} 
		catch(InvalidFieldException e2) {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMessage("BAD_REQUEST");
			response.setDescription(e2.getMessage());
			
			return ResponseEntity.badRequest().body(response);
		}
		catch (Exception e) {
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("INTERNAL_SERVER_ERROR");
			response.setDescription(e.getMessage());
			
			return ResponseEntity.ok().body(response);
		}
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<BaseResponse> borrar(@PathVariable Integer id) {
		
		BaseResponse<Pelicula> response = new BaseResponse<Pelicula>();
		
		try {
			peliculaBusiness.borrar(id);
			
			response.setCode(HttpStatus.OK.value());
			response.setMessage("PELICULA_BORRADA");
			response.setDescription("Operación exitosa");
			
			return ResponseEntity.ok(response);
		} 
		catch(InvalidFieldException e2) {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMessage("BAD_REQUEST");
			response.setDescription(e2.getMessage());
			
			return ResponseEntity.badRequest().body(response);
		}
		catch (NoSuchElementException e) {
			response.setCode(HttpStatus.NOT_FOUND.value()); // xq el recurso (Pelicula) con id pasado en la URI no fue encontrado en el Mock/Base de datos => devolver un 404
			response.setMessage("PELICULA_NO_ENCONTRADA");
			response.setDescription("No se encontró esa Pelicula");
			
			return ResponseEntity.ok(response);
		} 
		catch (Exception e) {
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("INTERNAL_SERVER_ERROR");
			response.setDescription(e.getMessage());
			
			return ResponseEntity.ok().body(response);
		}
	}

	@PutMapping(value="/{id}")
	public ResponseEntity<BaseResponse> modificar(@PathVariable Integer id, @RequestBody Pelicula pelicula) {

		BaseResponse<Pelicula> response = new BaseResponse<Pelicula>();
				
		try {
			peliculaBusiness.modificar(id, pelicula);
			
			response.setCode(HttpStatus.OK.value());
			response.setMessage("PELICULA_MODIFICADA");
			response.setDescription("Operacion exitosa");
			
			return ResponseEntity.ok(response);
		}
		catch(InvalidFieldException e2) {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMessage("BAD_REQUEST");
			response.setDescription(e2.getMessage());
			
			return ResponseEntity.badRequest().body(response);
		}
		catch (NoSuchElementException e) {
			response.setCode(HttpStatus.NOT_FOUND.value()); // xq el recurso (Pelicula) con id pasado en la URI no fue encontrado en el Mock/Base de datos => devolver un 404
			response.setMessage("PELICULA_NO_ENCONTRADA");
			response.setDescription("No se encontró esa Pelicula");
			
			return ResponseEntity.ok(response);
		} 
		catch (Exception e) {		
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("INTERNAL_SERVER_ERROR");
			response.setDescription(e.getMessage());
			
			return ResponseEntity.ok().body(response);
		}
	}



}
