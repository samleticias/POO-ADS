export class Retangulo {
    private altura: number;
    private largura: number;

    constructor(altura: number, largura: number) {
        this.altura = altura;
        this.largura = largura;
    }

    getAltura() {
        return this.altura;
    }

    getLargura() {
        return this.largura;
    }

    calcularArea(altura: number, largura: number){
        return altura * largura
    }
}

function main(){
    const r1: Retangulo = new Retangulo(7.0, 6.0);
    console.log('\n--------------------------');
    console.log(`> Altura do retângulo: ${r1.getAltura()}`);
    console.log(`> Largura do retângulo: ${r1.getLargura()}`);

    // calculando area do retangulo
    const area = r1.calcularArea(r1.getAltura(), r1.getLargura())
    console.log(`> Área do retângulo: ${area.toFixed(2)}`);
    console.log('--------------------------\n');
}

main();