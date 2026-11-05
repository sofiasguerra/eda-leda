# Identificação

* Nome: 
* Email (@ccc): 
* Matrícula: 

# Roteiro: Funções hash

## O template

> Os dados estarão em **/data**

## Introdução

Neste roteiro você vai comparar os métodos de função de hash que discutimos em sala de aula: da divisão e multiplicação. O método da divisão que vimos é bem simples, escolher uma tabela de tamanho primo e usar o resto da divisão para calcular o hash. Já o da divisão é um pouco mais complexo, mas vamos lá. Seja K a sua chave, o hash é dado pelos seguinte passos:

1. Multiplicar K por uma constante entre 0 e 1. Knuth sugere `A = 0,6180339887`
2. Obter a parte decimal da multiplicação anterior. Isso pode ser feito usando `% 1`
3. Multiplicar a parte decimal pelo tamanho da tabela
4. Obter a parte inteira da multiplicação do passo anterior. Esse é o hash.

## A tarefa.

No diretório `data`, tem um arquivo chamado `keys.txt`. Essas serão as chaves que usaremos no roteiro. Não há chave repetida. Eu gerei essas chaves aleatoriamente usando a variável $RANDOM do unix.

Seu objetivo é calcular o hash de cada uma dessas chaves usando o método da divisão (escolha o tamanho da tabela 53) e o método da múltiplicação com o mesmo tamanho de tabela. Responsa da perguntas téoricas abaixo:

* Assuma que estamos usando o método da divisão e que estamos resolvendo colisão por encadeamento. Sendo assim, aponte abaixo o estado final da tabela. Eu deixei um exemplo abaixo. A primeira coluna é o índice (hash) a segunda é a lista. Apague meu exemplo e faça para toda a tabela. Claro que tu não vai fazer isso na mão, né? Faça um programa que imprima isso.

  ```diff
  - APAGUE O EXEMPLO E INSIRA SUA RESPOSTA AQUI
  0, [837, 23]
  1, []
  2, [7348, 134, 847, 2488]
  ...
  52, [...]
  ```
 
* Assuma que estamos usando o método da multiplicação e que estamos resolvendo colisão por encadeamento. Sendo assim, aponte abaixo o estado final da tabela. Eu deixei um exemplo abaixo. A primeira coluna é o índice (hash) a segunda é a lista. Apague meu exemplo e faça para toda a tabela. Claro que tu não vai fazer isso na mão, né? Faça um programa que imprima isso.

  ```diff
  - APAGUE O EXEMPLO E INSIRA SUA RESPOSTA AQUI
  0, [837, 23]
  1, []
  2, [7348, 134, 847, 2488]
  ...
  52, [...]
  ```

* Quantas colisões houve em cada estratégia?

 ```diff
 - INSIRA SUA RESPOSTA AQUI
 ```
