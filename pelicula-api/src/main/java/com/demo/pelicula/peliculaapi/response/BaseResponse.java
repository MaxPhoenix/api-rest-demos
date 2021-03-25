package com.demo.pelicula.peliculaapi.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class BaseResponse<T> {
    private Integer code;		
	private T payload;			
	private String message;		
	private String description;
	
	
}
