
public class ControleDeAudio {

    int volume;

    public ControleDeAudio() {
        this.volume = 2;
    }

    public void aumentarVolume() {
        if (volume == 10) {
            System.out.println("\nVolume já está no máximo! Volume: " + volume);
            return;
        }
        this.volume++;
    }

    public void diminuirVolume() {
        if (volume == 1) {
            System.out.println("\nVolume já está no mínimo! Volume: " + volume);
            return;
        }
        this.volume--;
    }

    public int lerVolume() {
        return this.volume;
    }

}
