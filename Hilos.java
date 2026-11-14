import java.util.Random;

public class Hilos implements Runnable{
    
    /* ATRIBUTOS */
    private String nombreHilo;
    private NumeroOculto numeroOculto;
    private Random random = new Random();

    /* CONSTRUCTOR */
    public Hilos(String nombreHilo, NumeroOculto numeroOculto) {
        this.nombreHilo = nombreHilo;
        this.numeroOculto = numeroOculto;
    }

    /* MÉTODO RUNNABLE */
    @Override
    public void run() {
        while(true){
            int propuesta = random.nextInt(101);
            int resultado = numeroOculto.propuestaNumero(propuesta);

            if(resultado == -1)
                break;
            else if (resultado == 1) {
                System.out.println(nombreHilo + " ha adivinado el número oculto. El número es: " + propuesta);
                break;
            }else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}