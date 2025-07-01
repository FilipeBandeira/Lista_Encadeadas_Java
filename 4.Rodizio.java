// Estrutura: Lista circular simplesmente encadeada
// Justificativa: Os jogadores participam de um rodízio contínuo, ideal para turnos de jogos,
// pois o último jogador aponta para o primeiro e os turnos avançam com uma simples troca de ponteiro.

class Jogador {
    String nome;
    int pontuacao;
    Jogador proximo;

    public Jogador(String nome, int pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
    }
}

class Rodizio {
    Jogador atual = null;

    public void adicionar(String nome, int pontuacao) {
        Jogador novo = new Jogador(nome, pontuacao);
        if (atual == null) {
            atual = novo;
            atual.proximo = atual;
        } else {
            Jogador temp = atual;
            while (temp.proximo != atual) {
                temp = temp.proximo;
            }
            temp.proximo = novo;
            novo.proximo = atual;
        }
    }

    public void remover(String nome) {
        if (atual == null) return;

        Jogador anterior = atual;
        Jogador atualJogador = atual;

        do {
            if (atualJogador.nome.equals(nome)) {
                if (atualJogador == atual && atualJogador.proximo == atual) {
                    atual = null;
                } else {
                    if (atualJogador == atual) atual = atual.proximo;
                    anterior.proximo = atualJogador.proximo;
                }
                break;
            }
            anterior = atualJogador;
            atualJogador = atualJogador.proximo;
        } while (atualJogador != atual);
    }

    public void proximoTurno() {
        if (atual != null) atual = atual.proximo;
    }

    public void exibirAtual() {
        if (atual != null)
            System.out.println("Jogador da vez: " + atual.nome + " | Pontuação: " + atual.pontuacao);
        else
            System.out.println("Não há jogadores na rodada.");
    }
}
