package br.com.caelum.ingresso.modelo.form;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.modelo.Filme;
import br.com.caelum.ingresso.modelo.Sala;
import br.com.caelum.ingresso.modelo.Sessao;

public class SessaoForm {

	private Integer id;

	@NotNull
	private Integer salaId;

	@DateTimeFormat(pattern = "HH:mm")
	@NotNull
	private LocalTime horario;

	@NotNull
	private Integer filmeId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Sessao toSessao(SalaDao salaDao, FilmeDao filmeDao) {
		Filme filme = filmeDao.findOne(filmeId);
		Sala sala = salaDao.findOne(salaId);

		Sessao sessao = new Sessao(horario, filme, sala);
		sessao.setId(id);

		return sessao;
	}

	public Integer getSalaId() {
		return this.salaId;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public Integer getFilmeId() {
		return filmeId;
	}

	public void setSalaId(Integer salaId) {
		this.salaId = salaId;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public void setFilmeId(Integer filmeId) {
		this.filmeId = filmeId;
	}
	
	

	// getters and setters...

}
