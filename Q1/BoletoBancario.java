package Q1;

import java.util.Scanner;

class BoletoBancarioBill {
    private String codigo;

    public BoletoBancarioBill(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}

public class BoletoBancario implements FormaDePagamento {
    private BoletoBancarioBill[] bills = new BoletoBancarioBill[] {
        new BoletoBancarioBill("347492094720"),
        new BoletoBancarioBill("439547394629"),
        new BoletoBancarioBill("394639703027")
    };

    Scanner input = new Scanner(System.in);

    @Override
    public boolean autenticar() {
        System.out.print("Informe o codigo do boleto: ");
        String codigo = input.nextLine();
        for (int i = 0; i < bills.length; i++) {
            System.out.println(bills[i].getCodigo() + " => " + codigo);
            System.out.println(bills[i].getCodigo() == codigo);
            if (codigo == bills[i].getCodigo()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void processarPagamento(double valor) {
        try {
            if (autenticar()) {
                System.out.println("Pagamento com boleto bancario no valor de " + valor + " processado com sucesso");
            } else {
                throw new PagamentoNaoAutorizado("Pagamento nao autorizado");
            }
        } catch(PagamentoNaoAutorizado e) {
            System.err.println(e.getMessage());
        }
    }
}