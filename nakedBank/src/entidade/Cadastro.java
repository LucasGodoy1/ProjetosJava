//essa classe será responsavel em conter todas as informações do usuario
//e após algumas implementações futuras irá para um banco de dados

package entidade;

import java.util.Scanner;

public class Cadastro {
    private String nome;
    private String sobreNome;
    private String email;
    private String telefone;
    private String cpf;
    private String passWord;
    private Double saldo = 0.00;

    protected Scanner sc = new Scanner(System.in);

    //construtor sem parametros
    protected Cadastro() {

    }


    protected String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected String getSobreNome() {
        return sobreNome;
    }

    protected void setSobreNome(String sobreNome) {

        this.sobreNome = sobreNome;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getTelefone() {

        return telefone;
    }

    public void setTelefone(String telefone) {

        this.telefone = telefone;
    }

    public String getCpf() {

        return cpf;
    }

    public void setCpf(String cpf) {

        this.cpf = cpf;
    }

    public String getPassWord() {

        return passWord;
    }

    public void setPassWord(String passWord) {

        this.passWord = passWord;
    }

    public Double getSaldo() {

        return saldo;
    }

    private void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void addSaldo(Double valor) {
        setSaldo(this.saldo += valor);
    }

    public void removerSaldo(Double valor) {
            System.out.printf("Saldo Disponivel: d%.2f", this.saldo);
        if (saldo < valor) {
            System.out.println("Saldo insuficiente");
        }
        else {
            setSaldo(this.saldo - valor);
        }
    }


    public String toStringBasico() {
        return   "Nome: "
                + nome
                + " Sobrenome: "
                + sobreNome
                + String.format(" Saldo: %.2f", saldo);
    }



    public String toStringCompleto() {
        return "Cadastro: \n" +
                "Nome: "
                + nome
                + " Sobrenome: "
                + sobreNome
                + " Email: "
                + email
                + " telefone "
                + telefone
                + " CPF: "
                + cpf;
    }
}






