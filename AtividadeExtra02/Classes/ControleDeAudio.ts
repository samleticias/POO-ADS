class ControleDeAudio {
    volume : number;

    constructor() {
        this.volume = 2;  
    }

    aumentarVolume() : void {
        if (this.volume == 10){
            console.log("\nVolume já está no máximo! Volume: " + this.volume);
            return;
        }
        this.volume += 1;
    }

    diminuirVolume() : void {
        if (this.volume == 1){
            console.log("\nVolume já está no mínimo! Volume: " + this.volume);
            return;
        }
        this.volume -= 1;
    }

    lerVolume() : number {
        return this.volume;
    }

}

function main(){
    const c : ControleDeAudio = new ControleDeAudio();

    c.aumentarVolume();
    c.aumentarVolume();
    c.diminuirVolume();
    c.aumentarVolume();
    c.diminuirVolume();

    console.log("Volume = " + c.lerVolume());  // Saída: Volume = 3
}

main();