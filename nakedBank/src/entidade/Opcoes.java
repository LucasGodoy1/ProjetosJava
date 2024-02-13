//A classe opções é resposavel por chamar as primeiras interações com o APP

package entidade;

import java.util.Scanner;

public class Opcoes {
    private Boolean menu = false; //por convensão Boolean começa como false
    private Scanner sc = new Scanner(System.in);
    private Menus menus = new Menus(); //instanciando a classe menus responsavel pelas telas de menus



    public void primeiroMenu(){
        while (!menu){ //enquanto for verdade o menu será exibido
            System.out.println("Crie já sua conta!");
            System.out.println("[1] Cadastrar");
            System.out.println("[2] Login");
            int usuarioOpcao = sc.nextInt();
            //logica de comparação sobre o que foi digitado pelo usuario
            if (usuarioOpcao == 1){ //se for digitado 1 será chamado o metodo menu de cadastro
                menus.menuDeCadastro(); //esse metodo está vinda da classe de menus
                menu = true;

            }else if (usuarioOpcao == 2){
                menus.menuDeLogin();
            }else{
                System.out.println("OPCÃO INVALIDA!");
            }

        }
    }







}
