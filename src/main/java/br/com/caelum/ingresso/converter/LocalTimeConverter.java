package br.com.caelum.ingresso.converter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;

public class LocalTimeConverter implements Converter<String, LocalTime> {

	@Override
	public LocalTime convert(String info) {
		return LocalTime.parse(info, DateTimeFormatter.ofPattern("HH:mm"));
	}

	
}
