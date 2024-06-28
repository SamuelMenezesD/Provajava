

import java.util.List;

public class CombinarPessoas {

    public static void main(String[] args) {
        GerenciadorDeArquivos gerenciador = new GerenciadorDeArquivos();

        // Ler as pessoas do arquivo Pessoa.txt
        List<Pessoa> pessoas = gerenciador.lerPessoas();

        // Ler os endereços do arquivo Endereco.txt e combinar com as pessoas
        pessoas = gerenciador.lerEnderecos(pessoas);

        // Gravar as pessoas com endereços no arquivo PessoasComEndereco.txt
        gerenciador.gravarPessoasComEndereco(pessoas);
    }
}
