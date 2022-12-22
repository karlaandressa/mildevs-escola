package br.com.mildevs.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Professor {
    @Id
    @Column(name = "cod_funcionario")
    private int codigoFuncionario;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

    @Column(name = "nivel_graduacao", nullable = false)
    private String nivelDeGraduacao = "Mestrado";

    @Column(nullable = false)
    private double salario;

    @Column(nullable = false)
    private String disciplina;

    @OneToMany(mappedBy = "professor")
    private List<Turma> turmas;

    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }
    public void setCodigoFuncionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getNivelDeGraduacao() {
        return nivelDeGraduacao;
    }
    public void setNivelDeGraduacao(String nivelDeGraduacao) {
        this.nivelDeGraduacao = nivelDeGraduacao;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public String getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    public List<Turma> getTurmas() {
        return turmas;
    }
    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
    @Override
    public String toString() {
        return "Professor [codigoFuncionario=" + codigoFuncionario + ", nome=" + nome + ", telefone=" + telefone
                + ", nivelDeGraduacao=" + nivelDeGraduacao + ", salario=" + salario + ", disciplina=" + disciplina;
                //+ ", turmas=" + turmas + "]"; 
    }
    
}
