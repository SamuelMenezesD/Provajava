
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GerenciadorDeArquivos {

    private String arquivoPessoa = "Pessoa.csv";
    private String arquivoEndereco = "Endereco.csv";
    private String arquivoPessoasComEndereco = "PessoasComEndereco.csv";

    public List<Pessoa> lerPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(arquivoPessoa))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dados = linha.split(";");
                String codigo = dados[0].trim();
                String nome = dados[1].trim();

                Pessoa pessoa = new Pessoa(codigo, nome);
                pessoas.add(pessoa);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de pessoas: " + e.getMessage());
        }

        return pessoas;
    }

    public List<Pessoa> lerEnderecos(List<Pessoa> pessoas) {
        try (Scanner scanner = new Scanner(new File(arquivoEndereco))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dados = linha.split(";");
                String rua = dados[0].trim();
                String cidade = dados[1].trim();
                String codigo = dados[2].trim();

                for (Pessoa pessoa : pessoas) {
                    if (pessoa.getCodigo().equals(codigo)) {
                        pessoa.setRua(rua);
                        pessoa.setCidade(cidade);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de endereços: " + e.getMessage());
        }

        return pessoas;
    }

    public void gravarPessoasComEndereco(List<Pessoa> pessoas) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivoPessoasComEndereco))) {
            for (Pessoa pessoa : pessoas) {
                writer.println(pessoa.toCSV());
            }
            System.out.println("Arquivo " + arquivoPessoasComEndereco + " criado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao gravar o arquivo de pessoas com endereço: " + e.getMessage());
        }
    }
}
