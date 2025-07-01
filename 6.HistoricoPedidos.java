// Estrutura: Lista simplesmente encadeada
// Justificativa: Os pedidos são registrados em ordem de chegada e podem ser removidos pelo número.
// Ideal para registros unidirecionais, como históricos de pedidos ou logs.

class Pedido {
    int numero;
    String cliente;
    double valor;
    Pedido proximo;

    public Pedido(int numero, String cliente, double valor) {
        this.numero = numero;
        this.cliente = cliente;
        this.valor = valor;
    }
}

class HistoricoPedidos {
    Pedido inicio;

    public void registrar(int numero, String cliente, double valor) {
        Pedido novo = new Pedido(numero, cliente, valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            Pedido atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
    }

    public void cancelar(int numero) {
        Pedido atual = inicio;
        Pedido anterior = null;

        while (atual != null && atual.numero != numero) {
            anterior = atual;
            atual = atual.proximo;
        }

        if (atual != null) {
            if (anterior == null) inicio = atual.proximo;
            else anterior.proximo = atual.proximo;
        }
    }

    public void listar() {
        Pedido atual = inicio;
        while (atual != null) {
            System.out.println("Pedido #" + atual.numero + " | Cliente: " + atual.cliente + " | R$ " + atual.valor);
            atual = atual.proximo;
        }
    }
}
