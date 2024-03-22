package Q1;

public interface FormaDePagamento {
    public boolean autenticar();
    public void processarPagamento(double valor);
}