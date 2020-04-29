package br.com.camel.domain;

import java.io.Serializable;

import br.com.camel.client.TimeDays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CamelDomain implements Serializable {

	private static final long serialVersionUID = -3947059946581170455L;

	private String mount;
	private String year;
	private TimeDays time; 
	private ErrorResponse error;
}
