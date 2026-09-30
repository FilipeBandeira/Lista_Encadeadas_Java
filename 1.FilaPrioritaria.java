// Estrutura: Lista simplesmente encadeada
// Justificativa: Mantém a ordem de chegada e dá prioridade para idosos (>60 anos),
// preservando FIFO dentro de cada grupo de prioridade.

class Paciente {
    String nome;
    int idade;
    int senha;
    Paciente proximo;

    public Paciente(String nome, int idade, int senha) {
        this.nome = nome;
        this.idade = idade;
        this.senha = senha;
        this.proximo = null;
    }
}

class FilaPrioritaria {
    Paciente inicio;

    public void inserir(String nome, int idade, int senha) {
        Paciente novo = new Paciente(nome, idade, senha);
        Paciente anterior = null;
        Paciente atual = inicio;
        while (atual != null && (idade <= 60 || atual.idade > 60)) {
            anterior = atual;
            atual = atual.proximo;
        }
        novo.proximo = atual;
        if (anterior == null) inicio = novo;
        else anterior.proximo = novo;
    }

    public void chamarProximo() {
        if (inicio != null) {
            System.out.println("Chamando: " + inicio.nome);
            inicio = inicio.proximo;
        }
    }

    public void listar() {
        Paciente atual = inicio;
        while (atual != null) {
            System.out.println(atual.nome + " (" + atual.idade + ")");
            atual = atual.proximo;
        }
    }
}
