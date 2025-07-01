// Estrutura: Lista duplamente encadeada
// Justificativa: Permite navegação para frente e para trás entre páginas visitadas.
// Ao visitar nova página, descarta o histórico futuro, simulando o comportamento de navegadores modernos.

class Pagina {
    String url;
    String titulo;
    Pagina anterior, proxima;

    public Pagina(String url, String titulo) {
        this.url = url;
        this.titulo = titulo;
    }
}

class Navegador {
    Pagina atual;

    public void visitar(String url, String titulo) {
        Pagina nova = new Pagina(url, titulo);
        if (atual != null) {
            atual.proxima = null;
            nova.anterior = atual;
            atual.proxima = nova;
        }
        atual = nova;
    }

    public void voltar() {
        if (atual != null && atual.anterior != null)
            atual = atual.anterior;
        else
            System.out.println("Não há página anterior.");
    }

    public void avancar() {
        if (atual != null && atual.proxima != null)
            atual = atual.proxima;
        else
            System.out.println("Não há página seguinte.");
    }

    public void exibirAtual() {
        if (atual != null)
            System.out.println("Visualizando: " + atual.titulo + " [" + atual.url + "]");
        else
            System.out.println("Nenhuma página visitada.");
    }
}
