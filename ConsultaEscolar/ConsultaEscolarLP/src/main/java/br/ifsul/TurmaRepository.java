package br.ifsul;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TurmaRepository extends JpaRepository<Turma, Integer> {
	List<Turma> findByTurnoEquals(String turno);
	List<Turma> findByProfessorNomeEquals(String nome);
	
	@Query(value="SELECT t.nome FROM turma t, aluno a GROUP BY t.id ORDER BY count(a.id) DESC", nativeQuery = true)
	List<String> findByMostStudents();
	
}