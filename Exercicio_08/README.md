# Exercicio 08

### 1) Enumere os 3 tipos mais comuns de tratamento de erros e exemplifique com códigos seus ou pesquisados na internet.

#### 1. Desconsiderar a operação
#### Exemplo:

```java
    void depositar(double valor){
        if (valor > 0) {
            this.saldo += valor;
        }
    }
```

#### 2. Exibir uma mensagem de erro
#### Exemplo:

```java
    void depositar(double valor){
        if (valor > 0) {
            this.saldo += valor;
        } else {
            System.out.println("Erro ao realizar a operação depósito. Valores negativos são inválidos.")
        }
    }
```

#### 3. Retornar um código de erro:
#### Exemplo:

```java
    boolean sacar(double valor){
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } return false;
    }
```

### 2) Explique por que cada um dos 3 métodos acima possui limitações de uso.

1. Desconsiderar a operação:
 Essa estratégia não é adequada, pois ficamos na incerteza de sucesso na operação.

2. Exibir uma mensagem de erro:
 A eficácia dessa abordagem depende da visibilidade da mensagem. Em aplicações sem interface gráfica, as mensagens podem ser ignoradas, 
e mensagens detalhadas podem expor informações sensíveis, enquanto genéricas podem ser pouco úteis.

3. Retornar um código de erro:
 Códigos de erro requerem que os desenvolvedores conheçam seu significado, criando dependência da documentação.

### [Questões 3, 4 e 5](https://github.com/samleticias/POO-ADS/blob/main/Exercicio_08/Questoes3a5.java)<br>