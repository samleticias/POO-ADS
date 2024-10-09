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
        this.habilidades = [];
        this.inventario = new Inventario(25);
    }

    exibirDados(){
        const p = `
        > Personagem:
        | Nome: ${this.nome}
        | Força: ${this.forca}
        | Nível: ${this.nivel}
        | Qtd Pontos de Vida: ${this.pontosDeVida}
        | Inventário: ${this.inventario.exibirItens()}
        | Habilidades: ${this.exibirHabilidades()}
        \n`
        console.log(p)
    }

    exibirHabilidades(){
        if (this.habilidades.length === 0){
            return 'Lista de habilidades vazia!';
        } else {
            let listaHabilidades = '';
            for (let habilidade of this.habilidades){
                listaHabilidades += `
                > Habilidade:
                | Nome: ${habilidade.nome}
                | Tipo: ${habilidade.tipo}
                | Valor: ${habilidade.valor}\n`;
            }
            return listaHabilidades;
        }
    }

    atacarInimigo(inimigo: Inimigo, dano: number) : void {
        inimigo.pontosDeVida -= dano;
    }

    adicionarItem(item: Item): void {
        if (!this.inventario.atingiuCapacidadeMaxima()) {
            this.inventario.itens.push(item);
            console.log(`\nItem ${item.nome} adicionado ao inventário!`);
        } else {
            console.log("\nInventário cheio! Não foi possível adicionar o item");
        }
    }

    removerItem(item: Item) : void {
        if (this.inventario.obterQuantidadeItens() === 0){
            console.log('\nInventário vazio!');
        } else {
            this.inventario.itens = this.inventario.itens.filter(i => i !== item);
        }
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
    id: number;
    nome: string;
    descricao: string;
    valor: number;
    
    constructor(id: number, nome: string, descricao: string, valor: number){
        this.id = id;
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

    venderItem(personagem: Personagem, item: Item) : void {
        this.itens = this.itens.filter(i => i.id !== item.id);
        personagem.adicionarItem(item);
    }
}

class Inventario {
    itens: Item[];
    capacidadeMaxima: number;

    constructor(capacidadeMaxima: number) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.itens = [];
    }

    atingiuCapacidadeMaxima(): boolean {
        return this.itens.length >= this.capacidadeMaxima;
    }

    obterQuantidadeItens(){
        return this.itens.length;
    }

    exibirItens(): string {
        if (this.obterQuantidadeItens() === 0){
            return 'Inventário vazio! Não há itens para exibir ...';
        } else {
            let listaItens = '';
            for (let item of this.itens){
                listaItens += `
                > Item:
                | ID: ${item.id}
                | Nome: ${item.nome}
                | Descrição: ${item.descricao}
                | Valor: ${item.valor}`;
            }
            return listaItens;
        }
    }
}

function main(){
    const p1 = new Personagem("sammya", 100, 3, 2);
    const bolaDeCristal = new Item(1, "bola de cristal", "misteriosa", 40);
    p1.adicionarItem(bolaDeCristal);
    p1.inventario.exibirItens();

    const inimigo = new Inimigo("fulano", 200, 4, 5);
    inimigo.atacarPersonagem(p1, 30);
    p1.exibirDados();
}

main();
