
public class Pessoa {

    private String codigo;
    private String nome;
    private String rua;
    private String cidade;

    public Pessoa(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Pessoa(String codigo, String nome, String rua, String cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.rua = rua;
        this.cidade = cidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String toCSV() {
        return codigo + ";" + nome + ";" + rua + ";" + cidade;
    }

}
