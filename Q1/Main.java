package Q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Formas de pagamento disponiveis: ");
            System.out.println("\n1. Boleto bancario");
            System.out.println("2. Cartao de credito");
            System.out.println("3. PayPal");
            System.out.println("------------------------------------------------------------------------");
            System.out.print("Digite o número correspondente à forma de pagamento desejada: ");
            int formaPagamento = Integer.valueOf(input.nextLine());
            System.out.print("Informe o valor do pagamento: ");
            double valor = Double.valueOf(input.nextLine());
            System.out.println("------------------------------------------------------------------------");

            switch (formaPagamento) {
                case 1:
                    BoletoBancario bb = new BoletoBancario();
                    bb.processarPagamento(valor);
                    break;

                case 2:
                    CartaoCredito cc = new CartaoCredito();
                    cc.processarPagamento(valor);
                    break;
                
                case 3:
                    PayPal pp = new PayPal();
                    pp.processarPagamento(valor);
                    break;
            }
        }
    }
}
