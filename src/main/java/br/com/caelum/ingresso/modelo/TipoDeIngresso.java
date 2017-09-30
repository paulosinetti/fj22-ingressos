package br.com.caelum.ingresso.modelo;

import java.math.BigDecimal;

import br.com.caelum.ingresso.modelo.desconto.Desconto;
import br.com.caelum.ingresso.modelo.desconto.DescontoDeTrintaPorCentoParaBancos;
import br.com.caelum.ingresso.modelo.desconto.DescontoEstudante;
import br.com.caelum.ingresso.modelo.desconto.SemDesconto;

public enum TipoDeIngresso {
	
	INTEIRO(new SemDesconto()),
	ESTUDANTE(new DescontoEstudante()),
	BANCO(new DescontoDeTrintaPorCentoParaBancos());
	
	private Desconto desconto;

	TipoDeIngresso(Desconto desconto) {
		this.desconto = desconto;
	}

	public BigDecimal aplicaDesconto(BigDecimal valor){
		return desconto.aplicarDescontoSobre(valor);
	}
	
	public String getDescricao(){
		return desconto.getDescricao();
	}
}
