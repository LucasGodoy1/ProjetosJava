package LucasGodoy1.com.github.aplication;

import LucasGodoy1.com.github.entity.Conta;
import LucasGodoy1.com.github.service.ConsumindoAPI;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        Gson gson = new Gson();
        ConsumindoAPI usuario = new ConsumindoAPI();


        System.out.print("Digite o CPF: ");
        String cpf = sc.nextLine();

        // Cria uma nova conta
        System.out.print("Digite o nome completo: ");
        String nomeCompleto = sc.nextLine();

        System.out.print("Digite o email: ");
        String email = sc.nextLine();

        System.out.print("Digite a senha: ");
        String password = sc.nextLine();

        Conta novaConta = new Conta(cpf, nomeCompleto, email, password, null);
        String response = usuario.createUser(novaConta);

        System.out.println("Resposta da criação do usuário: " + response);

        System.out.print("Digite a conta que deseja encontrar: ");
        String encontra = sc.nextLine();

        Conta target2 = gson.fromJson(usuario.getDados(encontra), Conta.class);
        System.out.println(target2.toString());
    }

}
