function main(){
    var numero = 10;
    var string = "20";
    
    var resultado = numero + string;
    
    console.log(resultado); // Saída: 1020
    console.log(typeof(resultado)); // Saída: string
}

main();

/* Devido à tipagem dinâmica do JavaScript, ao somar valores de tipos diferentes, o número 10 é 
convertido em uma string para que possa ser concatenado com a string "20". O resultado impresso
será a concatenação das duas strings, ou seja, "1020". Assim, a conversão implícita exibiu um resultado 
inesperado, pois esperava-se uma soma arimética e houve uma concatenação.  
*/