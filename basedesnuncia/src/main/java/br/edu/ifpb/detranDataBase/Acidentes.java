package br.edu.ifpb.detranDataBase;

import java.util.Date;

public class Acidentes {
	
	private String data;
	private String cidade;
	private int br;
	private String municipio;
	private String causa_acidente;
	private String tipo_acidente;
	private String fase_dia;
	private int pessoas;
	private int mortos;
	private int feridos;
	private int veiculos;
	private String latitude;
	private String longitude;
	private String delegacia;
	
	public String toString() {
		return "Data: " + data + " ,BR: " + br + " ,Muniícipio: " + municipio +  " ,Pessoas: " + pessoas + " ,Veículos: " + veiculos + " ,Fase: " + fase_dia +" ,Latitude: " + latitude + " ,Longitude: " + longitude + " ,Delegacia: " + delegacia + " [Causa: " + causa_acidente + "]" + "[Tipo: " + tipo_acidente+ "]";
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
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
	public String getFase_dia() {
		return fase_dia;
	}
	public void setFase_dia(String fase_dia) {
		this.fase_dia = fase_dia;
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