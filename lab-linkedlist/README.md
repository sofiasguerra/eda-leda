# Identificação

* Nome: 
* Email (@ccc): 
* Matrícula: 

# Roteiro: Implementação de DoubleLinkedList

## Material Teórico 

[LinkedList](https://joaoarthurbm.github.io/eda/posts/linkedlist/)

## O template

> O código java estará (ou você terá que colocar) no diretório **/src/main/java/**

> Os testes estarão (ou você terá que incluir) no diretório **/src/main/java/** no formato de asserts.

> Seu código é tão bom quanto seus testes.

> Não mude nenhuma assinatura de método, nome de classe ou localização dos arquivos. Mas você pode/deve criar outros métodos e classes, desde que passem nos testes.

> Compilando: `javac *.java` em **/src/main/java/**

> Executando os testes: `java -ea LinkedListAsserts` em **/src/main/java/**

## Introdução

Este roteiro envolve a implementação das principais operações de linkedlist.

## A tarefa. 

### Implementação e testes


Implemente os métodos da classe LinkedList. A explicação do que fazer está como comentário no código. Seu objetivo é passar nos testes que disponibilizei. Sua implementação deve ser duplamente encadeada. Sugestão: implemente de maneira iterativa E recursiva o mesmo método.

Ah...confira (sempre!) se você passa nos testes: `java -ea LinkedListAsserts` em **/src/main/java/**

Óbvio que você pode simplesmente copiar código da Internet e colar lá. Eu mesmo disponibilizo código. Mas, conselho, assim você não aprende :)

### Mais métodos

Implemente também os seguintes métodos, já presentes como stubs na classe `LinkedList` (com `javac *.java` e `java -ea LinkedListAsserts` você confere se passa nos testes, igual aos métodos anteriores):

* `void moveToHead(int index)`. Move o elemento que está em `index` para a cabeça da lista. A busca pelo elemento é O(n), mas a movimentação em si deve ser O(1), ou seja, feita só manipulando referências.

* `void insereOrdenado(int v)`. Dada uma lista já em ordem crescente, insere o valor passado como parâmetro no seu devido lugar para que a lista continue ordenada após a inserção. Se já houver elementos iguais a `v`, insira `v` depois deles.

* `void swap(Node n1, Node n2)`. Troca `n1` e `n2` de posição na lista. Não é permitido trocar os valores guardados nos nós, só manipular as referências (`prev`/`next`). Esse algoritmo deve ser O(1), pois já recebe os nós a serem trocados. Use `getNode(int index)` (também um stub da classe) para obter nós reais a partir de fora, já que é assim que os testes conseguem exercitar esse método.

* `void inverte()`. Inverte a lista: `tail` passa a ser `head`, o elemento anterior ao `tail` passa a ser o segundo da lista e assim por diante, até chegar em `head`, que será o último elemento (`tail`). Não é permitido utilizar estrutura auxiliar.

* `String toStringReverso()`. Retorna uma string representando a lista no sentido inverso (do `tail` para o `head`), usando os ponteiros `prev`. Serve para provar que sua implementação é de fato duplamente encadeada — nada nos métodos acima obriga isso.

* `int removeAll(int valor)`. Remove todas as ocorrências de `valor` na lista (diferente de `removeByValue`, que remove só a primeira). Retorna quantas remoções foram feitas.

* `int[] toArray()`. Retorna um array com os elementos da lista, na mesma ordem em que aparecem.

* `int meio()`. Retorna o valor do elemento do meio da lista, usando a técnica dos dois ponteiros (um avança uma posição por vez, o outro avança duas) em uma única passada. Se a lista tiver tamanho par, retorne o segundo dos dois elementos centrais.

* `boolean isPalindromo()`. Retorna `true` se a lista for um palíndromo. Aproveite o fato de a lista ser duplamente encadeada para resolver isso em O(n) tempo e O(1) espaço extra, sem array ou pilha auxiliar.

* `boolean removeLastOccurrence(int valor)`. Remove a última ocorrência de `valor` na lista (diferente de `removeByValue`, que remove a primeira). Retorna `true` se removeu, `false` se não encontrou.

* `void filter(int valor)`. Remove da lista, em efeito colateral (sem criar uma lista nova), todo elemento cujo valor seja menor ou igual a `valor`. Ao final, a lista só deve ter elementos estritamente maiores que `valor`.
