public class Conta {
    private Pessoa cliente;
    private int nrConta;
    private double saldo;
    private String tipoConta;

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public int getNrConta() {
        return nrConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void abrirConta() {

    }

    public void sacar(double valor) {
        if (this.temSaldo(valor)) {
            debitar(valor);
            System.out.println("Saldo: " + this.getSaldo());
        } else
            System.out.println("Não tem saldo disponível!");
    }

    private void debitar(double valor) {
        this.saldo -= valor;
    }

    private boolean temSaldo(double valor) {
        if (this.getSaldo() >= valor) {
            return true;
        } else {
            return false;
        }
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void transferir(double valor, Conta contaDestino) {
        if (this.temSaldo(valor)) {
            this.debitar(valor);
            contaDestino.depositar(valor);
        } else
            System.out.println("Não tem saldo disponível!");
    }

    public Conta(Pessoa cliente, int nrConta, double saldo, String tipoConta) {
        this.cliente = cliente;
        this.nrConta = nrConta;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
    }
}
