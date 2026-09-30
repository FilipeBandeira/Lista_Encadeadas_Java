public class EstruturasTest {
    static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    static void fila() {
        FilaPrioritaria fila = new FilaPrioritaria();
        fila.inserir("Ana", 25, 1);
        fila.inserir("Bruno", 30, 2);
        fila.inserir("Carla", 70, 3);
        fila.inserir("Daniel", 80, 4);
        fila.inserir("Eva", 60, 5);
        String[] expected = {"Carla", "Daniel", "Ana", "Bruno", "Eva"};
        Paciente atual = fila.inicio;
        for (String name : expected) {
            check(atual != null && atual.nome.equals(name), "FIFO por prioridade: " + name);
            atual = atual.proximo;
        }
        check(atual == null, "Fim da fila");
        for (int i = 0; i < expected.length; i++) fila.chamarProximo();
        fila.chamarProximo();
        check(fila.inicio == null, "Fila esvaziada");
    }

    static void rodizio() {
        Rodizio r = new Rodizio();
        r.remover("Ausente");
        r.adicionar("A", 1);
        r.adicionar("B", 2);
        r.adicionar("C", 3);
        r.remover("A");
        check(r.atual.nome.equals("B"), "Remove primeiro jogador");
        check(r.atual.proximo.nome.equals("C") && r.atual.proximo.proximo == r.atual,
              "Preserva ciclo após remoção do primeiro");
        r.proximoTurno();
        r.proximoTurno();
        check(r.atual.nome.equals("B"), "Jogador removido não retorna");
        r.remover("C");
        check(r.atual.proximo == r.atual, "Remove último jogador");
        r.remover("Ausente");
        r.remover("B");
        check(r.atual == null, "Remove jogador único");
        r.adicionar("A", 1);
        r.adicionar("B", 2);
        r.adicionar("C", 3);
        r.remover("B");
        check(r.atual.proximo.nome.equals("C") && r.atual.proximo.proximo == r.atual,
              "Remove jogador intermediário");
    }

    static void playlist() {
        Playlist p = new Playlist();
        p.avancar();
        p.voltar();
        p.adicionar("A", 10);
        check(p.atual.proxima == p.atual && p.atual.anterior == p.atual, "Música única circular");
        p.adicionar("B", 20);
        p.avancar();
        check(p.atual.nome.equals("B"), "Avança música");
        p.avancar();
        check(p.atual.nome.equals("A"), "Volta ao início");
        p.voltar();
        check(p.atual.nome.equals("B"), "Navega para trás");
    }

    static void carrinho() {
        Carrinho c = new Carrinho();
        c.remover("Ausente");
        c.adicionar("A", 2, 10);
        c.adicionar("B", 1, 5);
        c.adicionar("C", 1, 3);
        check(c.calcularTotal() == 28, "Total do carrinho");
        c.remover("B");
        check(c.inicio.proximo == c.fim && c.fim.anterior == c.inicio, "Remove meio");
        c.remover("A");
        check(c.inicio == c.fim && c.inicio.anterior == null, "Remove início");
        c.remover("C");
        check(c.inicio == null && c.fim == null && c.calcularTotal() == 0, "Carrinho vazio");
    }

    static void navegador() {
        Navegador n = new Navegador();
        n.visitar("a", "A");
        n.visitar("b", "B");
        n.voltar();
        check(n.atual.titulo.equals("A"), "Volta página");
        n.avancar();
        check(n.atual.titulo.equals("B"), "Avança página");
        n.voltar();
        n.visitar("c", "C");
        check(n.atual.anterior.titulo.equals("A") && n.atual.proxima == null,
              "Nova visita descarta futuro");
    }

    static void pedidos() {
        HistoricoPedidos h = new HistoricoPedidos();
        h.registrar(1, "A", 10);
        h.registrar(2, "B", 20);
        h.registrar(3, "C", 30);
        h.cancelar(2);
        check(h.inicio.proximo.numero == 3, "Cancela intermediário");
        h.cancelar(1);
        h.cancelar(3);
        h.cancelar(99);
        check(h.inicio == null, "Histórico vazio");
    }

    static void editor() {
        EditorTexto e = new EditorTexto();
        e.adicionarTexto("Olá");
        e.adicionarTexto(" mundo");
        e.desfazer();
        check(e.texto.equals("Olá"), "Desfaz texto");
        e.refazer();
        check(e.texto.equals("Olá mundo"), "Refaz texto");
        e.desfazer();
        e.adicionarTexto(" Java");
        check(e.refazer.estaVazia() && e.texto.equals("Olá Java"), "Nova edição limpa refazer");
        e.desfazer();
        e.desfazer();
        e.desfazer();
        check(e.texto.isEmpty(), "Desfaz até vazio");
    }

    public static void main(String[] args) {
        fila();
        rodizio();
        playlist();
        carrinho();
        navegador();
        pedidos();
        editor();
        System.out.println("7 grupos de testes de estruturas aprovados.");
    }
}
