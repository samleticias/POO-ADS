// 3. Crie uma função que retorne os números de um array passados por parâmetro
// separados por traço (-) no formato string. Para isso, use o método forEach dos
// arrays.

function formatar_string(array: number[]) : string {
    let string = '';

    array.forEach((number, index) => {
        string += number;

        if (index != array.length - 1){
            string += '-';
        }
    });

    return string;
}