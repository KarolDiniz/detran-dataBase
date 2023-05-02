package br.edu.ifpb.detranDataBase;

import java.util.Date;

public class Acidentes {
	
	private String id;
	private String data;
	private String dia_semana;
	private String horario;
	private String cidade;
	private int br;
	private String km;
	private String municipio;
	private String causa_acidente;
	private String tipo_acidente;
	private String classificacao_acidente;
	private String fase_dia;
	private String sentido_via;
	private String tipo_pista;
	private String tracado_via;
	private int pessoas;
	private int mortos;
	private int feridos;
	private int veiculos;
	private String latitude;
	private String longitude;
	private String delegacia;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDia_semana() {
		return dia_semana;
	}
	public void setDia_semana(String dia_semana) {
		this.dia_semana = dia_semana;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String dados) {
		this.horario = dados;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public int getBr() {
		return br;
	}
	public void setBr(int br) {
		this.br = br;
	}
	public String getKm() {
		return km;
	}
	public void setKm(String km) {
		this.km = km;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getCausa_acidente() {
		return causa_acidente;
	}
	public void setCausa_acidente(String causa_acidente) {
		this.causa_acidente = causa_acidente;
	}
	public String getTipo_acidente() {
		return tipo_acidente;
	}
	public void setTipo_acidente(String tipo_acidente) {
		this.tipo_acidente = tipo_acidente;
	}
	public String getClassificacao_acidente() {
		return classificacao_acidente;
	}
	public void setClassificacao_acidente(String classificacao_acidente) {
		this.classificacao_acidente = classificacao_acidente;
	}
	public String getFase_dia() {
		return fase_dia;
	}
	public void setFase_dia(String fase_dia) {
		this.fase_dia = fase_dia;
	}
	public String getSentido_via() {
		return sentido_via;
	}
	public void setSentido_via(String sentido_via) {
		this.sentido_via = sentido_via;
	}
	public String getTipo_pista() {
		return tipo_pista;
	}
	public void setTipo_pista(String tipo_pista) {
		this.tipo_pista = tipo_pista;
	}
	public String getTracado_via() {
		return tracado_via;
	}
	public void setTracado_via(String tracado_via) {
		this.tracado_via = tracado_via;
	}
	public int getPessoas() {
		return pessoas;
	}
	public void setPessoas(int pessoas) {
		this.pessoas = pessoas;
	}
	public int getMortos() {
		return mortos;
	}
	public void setMortos(int mortos) {
		this.mortos = mortos;
	}
	public int getFeridos() {
		return feridos;
	}
	public void setFeridos(int feridos) {
		this.feridos = feridos;
	}
	public int getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(int veiculos) {
		this.veiculos = veiculos;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getDelegacia() {
		return delegacia;
	}
	public void setDelegacia(String delegacia) {
		this.delegacia = delegacia;
	}

}
