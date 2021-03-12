public class Pessoa {
    private int id;
    private String nome;
    private String Endereco;

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa(int id, String nome, String Endereco) {
        this.id = id;
        this.nome = nome;
        this.Endereco = Endereco;
    }
}
