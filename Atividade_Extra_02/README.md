# Resolução - Atividade Extra 02

**Aluno(a): Sammya Letícia Valadão da Silva**

## 01. Identifique o nome do conceito representado pelo texto abaixo:

 **a.** É a forma de definir ou controlar a complexidade baseada em características essenciais e pela supressão ou desconsideração de detalhes em orientação a objetos  
><span style="color: green;">Abstração.</span>

 **b.** Define que nenhum acesso direto é concedido diretamente aos dados, apenas através de métodos.
><span style="color: green;">Encapsulamento.</span>
  
 **c.** É um recurso que serve para inicializar os atributos e é executado automaticamente sempre que um novo objeto é criado.
><span style="color: green;">Construtor.</span>

## 02. Assinale V ou F:

><span style="color:red">(F) Classes são instâncias de objetos;</span><br>
><span style="color:red">(F) Classes são apenas agrupamentos de métodos;</span><br>
><span style="color:green">(V) Atributos definem o estado de um objeto;</span><br>
><span style="color:red">(F) Métodos podem ser análogos às funções e em TypeScript e podem ser
escritos dentro ou fora da classe, como em C++;</span><br>
><span style="color:red">(F) Podemos ignorar o uso de tipos em TypeScript.</span><br>

## 03. Considere os elementos e assinale a alternativa correta: Teresina Equipamentos Hidráulicos, Empresa e Nome da Empresa. Na orientação a objetos, os itens acima representam, respectivamente:

**Alternativa correta:** e. Objeto, Classe e Atributo.

## 04. Dada a construção abaixo, associe os números ao elemento correspondente:

```TypeScript
let conta : Conta = new Conta();
      1       2      3    4
````
> <span style="color:green">(4) Construtor <br>
> (3) Operador de instanciação <br>
> (2) Classe <br>
> (1) Objeto </span>

## 05. Crie uma classe chamada ControleDeAudio a partir das orientações:
    a. A classe deve ter um atributo inteiro representando o volume inicializado
    com o valor 2.
    b. Crie um método chamado aumentar volume que incrementa em um o
    valor atual. O método não deve deixar o valor ficar maior que 10. Utilize
    um if para isso;
    c. Crie um método chamado diminuir volume que decrementa em um o
    valor atual. O método não deve deixar o valor ficar menor 0.
    d. Crie um método chamado lerVolume que retorna o valor do volume.

>[Classe ControleDeAudio em Typescript](https://github.com/samleticias/POO-ADS/blob/main/AtividadeExtra02/Classes/ControleDeAudio.ts)

## 06. Na questão sobre retângulos do exercício anterior, crie um método que retorna verdadeiro ou falso se o retângulo é um quadrado.
````Java
public boolean isQuadrado() {
        return this.comprimento == this.largura;
}
````
>[Implementação do método isQuadrado na classe Retangulo](https://github.com/samleticias/POO-ADS/blob/main/AtividadeExtra01/Classes/Retangulo/Retangulo.java)

## 07. Implemente a questão do ControleDeAudio acima em outra linguagem que não seja TypeScript.
>[Classe ControleDeAudio em Java](https://github.com/samleticias/POO-ADS/blob/main/AtividadeExtra02/Classes/ControleDeAudio.java)


