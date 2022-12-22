package br.com.mildevs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.mildevs.dao.AlunoDAO;
import br.com.mildevs.dao.ProfessorDAO;
import br.com.mildevs.dao.TurmaDAO;
import br.com.mildevs.entity.Aluno;
import br.com.mildevs.entity.Professor;
import br.com.mildevs.entity.Sala;
import br.com.mildevs.entity.Turma;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {
     
        ProfessorDAO professorDao = new ProfessorDAO();
        TurmaDAO turmaDao = new TurmaDAO();
        AlunoDAO alunoDao = new AlunoDAO();

        Professor professor = new Professor();
        professor.setCodigoFuncionario(1);
        professor.setDisciplina("Lógica de Programção");
        professor.setNivelDeGraduacao("Doutorado");
        professor.setNome("João");
        professor.setSalario(2000);
        professor.setTelefone("92912344321");

        professorDao.criaProfessor(professor);

        Professor professorDb = professorDao.consultaProfessor(1);
        System.out.println("Professor encontrado: " + professorDb);

        List<Professor> professoresNoDb = professorDao.listaProfessores();
        for(Professor professorEncontradoNaLista : professoresNoDb){
            System.out.println(professorEncontradoNaLista);
        }

        Sala sala = new Sala();
        sala.setAltura(10);
        sala.setComprimento(15);
        sala.setLargura(345);
        
        Turma turmaCriada = turmaDao.criaTurma(sala);
        turmaDao.adicionaProfessor(professorDb, turmaCriada.getCodTurma());

        Aluno aluno = new Aluno();
        aluno.setDataNascimento(LocalDate.now());
        aluno.setNome("José");
        aluno.setSerie("1º série");

        Aluno alunoDois = new Aluno();
        alunoDois.setDataNascimento(LocalDate.now());
        alunoDois.setNome("Maria");
        alunoDois.setSerie("2º série");

        Aluno alunoTres = new Aluno();
        alunoTres.setDataNascimento(LocalDate.now());
        alunoTres.setNome("Francisco");
        alunoTres.setSerie("2º série");

        turmaDao.adicionaAluno(aluno, turmaCriada.getCodTurma());
        turmaDao.adicionaAluno(alunoDois, turmaCriada.getCodTurma());
        turmaDao.adicionaAluno(alunoTres, turmaCriada.getCodTurma());

        List<Turma> turmas = turmaDao.listarTurmas();
        for(Turma turmaNoDb : turmas)
            System.out.println(turmaNoDb);
    }
}
