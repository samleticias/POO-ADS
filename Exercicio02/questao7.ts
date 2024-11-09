// Erro com strictNullChecks: true

let nome: string = null; // Erro: Type 'null' is not assignable to type 'string'

let nome: string | null = null; // Corrige erro declarando que a variável pode aceitar null
