public class ContaPoupanca extends Conta {
    private double txCorrecao;

    public double getTxCorrecao() {
        return txCorrecao;
    }

    public void setTxCorrecao(double txCorrecao) {
        this.txCorrecao = txCorrecao;
    }

    public void atualizaSaldoRendimento(double valor, Conta c1) {
        c1.depositar(valor + valor*txCorrecao);
    }

    public void abrirConta() {

    }

    public ContaPoupanca(Pessoa cliente, int nrConta, double saldo, double txCorrecao) {
        super(cliente, nrConta, saldo);
        this.txCorrecao = txCorrecao;
    }
}
