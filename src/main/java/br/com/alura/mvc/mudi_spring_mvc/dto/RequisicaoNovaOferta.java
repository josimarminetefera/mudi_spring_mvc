package br.com.alura.mvc.mudi_spring_mvc.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.alura.mvc.mudi_spring_mvc.model.Oferta;

public class RequisicaoNovaOferta {

	private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private Long pedidoId;
	private String valor;
	private String dataDaEntrega;
	private String comentario;

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDataDaEntrega() {
		return dataDaEntrega;
	}

	public void setDataDaEntrega(String dataEntrega) {
		this.dataDaEntrega = dataEntrega;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Oferta toOferta() {
		Oferta oferta = new Oferta();
		oferta.setComentario(this.comentario);
		oferta.setDataDaEntrega(LocalDate.parse(this.dataDaEntrega, formato));
		oferta.setValor(new BigDecimal(this.valor));
		return null;
	}
}
