class Usuario {
    nome: string;
    email: string;
    senha: string;
    postagens: Postagem[];

    constructor(nome: string, email: string, senha: string){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.postagens = [];
    }

    criarPostagem(texto: string, categoria: Categoria): Postagem {
        const novaPostagem = new Postagem(texto, categoria);
        this.postagens.push(novaPostagem);
        categoria.adicionarPostagem(novaPostagem);
        return novaPostagem;
    }

    editarPostagem(postagem: Postagem, novoTexto?: string, novasFotos?: string[], novosVideos?: string[]): void {
        postagem.editarConteudo(novoTexto, novasFotos, novosVideos);
    }

    excluirPostagem(postagem: Postagem): void {
        this.postagens = this.postagens.filter(p => p !== postagem);
        postagem.categoria.removerPostagem(postagem);
    }

    comentar(postagem: Postagem, comentario: Comentario) : void {
        postagem.comentarios.push(comentario);
    }

    curtir(postagem: Postagem): void {
        postagem.curtidas.push(new Curtida(this)); 
    }

    organizarPostagens(nomeCategoria: string): Postagem[] {
        return this.postagens.filter(postagem => postagem.categoria.nome === nomeCategoria);
    }

    exibirPostagens(): Postagem[] {
        return this.postagens;
    }
}

class Postagem {
    texto: string;
    fotos: string[]; 
    videos: string[];
    dataCriacao: Date;
    dataEdicao: Date;
    comentarios: Comentario[];
    curtidas: Curtida[];
    categoria: Categoria;

    constructor(texto: string = "", categoria: Categoria) {
        this.texto = texto;
        this.fotos = [];
        this.videos = [];
        this.dataCriacao = new Date();
        this.dataEdicao = new Date();
        this.comentarios = [];
        this.curtidas = [];
        this.categoria = categoria;
    }

    editarConteudo(novoTexto?: string, novasFotos?: string[], novosVideos?: string[]): void {
        if (novoTexto !== undefined) {
            this.texto = novoTexto;
        }
        if (novasFotos !== undefined) {
            this.fotos = novasFotos;
        }
        if (novosVideos !== undefined) {
            this.videos = novosVideos;
        }
        this.dataEdicao = new Date(); 
    }

    adicionarComentario(comentario: Comentario): void {
        this.comentarios.push(comentario);
    }

    removerComentario(comentario: Comentario): void {
        this.comentarios = this.comentarios.filter(c => c !== comentario);
    }

    adicionarCurtida(usuario: Usuario): void {
        this.curtidas.push(new Curtida(usuario));
    }

    removerCurtida(usuario: Usuario): void {
        this.curtidas = this.curtidas.filter(c => c.usuario !== usuario);
    }
    
}

class Comentario {
    texto: string;
    dataCriacao: Date;
    usuario: Usuario;

    constructor(texto: string = "", usuario: Usuario) {
        this.texto = texto;
        this.dataCriacao = new Date();
        this.usuario = usuario;
    }

    editarTexto(novoTexto: string) : void {
        if (this.texto !== undefined){
            this.texto = novoTexto;
        }
    }
}

class Curtida {
    usuario: Usuario;
    dataCurtida: Date;

    constructor(usuario: Usuario) {
        this.dataCurtida = new Date();
        this.usuario = usuario;
    }
}

class Categoria {
    id: number; 
    nome: string;
    postagens: Postagem[];

    constructor(id: number, nome: string){
        this.id = id;
        this.nome = nome;
        this.postagens = [];
    }

    adicionarPostagem(postagem: Postagem) : void {
        this.postagens.push(postagem);
    }

    removerPostagem(postagem: Postagem) : void {
        this.postagens = this.postagens.filter(p => p !== postagem);
    }
}

function main() {
    const usuario1 = new Usuario("Sammya", "sammya@gmail.com", "12345");
    const categoria1 = new Categoria(1, 'Outubro');
    const p1 = usuario1.criarPostagem("Atividade de POO", categoria1);

    const usuario2 = new Usuario("José", "jogui@gmail.com", "1234");
    const comentario1 = new Comentario("Bom dia!!", usuario2);

    usuario2.comentar(p1, comentario1);
    // mostraPostagem(p1)

    usuario2.curtir(p1);
    mostraPostagem(p1);

    comentario1.editarTexto("Python eh melhor!");
    usuario1.editarPostagem(p1, "Aprendendo TS :)");

    const comentario2 = new Comentario("Café", usuario2);
    usuario2.comentar(p1, comentario2);
    mostraPostagem(p1);
}

function mostraPostagem(postagem: Postagem): void {
    console.log("\nPostagem: " + postagem.texto);
    console.log("| Data de Criação: " + postagem.dataCriacao);
    
    mostraCurtidas(postagem, "\n| Curtidas:");
    mostraComentarios(postagem, "\n| Comentários:");
}

function mostraCurtidas(postagem: Postagem, message: string): void {
    console.log(message);
    for (let curtida of postagem.curtidas) {
        console.log("> Curtido em " + curtida.dataCurtida + " por: " + curtida.usuario.nome);
    }
}

function mostraComentarios(postagem: Postagem, message: string): void {
    console.log(message);
    for (let comentario of postagem.comentarios) {
        console.log("> " + comentario.texto + " (por: " + comentario.usuario.nome + ")\n");
    }
}

main();
