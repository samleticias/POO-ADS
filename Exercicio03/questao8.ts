// 8. Crie um exemplo usando a função map para dobrar os elementos de um array e
// reduce para totalizar a soma dos elementos do array.

function dobrar(array: number[]): number[] {
    return array.map(numero => numero * 2);  
}

function somar(array: number[]): number {
    return array.reduce((acumulador, valor_atual) => acumulador + valor_atual, 0);  
}

function printar_lista(label : string,numeros: number[]) {
    console.log(label)
    let lista = ''
    for(let i = 0; i < numeros.length; i++){
        lista += numeros[i];
        if (i != numeros.length - 1){
            lista += ', '
        }
    }
    console.log(lista);
    console.log();
}

let numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
printar_lista("Números: ", numeros); // Saída: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10

let numeros_dobrados = dobrar(numeros);
printar_lista("Números dobrados: ", numeros_dobrados); // Saída: 2, 4, 6, 8, 10, 12, 14, 16, 18, 20

let soma_dos_numeros = somar(numeros);
console.log(`Soma dos números: ${soma_dos_numeros}`); // Saída: 55

let soma_dos_numeros_dobrados = somar(numeros_dobrados);
console.log(`Soma dos números dobrados: ${soma_dos_numeros_dobrados}`); // Saída: 110
