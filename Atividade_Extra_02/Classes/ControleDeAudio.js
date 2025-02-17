var ControleDeAudio = /** @class */ (function () {
    function ControleDeAudio() {
        this.volume = 2;
    }
    ControleDeAudio.prototype.aumentarVolume = function () {
        if (this.volume == 10) {
            console.log("\nVolume já está no máximo! Volume: " + this.volume);
            return;
        }
        this.volume += 1;
    };
    ControleDeAudio.prototype.diminuirVolume = function () {
        if (this.volume == 1) {
            console.log("\nVolume já está no mínimo! Volume: " + this.volume);
            return;
        }
        this.volume -= 1;
    };
    ControleDeAudio.prototype.lerVolume = function () {
        return this.volume;
    };
    return ControleDeAudio;
}());
function main() {
    var c = new ControleDeAudio();
    c.aumentarVolume();
    c.aumentarVolume();
    c.diminuirVolume();
    c.aumentarVolume();
    c.diminuirVolume();
    console.log("Volume = " + c.lerVolume()); // Saída: Volume = 3
}
main();
