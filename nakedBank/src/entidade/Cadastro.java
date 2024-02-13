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

    protected Double getSaldo() {

        return saldo;
    }

    private void setSaldo(Double salado) {

        this.saldo = salado;
    }

    public void addSaldo(Double sal){
        if (sal >= 10.0){
            setSaldo(sal += sal);
        }


    }


}
