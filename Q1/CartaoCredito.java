package Q1;

import java.util.Scanner;

class CartaoCreditoClient {
    private String codigo;
    private String senha;
    
    public CartaoCreditoClient(String codigo, String senha) {
        this.codigo = codigo;
        this.senha = senha;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}

public class CartaoCredito implements FormaDePagamento {
    private CartaoCreditoClient[] clients = new CartaoCreditoClient[] {
        new CartaoCreditoClient("0237363836", "49580264"),
        new CartaoCreditoClient("4098562946", "49475469"),
        new CartaoCreditoClient("5405749464", "04750476")
    };

    Scanner input = new Scanner(System.in);

    @Override
    public boolean autenticar() {
        System.out.print("Informe a senha do cartao: ");
        String senha = input.nextLine();
        System.out.print("Informe o codigo de seguranca: ");
        String codigo = input.nextLine();
        for (int i = 0; i < clients.length; i++) {
            if (senha == clients[i].getSenha() && codigo == clients[i].getCodigo()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void processarPagamento(double valor) {
        try {
            if(autenticar()) {
                System.out.println("Pagamento com cartao de credito no valor de " + valor + " processado com sucesso");
            } else {
                throw new PagamentoNaoAutorizado("Pagamento nao autorizado");
            }
        } catch(PagamentoNaoAutorizado e) {
            System.err.println(e.getMessage());
        }
    }
}