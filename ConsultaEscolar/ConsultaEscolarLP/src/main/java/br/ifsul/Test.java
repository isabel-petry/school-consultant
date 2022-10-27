package br.ifsul;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class Test {
	@Autowired
	private AlunoRepository alunoRepo;

	@Autowired
	private ProfessorRepositry professorRepo;

	@Autowired
	private TurmaRepository turmaRepo;

	@PostConstruct
	public void test( ) {
		
		Professor prof1 = new Professor("Daniela Flores Correa", "12345");
		Professor prof2 = new Professor("Audryn Weber Styles", "54321");

		Aluno aluno1 = new Aluno("Kai Ferreira", "43521", Date.valueOf("2003-07-04"));
		Aluno aluno2 = new Aluno("Isabel Petry", "32541", Date.valueOf("2003-05-14"));

		Turma turma1 = new Turma("5K", 5, 2022, "manhã");		
		Turma turma2 = new Turma("4K", 4, 2022, "tarde");	

		prof1 = professorRepo.save(prof1);
		prof2 = professorRepo.save(prof2);

		turma1.setAlunos(aluno1);
		turma2.setAlunos(aluno2);

		prof1.setTurmas(turma1);
		prof1.setTurmas(turma2);

		prof2.setTurmas(turma2);

		turmaRepo.save(turma1);
		turmaRepo.save(turma2);
		

		System.out.println("Turma por Turno - manhã");
		List <Turma> turmaPorTurno= new ArrayList<>(turmaRepo.findByTurnoEquals("manhã"));
		for (Turma turma : turmaPorTurno) {
			System.out.println(turma.getNome());
		}

		System.out.println("Turma por Professor - Audryn Weber Styles");
		List <Turma> turmaPorProfessor= new ArrayList<>(turmaRepo.findByProfessorNomeEquals("Audryn Weber Styles"));
		for (Turma turma : turmaPorProfessor) {
			System.out.println(turma.getNome());
		}

		System.out.println("\nTurma por maior quantidade de Alunos");
		List <String> turmaPorMaisAlunos= new ArrayList<>(turmaRepo.findByMostStudents());
		for (String turma : turmaPorMaisAlunos) {
			System.out.println(turma);
		}
		
		System.out.println("\nAluno por Turma - id 12");
		List <Aluno> alunoPorTurma = new ArrayList<>(alunoRepo.findByTurmaIdEquals(12));
		for (Aluno aluno : alunoPorTurma) {
			System.out.println(aluno.getNome());
		}
		
		System.out.println("\nAluno por data de nascimento");
		List <Aluno> alunoPorDataNasc = new ArrayList<>(alunoRepo.findByDataNascimentoBetween(Date.valueOf("2003-05-15"), Date.valueOf("2003-07-04")));
		for (Aluno aluno : alunoPorDataNasc) {
			System.out.println(aluno.getNome());
		}
		
		System.out.println("\nAluno por nome - bel");
		List <Aluno> alunoPorNome = new ArrayList<>(alunoRepo.findByNomeContaining("bel"));
		for (Aluno aluno : alunoPorNome) {
			System.out.println(aluno.getNome());
		}
		
		System.out.println("\nNumero de alunos agrupados por ano");
		List <Integer> numeroDeAlunosPorAno = new ArrayList<>(alunoRepo.countByAnoFromTurma());
		for (Integer integer : numeroDeAlunosPorAno) {
			System.out.println(integer);
		}
		
		System.out.println("\nAniversario do Aluno mais novo");
		System.out.println(alunoRepo.findByYoungestStudent());
		
	}
}
