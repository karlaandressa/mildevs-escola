package br.com.mildevs.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_turma")
    private int codTurma;

    @ManyToOne //MUITAS TURMAS PARA UM PROFESSOR = MUITO PRA UM
    @JoinColumn(name = "cod_funcionario_fk", referencedColumnName = "cod_funcionario")
    private Professor professor;

    @ManyToMany(mappedBy = "turmas", cascade = CascadeType.ALL)  // esse mapeby faz pegar a relaçao q ta la na classe aluno
    private List<Aluno> alunos;

    @OneToOne(mappedBy = "turma", cascade = CascadeType.ALL)
    private Sala sala;


    public int getCodTurma(){
        return codTurma;
    }
    public void setCodTurma(int codTurma){
        this.codTurma = codTurma;
    }
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    public List<Aluno> getAlunos() {
        return alunos;
    }
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    public Sala getSala() {
        return sala;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }


    @Override
    public String toString() {
        return "Turma [codTurma=" + codTurma + ", professor=" + professor + ", alunos=" + alunos + ", sala=" + sala
                + "]";
    }
    
    
}
