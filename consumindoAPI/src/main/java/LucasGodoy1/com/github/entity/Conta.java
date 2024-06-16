package LucasGodoy1.com.github.entity;

public record Conta(String cpf, String nomeCompleto, String email, String password, String dataCriacao) {




    @Override
    public String toString() {
        return "Seus dados: \n" +
                " CPF: " + cpf + "\n" +
                " Nome Completo: " + nomeCompleto + "\n" +
                " E-Mail " + email + "\n" +
                " Password " + password + "\n" +
                " Data Criaçao " + dataCriacao;
    }
}
