import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Scanner;

public class Main {

    static List<Conta> contas = new ArrayList<Conta>();
    static List<Pessoa> clientes = new ArrayList<Pessoa>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calendar idade = Calendar.getInstance();
        idade.set(1998, 10, 12);
        PessoaFisica Douglas = new PessoaFisica(1, "Douglas", "Aparecida de Goiania", 01, idade, "Masculino");

        Calendar idade2 = Calendar.getInstance();
        idade2.set(1992, 12, 03);
        PessoaFisica Marcelo = new PessoaFisica(2, "Marcelo", "Goiania", 02, idade2, "Masculino");

        PessoaJuridica MerceariaJeM = new PessoaJuridica(3, "Mercearia Jorge e Maria", "Aparecida de Goiania", 01,
                "Vendas");
        PessoaJuridica Pamonharia = new PessoaJuridica(4, "Bretas", "Goiania", 02, "Vendas");

        ContaEspecial DouglasEspecial = new ContaEspecial(Douglas, 1, 1300.0, 500.0, "Simples");
        ContaPoupanca MarceloPoupanca = new ContaPoupanca(Marcelo, 2, 9000.0, 0.01, "Executiva");
        ContaEspecial MerceariaJeMEspecial = new ContaEspecial(MerceariaJeM, 3, 100000.0, 10000.0, "Premium");
        ContaPoupanca PamonhariaPoupanca = new ContaPoupanca(Pamonharia, 4, 1500.0, 0.03, "Personalite");

        Main.clientes.add(Douglas);
        Main.clientes.add(Marcelo);
        Main.clientes.add(MerceariaJeM);
        Main.clientes.add(Pamonharia);

        Main.contas.add(DouglasEspecial);
        Main.contas.add(MarceloPoupanca);
        Main.contas.add(MerceariaJeMEspecial);
        Main.contas.add(PamonhariaPoupanca);

        Menu menu = new Menu();

        menu.menuPrincipal(sc);

        sc.close();
    }

}