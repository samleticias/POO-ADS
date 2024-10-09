class Personagem {
    nome: string;
    pontosDeVida: number;
    forca: number;
    nivel: number;
    habilidades: Habilidade[];
    inventario: Inventario;

    constructor(nome: string, pontosDeVida: number, forca: number, nivel: number){
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.nivel = nivel;
        this.habilidades = this.habilidades;
        this.inventario = this.inventario;
    }

    atacarInimigo(inimigo: Inimigo, dano: number) : void {
        inimigo.pontosDeVida -= dano;
    }

    adicionarItem(item: Item) : void {
        this.inventario.itens.push(item);
    }

    removerItem(item: Item) : void {
        this.inventario.itens = this.inventario.itens.filter(i => i !== item);
    }

    usaHabilidade(habilidade: Habilidade, inimigo?: Inimigo): void {
        if (habilidade.tipo === "dano") {
            if (inimigo) {
                inimigo.pontosDeVida -= habilidade.valor;
                console.log(`Dano aplicado a ${inimigo.nome}: ${habilidade.valor}\nVida restante: ${inimigo.pontosDeVida}`);
            }
        } else {
            this.pontosDeVida += habilidade.valor;
                console.log(`Cura aplicada a ${this.nome}: ${habilidade.valor}\nVida atual: ${this.pontosDeVida}`);
        } 
    }

    recuperaPontosDeVida(valor: number) : void {
        this.pontosDeVida += valor;
    }
}

class Habilidade {
    nome: string;
    tipo: string;
    valor: number;

    constructor(nome: string, tipo: string, dano: number){
        this.nome = nome;
        this.tipo = tipo;
        this.valor = dano;
    }
}

class Item {
    nome: string;
    descricao: string;
    valor: number;
    
    constructor(nome: string, descricao: string, valor: number){
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }
}

class Inimigo {
    nome: string;
    pontosDeVida: number;
    forca: number;
    habilidades: Habilidade[];

    constructor(nome: string, pontosDeVida: number, forca: number, nivel: number){
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.habilidades = this.habilidades;
    }

    atacarPersonagem(personagem: Personagem, dano: number) : void {
        personagem.pontosDeVida -= dano;
    }
}

class NPC {
    nome: string;
    tipo: string;
    itens: Item[];

    constructor(nome: string, tipo: string){
        this.nome = nome;
        this.tipo = tipo;
        this.itens = this.itens;
    }
}

class Inventario {
    itens: Item[];
    capacidadeMaxima: number;

    constructor(capacidadeMaxima: number){
        this.capacidadeMaxima = capacidadeMaxima;
        this.itens = this.itens;
    }

    atingiuCapacidadeMaxima() {
        let qtdItens = this.itens.length
        if (qtdItens >= this.capacidadeMaxima){
            return true
        }
        return false
    }

    obterQuantidadeItens(){
        return this.itens.length;
    }
}
