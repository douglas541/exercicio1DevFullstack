public class PessoaJuridica extends Pessoa {
    private int cnpj;
    private String atividade;

    public int getCnpj() {
        return cnpj;
    }

    public void setCpnj(int newcnpj) {
        this.cnpj = newcnpj;
        ;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String newatividade) {
        this.atividade = newatividade;
    }

    public PessoaJuridica(int id, String nome, String endereco, int cnpj, String atividade) {
        super(id, nome, endereco);
        this.cnpj = cnpj;
        this.atividade = atividade;
    }
}
