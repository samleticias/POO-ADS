// 7. Dado método filter dos arrays, crie uma implementação usando arrow function que
// filtre todos os elementos pares do array abaixo:
// const array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];

let filtrar_pares = (numeros: number[]) => {

    for (let i = 0; i < numeros.length; i++) {
        if (numeros[i] % 2 === 0) {
            console.log(numeros[i]);
        }
    }
}

const array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];
filtrar_pares(array)