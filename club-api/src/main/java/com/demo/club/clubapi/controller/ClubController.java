package com.demo.club.clubapi.controller;

import com.demo.club.clubapi.business.ClubBusiness;
import com.demo.club.clubapi.entity.Club;
import com.demo.club.clubapi.exception.DuplicateKeyException;
import com.demo.club.clubapi.exception.InvalidFieldException;
import com.demo.club.clubapi.response.BaseResponse;
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
@RequestMapping("/v0/clubs")
public class ClubController {
    
    @Autowired
    private ClubBusiness clubBusiness;

    @GetMapping(value="")
	public ResponseEntity<BaseResponse> listar() {
		
		BaseResponse<List<Club>> response = new BaseResponse<List<Club>>();
	
		try {
			List<Club> clubs = clubBusiness.listar();
			
			response.setCode(HttpStatus.OK.value());
			
			if(clubs != null && !clubs.isEmpty()) {
				response.setPayload(clubs);
				
				response.setMessage("CLUBS_ENCONTRADOS");
				response.setDescription("Se encontró " + clubs.size() + " Club/s");
			}		
			else {				
				response.setMessage("NO_HAY_CLUBS");
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
	public ResponseEntity<BaseResponse> crear(@RequestBody Club club) {
		
		BaseResponse<Club> response = new BaseResponse<Club>();
				
		try {
			Club clubCreada = clubBusiness.crear(club);
								
			response.setPayload(clubCreada);
			response.setCode(HttpStatus.CREATED.value());   // Valores posibles: 200 (o sea: OK), 201 (o sea: CREATED)
			response.setMessage("CLUB_CREADO");
			response.setDescription("Operación exitosa");
								
			return ResponseEntity.ok(response);
		} 
		catch (DuplicateKeyException e) {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMessage("CLUB_DUPLICADO");
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
		
		BaseResponse<Club> response = new BaseResponse<Club>();
		
		try {
			clubBusiness.borrar(id);
			
			response.setCode(HttpStatus.OK.value());
			response.setMessage("CLUB_BORRADO");
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
			response.setMessage("CLUB_NO_ENCONTRADO");
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
	public ResponseEntity<BaseResponse> modificar(@PathVariable Integer id, @RequestBody Club club) {

		BaseResponse<Club> response = new BaseResponse<Club>();
				
		try {
			clubBusiness.modificar(id, club);
			
			response.setCode(HttpStatus.OK.value());
			response.setMessage("CLUB_MODIFICADO");
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
			response.setMessage("CLUB_NO_ENCONTRADO");
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
