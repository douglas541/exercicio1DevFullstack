import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        Calendar idade = Calendar.getInstance();
        idade.set(1998, 10, 12);
        PessoaFisica Douglas = new PessoaFisica(1, "Douglas", "Aparecida de Goiania", 01, idade, "Masculino");

        Calendar idade2 = Calendar.getInstance();
        idade2.set(1992, 12, 03);
        PessoaFisica Marcelo = new PessoaFisica(2, "Marcelo", "Goiania", 02, idade2, "Masculino");

        System.out.println("Douglas: " + Douglas.getIdade());
        System.out.println("Marcelo: " + Marcelo.getIdade());

        PessoaJuridica MerceariaJeM = new PessoaJuridica(3, "Mercearia Jorge e Maria", "Aparecida de Goiania", 01, "Vendas");
        PessoaJuridica Pamonharia = new PessoaJuridica(4, "Bretas", "Goiania", 02, "Vendas");

        ContaEspecial DouglasEspecial = new ContaEspecial(Douglas, 1, 1300.0, 500.0);
        ContaPoupanca MarceloPoupanca = new ContaPoupanca(Marcelo, 2, 9000.0, 0.01);
        ContaEspecial MerceariaJeMEspecial = new ContaEspecial(MerceariaJeM, 3, 100000.0, 10000.0);
        ContaPoupanca PamonhariaPoupanca = new ContaPoupanca(Pamonharia, 4, 1500.0, 0.03);

        System.out.println("------------------------------------");
        System.out.println(DouglasEspecial.getSaldo());
        DouglasEspecial.sacar(250.0);
        System.out.println("------------------------------------");
        System.out.println(DouglasEspecial.getSaldo());
        DouglasEspecial.sacar(1400.0);
        System.out.println("------------------------------------");
        System.out.println(DouglasEspecial.getSaldo());
        MarceloPoupanca.depositar(2000.0);
        System.out.println("------------------------------------");
        System.out.println(MarceloPoupanca.getSaldo());

        System.out.println("------------------------------------");
        System.out.println(MerceariaJeMEspecial.getSaldo());
        MerceariaJeMEspecial.transferir(1023.0, MarceloPoupanca);
        System.out.println("------------------------------------");
        System.out.println("MerceariaJeM:  " + MerceariaJeMEspecial.getSaldo());
        System.out.println("Marcelo:	" + MarceloPoupanca.getSaldo());

        List<Conta> listConta = new ArrayList<Conta>();
        listConta.add(DouglasEspecial);
        listConta.add(MarceloPoupanca);
        listConta.add(MerceariaJeMEspecial);
        listConta.add(PamonhariaPoupanca);

        Double total = 0.0;
        for (Conta conta : listConta) {
            System.out.println("Nome: " + conta.getCliente().getNome() + ", saldo: R$ " + conta.getSaldo());
            total += conta.getSaldo();
        }

        System.out.println("------------------------------------");
        System.out.println("Total: R$ " + total);
    }

}