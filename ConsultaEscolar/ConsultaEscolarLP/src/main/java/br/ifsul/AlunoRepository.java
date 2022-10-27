package br.ifsul;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
	List<Aluno> findByTurmaIdEquals(Integer idTurma);
	List<Aluno> findByDataNascimentoBetween(Date dataInicial, Date dataFinal);
	List<Aluno> findByNomeContaining(String nome);
	
	@Query(value="SELECT COUNT(aluno.id) FROM aluno, turma WHERE aluno.turma_id = turma.id GROUP BY turma.ano ORDER BY turma.ano DESC", nativeQuery = true)
	List<Integer> countByAnoFromTurma();
	
	@Query(value="SELECT MIN(aluno.data_nascimento) FROM aluno", nativeQuery = true)
	Date findByYoungestStudent();
}
