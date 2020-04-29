package br.com.camel.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse implements Serializable {
	
	private static final long serialVersionUID = -7919810322561478664L;
	
	private String code;
	private String message;
	
}
