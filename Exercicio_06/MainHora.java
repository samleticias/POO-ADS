
class Hora {

    private int hora;
    private int minuto;
    private int segundo;

    public Hora(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public int getHora() {
        return this.hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return this.minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getSegundo() {
        return this.segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    public String getHorario() {
        return "%02d:%02d:%02d".formatted(getHora(), getMinuto(), getSegundo());
    }
}

public class MainHora {

    public static void main(String[] args) {
        Hora horario = new Hora(17, 32, 15);
        System.out.println(horario.getHorario()); // Saída: 17:32:15
    }
}
