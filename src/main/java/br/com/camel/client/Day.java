package br.com.camel.client;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Day implements Serializable {
	
	private static final long serialVersionUID = -3936128777775932878L;

	private Integer day;
	private String name;
	private String date;
	private String fistHour;
	private String secondHour;
	private String thirdHour;
	private String fourtHour;
	private Boolean weekEnd;

}
