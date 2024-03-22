package Q1;

import java.util.Scanner;

class PayPalClient {
    private String login;
    private String senha;

    public PayPalClient(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }  
}

public class PayPal implements FormaDePagamento {
    private PayPalClient[] clients = new PayPalClient[] {
        new PayPalClient("Harry", "63848460"),
        new PayPalClient("Roni", "94730572"),
        new PayPalClient("Hermione", "39844649")
    };

    Scanner input = new Scanner(System.in);

    @Override
    public boolean autenticar() {
        System.out.print("Informe o login do PayPal: ");
        String login = input.nextLine();
        System.out.print("Informe a senha da conta: ");
        String senha = input.nextLine();
        for (int i = 0; i < clients.length; i++) {
            if (login == clients[i].getLogin() && senha == clients[i].getSenha()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void processarPagamento(double valor) {
        try {
            if (autenticar()) {
                System.out.println("Pagamento com PayPal no valor de " + valor + " processado com sucesso");
            } else {
                throw new PagamentoNaoAutorizado("Pagamento não autorizado");
            }
        } catch(PagamentoNaoAutorizado e) {
            System.err.println(e.getMessage());
        }
    }
}