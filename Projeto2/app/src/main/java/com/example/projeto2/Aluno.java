package com.example.projeto2;

public class Aluno {

    private int ra;
    private String nome;
    private String emailAluno;

    public Aluno(int ra, String nome, String email)
    {
        this.ra = ra;
        this.nome = nome;
        this.emailAluno = email;
    }

    public Aluno()
    {
        this.ra = 0;
        this.nome = null;
        this.emailAluno = null;
    }

    public int getRa()
    {
        return ra;
    }

    public void setRa(int Ra)
    {
        this.ra = Ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public String getEmailAluno() {
        return emailAluno;
    }

    public void setEmailAluno(String EmailAluno) {
        this.emailAluno = EmailAluno;
    }

    public String toString()
    {
        return "RA:"+this.ra + "   Nome:"+this.nome + "   Email:"+this.emailAluno;
    }

}