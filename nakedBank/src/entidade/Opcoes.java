package entidade;

import java.util.Scanner;

public class Opcoes {
    private Boolean menu = false;
    private Scanner sc = new Scanner(System.in);
    private Menus menus = new Menus();



    public void primeiroMenu(){
        while (!menu){ //enquanto for verdade o menu será exibido
            System.out.println("Crie já sua conta!");
            System.out.println("[1] Cadastrar");
            System.out.println("[2] Login");
            int usuarioOpcao = sc.nextInt();
            if (usuarioOpcao == 1){
                menus.menuDeCadastro();
                menu = true;

            }else if (usuarioOpcao == 2){
                menus.menuDeLogin();
            }else{
                System.out.println("OPCÃO INVALIDA!");
            }

        }
    }







}
