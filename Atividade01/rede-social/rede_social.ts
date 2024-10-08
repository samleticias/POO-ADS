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

    criarPostagem(postagem: Postagem): void {
        this.postagens.push(postagem);
    }

    editarPostagem(postagem: Postagem, novoTexto?: string, novasFotos?: string[], novosVideos?: string[]): void {
        if (novoTexto !== undefined) {
            postagem.texto = novoTexto;
        }
        if (novasFotos !== undefined) {
            postagem.fotos = novasFotos;
        }
        if (novosVideos !== undefined) {
            postagem.videos = novosVideos;
        }
        postagem.dataEdicao = new Date(); 
    }

    excluirPostagem(postagem: Postagem) : void {
        this.postagens = this.postagens.filter(p => p !== postagem);
    }

    comentar(postagem: Postagem, comentario: Comentario) : void {
        postagem.comentarios.push(comentario);
    }

    curtir(postagem: Postagem): void {
        postagem.curtidas.push(new Curtida(this)); 
    }

    organizarPostagens(categoria: string): Postagem[] {
        return this.postagens.filter(postagem => postagem.categoria.nome === categoria);
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

    filtrarPostagensPorIdCategoria(id: number): Postagem[] {
        return this.postagens = this.postagens.filter(p => p.categoria.id === id)
    }

    filtrarPostagensPorNomeCategoria(nome: string): Postagem[] {
        return this.postagens = this.postagens.filter(p => p.categoria.nome === nome)
    }
}

// - Visibilidade
//     - nivel (público, amigos, privado)