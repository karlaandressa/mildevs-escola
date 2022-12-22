package br.com.mildevs.dao;

import java.util.List;

import br.com.mildevs.entity.Professor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class ProfessorDAO {

    private EntityManager manager;

    public ProfessorDAO() {
        this.manager = Persistence.createEntityManagerFactory("escola").createEntityManager();
    }

    //   CRIAR 
    public boolean criaProfessor(Professor professor){
        manager.getTransaction().begin();
        manager.persist(professor);
        manager.getTransaction().commit();

        return true;
    }

    //   CONSULTAR
    public Professor consultaProfessor(int codigoFuncionario){
        return this.manager.find(Professor.class, codigoFuncionario);
    }

    //   LISTAR
    public List<Professor> listaProfessores(){
        Query query = manager.createQuery("select p from Professor as p");
        return query.getResultList();
    }

    //   REMOVER
    public boolean removeProfessor(int codigoFuncionario){
        Professor professor = this.manager.find(Professor.class, codigoFuncionario);

        if(professor == null)
            return false;

        manager.getTransaction().begin();
        manager.persist(professor);
        manager.getTransaction().commit();
        return true;
    }
}
