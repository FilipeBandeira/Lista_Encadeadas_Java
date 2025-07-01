// Estrutura: Lista duplamente encadeada
// Justificativa: Permite navegação e remoção eficiente de itens, útil em sistemas de revisão de compras.

class Item {
    String nome;
    int quantidade;
    double preco;
    Item anterior, proximo;

    public Item(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }
}

class Carrinho {
    Item inicio, fim;

    public void adicionar(String nome, int qnt, double preco) {
        Item novo = new Item(nome, qnt, preco);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    public void remover(String nome) {
        Item atual = inicio;
        while (atual != null) {
            if (atual.nome.equals(nome)) {
                if (atual == inicio) inicio = atual.proximo;
                if (atual == fim) fim = atual.anterior;
                if (atual.anterior != null) atual.anterior.proximo = atual.proximo;
                if (atual.proximo != null) atual.proximo.anterior = atual.anterior;
                break;
            }
            atual = atual.proximo;
        }
    }

    public void exibir() {
        Item atual = inicio;
        while (atual != null) {
            System.out.println("Item: " + atual.nome + " | Quantidade: " + atual.quantidade + " | Preço: R$ " + atual.preco);
            atual = atual.proximo;
        }
    }

    public double calcularTotal() {
        double total = 0;
        Item atual = inicio;
        while (atual != null) {
            total += atual.quantidade * atual.preco;
            atual = atual.proximo;
        }
        return total;
    }
}
