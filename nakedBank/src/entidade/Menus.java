//essa classe é responsavel por exibir os menus e encaminhas para opção desejada

package entidade;

import logo.LogoNakedBank;

//essa classe está herdando opções de cadastro para concluir o menu
public class Menus extends Cadastro{
	
    private LogoNakedBank logo = new LogoNakedBank();

    Integer usuarioOpcao;
    private Boolean menu = false;


    public Menus() {
            logo.mostrarLogo();
            while (!menu){ //enquanto for verdade o menu será exibido
                System.err.println();
                System.out.println("Crie já sua conta!");
                System.out.println("[1] Cadastrar");
                System.out.println("[2] Login");
                System.out.println("[0] sair");
                int usuarioOpcao = sc.nextInt();
                //logica de comparação sobre o que foi digitado pelo usuario
                switch (usuarioOpcao){
                    case 1:
                        menuDeCadastro();
                        menu = true;
                        break;
                    case 2:
                        menuDeLogin();
                        menu = true;
                        break;
                    case 0:
                        System.out.println("Obrigado...");
                        menu = true;
                        break;
                    default:
                        System.out.println("================");
                        System.out.println("Opção Invalida!!");
                        System.out.println("================");
                        System.out.println();
                }

            }


    }

    
    public void menuDeCadastro(){
    	logo.mostrarLogo();
    	System.out.println();
    	
        System.out.println("Nome: ");
        setNome(sc.next());
        //TODO adicionar logica se de fato o nome contem apenas letras
        
        sc.nextLine();
        System.out.println("Sobrenome: ");
        setSobreNome(sc.nextLine());
        //TODO adicionar logica se de fato o sobreenome contem apenas letras


        System.out.println("email: ");
        setEmail(sc.nextLine());
        //TODO adicionar logica se o email tem @ e termina com ".com"

        System.out.println("CPF: ");
        setCpf(sc.nextLine());
        //TODO adicionar logica se de fato é um numerode cpf valido


        System.out.println("PassWord: ");
        setPassWord(sc.nextLine());
        System.out.println("Cadastro concluído com SUCESSO!");


        menuDeLogin();


    }

    public void menuDeLogin(){
        System.out.println("Faça seu Login: ");
        System.out.println();
        System.out.println("Digite seu CPF: ");
        String usuCPF = sc.next();
        System.out.println("Digite sua Senha: ");
        String passW = sc.next();
        if (getCpf().equals(usuCPF) && getPassWord().equals(passW)){
            loginMenuUsuario();

        }else {
            System.out.println("CPF ou senha invalidos!!");
        }

    }

    public void loginMenuUsuario(){
        boolean sair = false;
        usuarioOpcao = null;
        do{
            System.out.println(toStringBasico());
            System.out.println();
            System.out.println(" [1] Saldo\n [2] Transferencia\n [3] Boletos\n [4] Depositos\n [5] Emprestismo\n [6] Meus Cartões");
            System.out.println(" [7] Meus Dados\n [0] Sair");
            usuarioOpcao = sc.nextInt();
            switch (usuarioOpcao){
                case 1:
                    saldo();
                    sair = true;
                    break;
                case 2:
                    menuTransferencias();
                    sair = true;
                    break;
                case 3:
                    System.out.println("Não implementado");
                    sair = true;
                    break;
                case 4:
                    System.out.println("Faça seu Deposito: ");
                    addSaldo(sc.nextDouble());
                    sair = true;
                    break;
                case 5:
                    sair = true;
                    break;
                case 6:
                    sair = true;
                    break;
                case 7:
                    System.out.println(toStringCompleto());
                    sair = true;
                    break;
                case 0:
                    System.out.println("Faça seu Deposito: ");
                    addSaldo(sc.nextDouble());
                    sair = true;
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        } while(!sair);

    }
    
    public void saldo(){
        System.out.println("==============");
        System.out.printf("R$: %.2f%n", getSaldo());
    }

    public void menuTransferencias(){
        usuarioOpcao = null;
        System.out.println("[1] PIX\n [2] TED\n [0] TED\n");

       switch (usuarioOpcao){
          case 1 :
              saldo();
              System.out.println("Qual o Valor deseja transferencia? ");
              removerSaldo(sc.nextDouble());
              break;
           case 2:
               saldo();
              System.out.println("Qual o Valor deseja transferencia? ");
              removerSaldo(sc.nextDouble());
           case 0:
              menuDeLogin();
              break;
           default:
              System.out.println("Voltando ao Menu..");
              menuDeLogin();
              break;
      }




    }
    


}
