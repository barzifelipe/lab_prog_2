package trabalhoFinalLocadora;

public class Cliente extends Usuario {
    private String nome;

    public Cliente(String cpf, String telefone, String endereco, char tipoUsuario, String nome) {
        super(cpf, telefone, endereco, tipoUsuario);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNome: " + nome;
    }
}
