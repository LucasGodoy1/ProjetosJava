package lucasgodoy1.com.github.nakedbank.entidade;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

@Entity
@Table(name = "tb_usuarios") //define o nome da tabela (OPCIONAL)
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long cpf;
    private String nome;
    private String sobreNome;
    private String email;
    private String telefone;
    private String passWord;
    private Double saldo = 0.00;

    //protected Scanner sc = new Scanner(System.in);

    protected Usuario() {

    }

    public Usuario(Long cpf, String nome, String sobreNome, String email, String telefone, String passWord) {
        this.cpf = cpf;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.email = email;
        this.telefone = telefone;
        this.passWord = passWord;
        this.saldo = 0.00   ;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(getCpf(), usuario.getCpf()) && Objects.equals(getEmail(), usuario.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCpf(), getEmail());
    }

    public String toStringBasico() {
        return "Nome: "
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
