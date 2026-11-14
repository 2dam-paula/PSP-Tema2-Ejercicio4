
public class Principal {
    static void main(String[] args) {
        System.out.println("INICIO DEL JUEGO - NÚMERO OCULTO");
        NumeroOculto numeroOculto = new NumeroOculto();

        int numeroHilos = 10;
        Thread[] hilo = new Thread[numeroHilos];

        // Crear y lanzar los 10 hilos
        for (int i = 0; i < numeroHilos; i++) {
            hilo[i] = new Thread(new Hilos("Hilo-" + i, numeroOculto));
            hilo[i].start();
        }

        // El hilo principal espera a que todos los hilos terminen su ejecución
        for (int i = 0; i < numeroHilos; i++) {
            try {
                hilo[i].join();
            } catch (InterruptedException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Fin del juego");
    }
}
