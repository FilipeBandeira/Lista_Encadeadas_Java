# Estruturas encadeadas em Java

Coleção de sete exercícios acadêmicos em **Java**, desenvolvidos no contexto da disciplina de Banco de Dados. Cada exemplo usa nós e referências para representar uma estrutura de dados.

| Arquivo | Estrutura e finalidade |
| --- | --- |
| `1.FilaPrioritaria.java` | Lista simples com prioridade e ordem de chegada dentro de cada grupo |
| `2.Playlist.java` | Lista dupla circular para navegação entre músicas |
| `3.Carrinho.java` | Lista dupla para itens, remoção e cálculo de total |
| `4.Rodizio.java` | Lista simples circular para turnos de jogadores |
| `5.Navegador.java` | Histórico duplo com voltar, avançar e descarte do futuro |
| `6.HistoricoPedidos.java` | Lista simples de pedidos e cancelamento |
| `7.EditorTexto.java` | Duas pilhas para desfazer e refazer texto |

## Compilação e testes

Requisito: JDK 17 ou superior, incluindo `javac`.

```sh
git clone https://github.com/FilipeBandeira/Lista_Encadeadas_Java.git
cd Lista_Encadeadas_Java
mkdir -p build
javac -encoding UTF-8 -d build *.java tests/EstruturasTest.java
java -cp build EstruturasTest
```

As classes dos exercícios não são públicas, por isso os nomes numerados dos arquivos são válidos. São implementações reutilizáveis, sem um `main` próprio; `EstruturasTest` fornece o programa de verificação.

## Decisões e limites

A fila mantém FIFO entre prioritários e entre não prioritários. A regra do exercício considera prioridade para idade **maior que 60**; não é uma especificação normativa de atendimento. O rodízio preserva a ligação circular ao remover inclusive o primeiro ou o último jogador.

As estruturas mantêm dados apenas em memória, com campos de acesso de pacote. Não há interface gráfica, persistência, concorrência ou uso de genéricos. Melhorias futuras: encapsulamento, parametrização dos tipos e uma interface demonstrativa.

## Qualidade

Os testes verificam ordem da fila, remoções circulares, navegação, carrinho, histórico e desfazer/refazer. O GitHub Actions compila todos os exercícios e executa a suíte.

## Autor e licença

[Filipe Bandeira](https://github.com/FilipeBandeira). Consulte o arquivo [LICENSE](LICENSE) para os termos do repositório. Materiais e marcas de terceiros mantêm seus respectivos direitos.
