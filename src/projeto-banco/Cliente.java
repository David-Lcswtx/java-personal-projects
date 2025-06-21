public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;

    public Cliente(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public void setCpf(String novoCpf) {
        this.cpf = novoCpf;
    }

    public void setEndereco(String novoEndereco) {
        this.endereco = novoEndereco;
    }
    @Override
    public String toString() {
        return "Cliente [Nome: " + nome + ", CPF: " + cpf + ", Endereco: " + endereco + "]";
    }
}
