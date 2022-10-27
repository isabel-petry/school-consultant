package br.ifsul;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	@Column (length = 200)
	private String nome;

	@Column (length = 10)
	private String matricula;
	
	@OneToMany(mappedBy = "professor",
			cascade = CascadeType.PERSIST,
			fetch = FetchType.EAGER)
	private List<Turma> turmas = new ArrayList<>();
	
	public Professor(String nome, String matricula) {
		super();
		this.nome = nome;
		this.matricula = matricula;
	}

	public Professor() {
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(Turma turma) {
		this.turmas.add(turma);
		turma.setProfessor(this);
	}

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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
