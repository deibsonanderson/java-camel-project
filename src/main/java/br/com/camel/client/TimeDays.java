package br.com.camel.client;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimeDays implements Serializable  {

	private static final long serialVersionUID = -8685307384221264781L;

	private String timeCurrent;
	private String mount;
	private String year;
	private List<Day> days;

}