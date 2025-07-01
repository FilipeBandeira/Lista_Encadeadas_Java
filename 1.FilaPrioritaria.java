// Estrutura: Lista simplesmente encadeada
// Justificativa: Mantém a ordem de chegada e dá prioridade para idosos (>60 anos),
// inserindo-os no início da fila sem perder a eficiência da estrutura leve.

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
        if (inicio == null || idade > 60) {
            novo.proximo = inicio;
            inicio = novo;
        } else {
            Paciente atual = inicio;
            while (atual.proximo != null && atual.proximo.idade > 60) {
                atual = atual.proximo;
            }
            novo.proximo = atual.proximo;
            atual.proximo = novo;
        }
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
