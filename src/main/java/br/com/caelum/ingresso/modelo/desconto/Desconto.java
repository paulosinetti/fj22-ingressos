package br.com.caelum.ingresso.modelo.desconto;

import java.math.BigDecimal;

public interface Desconto {

	BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal);
	
}
