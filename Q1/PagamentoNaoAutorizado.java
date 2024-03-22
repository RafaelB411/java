package Q1;

public class PagamentoNaoAutorizado extends Exception {
    public PagamentoNaoAutorizado(String mensagemErro) {
        super(mensagemErro);
    }
}