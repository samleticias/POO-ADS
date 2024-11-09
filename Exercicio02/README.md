# Exercício 02 

## 1. Qual a diferença entre tipagem dinâmica e tipagem estática?

Na tipagem estática, é necessário informar explicitamente o tipo do dado utilizado. Dessa forma, uma vez que o tipo é definido, não é possível modificá-lo posteriomente no código e a variável é restrita à tipagem definida. A verificação do tipo é feita em tempo de compilação ou em
tempo de execução dependendo da linguagem utilizada, que pode ser compilada ou interpretada.

Na tipagem dinâmica, a verificação é feita em tempo de execução, de forma que o tipo é definido de acordo com o valor do dado declarado e não a partir da variável. Assim, é possível que uma mesma variável tenha seu tipo modificado ao longo do programa, já que as operações são realizadas utilizando o valor que a variável armazena no momento atual.

## 2. Qual o principal problema do uso de tipagem dinâmica?

O principal problema na tipagem dinâmica é o erro em tempo de execução. Já que a verificação detipos não é feita em tempo de compilação, erros ocorrem enquanto o programa é executado, ocasionando bugs e crashes. Dessa forma, a depuração do código é dificultada e a confiabilidade do sistema é prejudicada.

## 3. Pesquise um exemplo na internet em que a tipagem dinâmica pode ser problemático.

>[Exemplo de tipagem dinâmica em JavaScript](https://github.com/samleticias/POO-ADS/blob/main/Exercicio02/questao3.js)<br>


## 4. Pesquise e exemplifique com um exemplo porque dizemos que a linguagem C, mesmo tendo tipagem estática, possui tipagem fraca.

>[Exemplo de tipagem fraca em C](https://github.com/samleticias/POO-ADS/blob/main/Exercicio02/questao4.c)<br>


## 5. Poderíamos dizer que a tipagem do TypeScript é fraca por uma variável do tipo number aceitar tanto inteiros como ponto flutuante?

Não, pois a tipagem fraca ocorre quando o sistema permite que diferentes tipos sejam implicitamente convertidos entre si, como em linguagens como JavaScript, onde uma variável pode ser de um tipo e, em seguida, mudar para outro sem um erro. No caso do TypeScript, a tipagem é considerada forte. O fato de uma variável number aceitar tanto inteiros quanto números de ponto flutuante não torna a tipagem fraca, uma vez que isso se deve ao fato de que ambos são considerados parte do mesmo tipo numérico, como o TypeScript que apenas trata números de forma unificada. Se o usuário tentar atribuir um valor que não seja um número a uma variável do tipo number, o TypeScript vai gerar um erro, evidenciando sua tipagem forte. Portanto, a aceitação de inteiros e números de ponto flutuante dentro do tipo number é uma característica da linguagem, não uma indicação de tipagem fraca.

## 6. Reescreva o exemplo abaixo, mantendo a quebra de linhas usando template strings e os valores Ely, 120.56 e TypeScript venham de variáveis declaradas separadamente e “interpoladas” na string:
Ely <br>
My payment time is 120.56 <br>
and
my preffered language is TypeScript

>[Classe Professor em TypeScript](https://github.com/samleticias/POO-ADS/blob/main/Exercicio02/questao6.ts)

## 7. Pesquise e configure o seu arquivo de configuração do TypeScript com as opções abaixo. Faça testes com as mudanças e perceba a diferença após a configuração.

- a. Alterar o local em que os arquivos *.js são gerados para a pasta build;
- b. allowUnreachableCode com valor true; https://www.typescriptlang.org/pt/tsconfig#allowUnreachableCode
- c. noImplicitAny com valor true https://www.typescriptlang.org/pt/tsconfig#noImplicitAny
- d. target com o valor ES3. Além disso, utilize a classe do exercício anterior e veja como ela é transpilada para JS;
- e. strictNullChecks para true e crie um exemplo que mostre a restrição;
- f. Configure um projeto seu para que seja possível realizar depuração alterando o atributo sourceMap.

>[Configuração do TypeScript](https://github.com/samleticias/POO-ADS/blob/main/Exercicio02/tsconfig.json)<br>
>[Exemplo strictNullChecks = true](https://github.com/samleticias/POO-ADS/blob/main/Exercicio02/questao7.ts)<br>
>[Classe Professor transpilada para JavaScript](https://github.com/samleticias/POO-ADS/blob/main/Exercicio02/questao6.js)

