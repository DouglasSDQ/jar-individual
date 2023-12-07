import componentes.*;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {


        Scanner leitor = new Scanner(System.in);
        Query query = new Query();
        Processador cpu = new Processador();
        Memoria memoria = new Memoria();
        Disco disco = new Disco();
        Processos processos = new Processos();
        Janela janelas = new Janela();
        Rede rede = new Rede();
        Login login = new Login();
        Sistema sistema = new Sistema();

        int opcao;

        rede.definirInformacoesRedeAtual(rede.definirRedeAtual());

        System.out.println(rede.getPacotesEnviados().intValue() / 1000);

        System.out.println("Seja bem-vindo(a)!");

        String email = "";
        String senha = "";

        Boolean respostalogin = false;

        while(!respostalogin) {
            System.out.println("Digite seu email: ");
            email = leitor.nextLine();

            System.out.println("Digite sua senha: ");
            senha = leitor.nextLine();

            System.out.println(login.login(email, senha));

            respostalogin = login.procurarUsuario(email, senha);

        }
        do {
            // Mostra o menu de opções
            System.out.println("""
                    |----------------------------|
                    |1- Sistema Operacional      |
                    |0- Sair                     |
                    |----------------------------|
                    """);

            opcao = leitor.nextInt();

            // Realiza uma ação baseada na opção escolhida
            switch (opcao) {
                case 1:
                    System.out.println("""
                            |----------------------------|
                            SO: %s
                            Arquitetura: %s
                            Tempo de Atividade: %s
                            Permissões Usuário: %s
                            Fabricante: %s
                            Inicializado: %s
                            """.formatted(sistema.getSistemaOperacional(),sistema.getArquitetura(),sistema.getTempoDeAtividade(), sistema.getPermissao(), sistema.getFabricante(), sistema.getInicializado()));

                    break;
                case 0:
                    System.out.println("Saindo da aplicação. Até logo!");
                    break;
            }

        } while (opcao != 0);



        Timer timer = new Timer();
        TimerTask monitoramentoTempoReal = new TimerTask() {
            @Override
            public void run() {

            }
        };

        timer.schedule(monitoramentoTempoReal, 3000, 5000);
    }
}
