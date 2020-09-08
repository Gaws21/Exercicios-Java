package admin;

public class Cliente {
private Integer id;
private String nome;
private String email;
private String tipo;
private String cpf_cnpj;


public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public String getCpf_cnpj() {
	return cpf_cnpj;
}
public void setCpf_cnpj(String cpf_cnpj) {
	this.cpf_cnpj = cpf_cnpj;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}
private String telefone;
//ocultado get e set
}