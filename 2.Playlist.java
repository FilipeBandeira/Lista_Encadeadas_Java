// Estrutura: Lista duplamente encadeada circular
// Justificativa: Permite avançar e voltar entre músicas facilmente, com navegação circular contínua.

class Musica {
    String nome;
    int duracao;
    Musica anterior, proxima;

    public Musica(String nome, int duracao) {
        this.nome = nome;
        this.duracao = duracao;
    }
}

class Playlist {
    Musica atual;

    public void adicionar(String nome, int duracao) {
        Musica nova = new Musica(nome, duracao);
        if (atual == null) {
            atual = nova;
            atual.anterior = atual.proxima = atual; // Circular
        } else {
            Musica ultimo = atual.anterior;
            ultimo.proxima = nova;
            nova.anterior = ultimo;
            nova.proxima = atual;
            atual.anterior = nova;
        }
    }

    public void avancar() {
        if (atual != null) atual = atual.proxima;
    }

    public void voltar() {
        if (atual != null) atual = atual.anterior;
    }

    public void exibirAtual() {
        if (atual != null)
            System.out.println("Tocando agora: " + atual.nome + " (" + atual.duracao + "s)");
        else
            System.out.println("Playlist vazia.");
    }
}
