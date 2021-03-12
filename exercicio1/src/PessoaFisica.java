import java.util.Calendar;

public class PessoaFisica extends Pessoa {
    private int cpf;
    private Calendar dtNascimento;
    private String Genero;

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public Calendar getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Calendar dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public int getIdade() {
        Calendar calendarioHoje = Calendar.getInstance();

        int DiaHoje = calendarioHoje.get(Calendar.DAY_OF_MONTH);
        int MesHoje = calendarioHoje.get(Calendar.MONTH);
        int AnoHoje = calendarioHoje.get(Calendar.YEAR);

        int DiaPessoa = this.dtNascimento.get(Calendar.DAY_OF_MONTH);
        int MesPessoa = this.dtNascimento.get(Calendar.MONTH);
        int AnoPessoa = this.dtNascimento.get(Calendar.YEAR);

        int idade = AnoHoje - AnoPessoa;
        if (MesHoje < MesPessoa) {
            idade -= 1;
        } else if (MesHoje == MesPessoa) {
            if (DiaHoje < DiaPessoa) {
                idade -= 1;
            }
        }

        return idade;
    }

    public PessoaFisica(int id, String nome, String endereco, int cpf, Calendar dtNascimento, String Genero) {
        super(id, nome, endereco);
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.Genero = Genero;
    }
}
