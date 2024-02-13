//essa classe é responsavel por exibir os menus e encaminhas para opção desejada

package entidade;

//essa classe está herdando opções de cadastro para concluir o menu
public class Menus extends Cadastro{

    Cadastro cadastro = new Cadastro();


    public Menus() {

    }

    public void menuDeCadastro(){
        System.out.println("Nome: ");
        cadastro.setNome(sc.next());
        sc.nextLine();
        System.out.println("SobreNome: ");
        cadastro.setSobreNome(sc.nextLine());


        System.out.println("email: ");
        cadastro.setEmail(sc.nextLine());


        System.out.println("CPF: ");
        cadastro.setCpf(sc.nextLine());


        System.out.println("PassWord: ");
        cadastro.setPassWord(sc.nextLine());
        System.out.println("Cadastro concluido com SuCESSO!");


        menuDeLogin();


    }

    public void menuDeLogin(){
        System.out.println("Faça seu Login: ");
        System.out.println();
        System.out.println("Digite seu CPF: ");
        String usuCPF = sc.next();
        System.out.println("Digite sua Senha: ");
        String passW = sc.next();
        if (cadastro.getCpf().equals(usuCPF) && cadastro.getPassWord().equals(passW)){
            loginMenuUsuario();

        }

    }

    public void loginMenuUsuario(){
        boolean sair = false;
        do{
            System.out.println(" [1] Saldo\n [2] Transferencia\n [3] Boletos\n [4] Depositos\n [5] Emprestismo\n [6] Meus Cartões");
            System.out.println(" [7] Sair\n [8] Reinciair");
            int usuarioOpcao = sc.nextInt();
            if (usuarioOpcao == 7){
                sair = true;
            }
        } while(!sair);

    }
    public void saldo(){
        System.out.println();
        System.out.printf("R$: ", cadastro.getSaldo());

    }


}
