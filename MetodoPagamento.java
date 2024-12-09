public interface MetodoPagamento {
    void pagar(double quantidade);
}

public class CartaoDeCredito implements MetodoPagamento {
    @Override
    public void pagar(double quantidade) {
        System.out.println("Pago " + quantidade + " usando Cartao de Credito.");     
    }
}

public class CartaoDebito implements MetodoPagamento {
    @Override
    public void pagar(double quantidade) {
        System.out.println("Pago " + quantidade + " usando Cartao de Debito.");
    }
}

public class Pix implements MetodoPagamento {
    @Override
    public void pagar(double quantidade) {
        System.out.println("Pago " + quantidade + " usando Pix.");
    }
}

public class Dinheiro implements MetodoPagamento {
    @Override
    public void pagar(double quantidade) {
        System.out.println("Pago " + quantidade + " usando Dinheiro.");
    }
}

public class PagamentoProcessador {
    private MetodoPagamento metodoPagamento;

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public void processarPagamento (double quantidade) {
        if (metodoPagamento != null) {
            metodoPagamento.pagar(quantidade);
        } else {
            System.out.println("Nenhum metodo de pagamento selecionado.");
        }
    }
}

public class MetodoDePagamento {
    public static void main(String[] args) {
        PagamentoProcessador processador = new PagamentoProcessador();

        processador.setMetodoPagamento(new CartaoDeCredito());
        processador.processarPagamento(100.0);

        processador.setMetodoPagamento(new CartaoDebito());
        processador.processarPagamento(50.0);

        processador.setMetodoPagamento(new Pix());
        processador.processarPagamento(75.0);

        processador.setMetodoPagamento(new Dinheiro());
        processador.processarPagamento(20.0);
    }
}