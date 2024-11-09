#include <stdio.h>

int main() {
    int numero_inteiro = 35;
    float numero_decimal = 9.5;
    
    int resultado = numero_inteiro + numero_decimal; 
    
    printf("Resultado: %d\n", resultado); // Saída: 44
    
    return 0;
}

/*
A tipagem fraca significa que a linguagem pode realizar conversões 
automaticamente entre tipos diferentes de dados. A linguagem C permite operações 
entre tipos distintos, como no exemplo acima, onde variáveis de tipo inteiro
e decimal são somados por meio de uma conversão implícita.
*/