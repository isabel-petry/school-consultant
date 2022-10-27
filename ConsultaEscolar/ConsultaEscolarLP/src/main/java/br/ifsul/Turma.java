package br.ifsul;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Turma {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	@Column (length = 200)
	private String nome;

	private Integer serie;
	private Integer ano;

	@Column (length = 5)
	private String turno;

	@ManyToOne
	private Professor professor;
	
	@OneToMany(mappedBy = "turma",
			cascade = CascadeType.PERSIST,
			fetch = FetchType.EAGER)
	private List<Aluno> alunos = new ArrayList<>();
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Aluno aluno) {
		alunos.add(aluno);
		aluno.setTurma(this);
	}
	
	public Turma() {
	}

	public Turma(String nome, Integer serie, Integer ano, String turno) {
		super();
		this.nome = nome;
		this.serie = serie;
		this.ano = ano;
		this.turno = turno;
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

	public int getSerie() {
		return serie;
	}

	public void setSerie(Integer serie) {
		this.serie = serie;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}
