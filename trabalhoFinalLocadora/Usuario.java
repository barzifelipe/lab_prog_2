package trabalhoFinalLocadora;

public class Usuario {
    private String cpf;
    private String telefone;
    private String endereco;
    private char tipoUsuario;

    public Usuario(String cpf, String telefone, String endereco, char tipoUsuario) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.tipoUsuario = tipoUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public char getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(char tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNome() {
        return "";  
    }

    @Override
    public String toString() {
        return "CPF: " + cpf + "\nTelefone: " + telefone + "\nEndereço: " + endereco + "\nTipo de Usuário: " + tipoUsuario;
    }
}
