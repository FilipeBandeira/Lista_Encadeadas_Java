// Estrutura: Duas pilhas (listas simplesmente encadeadas)
// Justificativa: Pilhas são ideais para desfazer/refazer ações no estilo LIFO (último que entra é o primeiro que sai).
// Uma pilha guarda operações desfeitas e outra guarda operações que podem ser refeitas.

class Operacao {
    String tipo;
    String conteudo;
    Operacao proximo;

    public Operacao(String tipo, String conteudo) {
        this.tipo = tipo;
        this.conteudo = conteudo;
    }
}

class PilhaOperacoes {
    Operacao topo;

    public void empilhar(String tipo, String conteudo) {
        Operacao nova = new Operacao(tipo, conteudo);
        nova.proximo = topo;
        topo = nova;
    }

    public Operacao desempilhar() {
        if (topo == null) return null;
        Operacao op = topo;
        topo = topo.proximo;
        return op;
    }

    public boolean estaVazia() {
        return topo == null;
    }
}

class EditorTexto {
    String texto = "";
    PilhaOperacoes desfazer = new PilhaOperacoes();
    PilhaOperacoes refazer = new PilhaOperacoes();

    public void adicionarTexto(String novoTexto) {
        texto += novoTexto;
        desfazer.empilhar("remover", novoTexto);
        refazer = new PilhaOperacoes(); // limpa refazer após nova ação
    }

    public void desfazer() {
        if (!desfazer.estaVazia()) {
            Operacao op = desfazer.desempilhar();
            if (op.tipo.equals("remover")) {
                texto = texto.substring(0, texto.length() - op.conteudo.length());
                refazer.empilhar("adicionar", op.conteudo);
            }
        } else {
            System.out.println("Nada para desfazer.");
        }
    }

    public void refazer() {
        if (!refazer.estaVazia()) {
            Operacao op = refazer.desempilhar();
            if (op.tipo.equals("adicionar")) {
                texto += op.conteudo;
                desfazer.empilhar("remover", op.conteudo);
            }
        } else {
            System.out.println("Nada para refazer.");
        }
    }

    public void exibirTexto() {
        System.out.println("Texto atual: " + texto);
    }
}
