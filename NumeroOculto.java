
import java.util.Random;

public class NumeroOculto {
    private static int secreto;
    private static boolean terminado = false;

    public NumeroOculto() {
        Random numeroRandom = new Random();
        secreto = numeroRandom.nextInt(101);
        System.out.println("Numero secreto: " + secreto);
    }

    public synchronized int propuestaNumero(int num) {
        
        if(terminado) //El juego está terminado
            return -1;


        if (num == secreto) { //El numero es el número secreto
            terminado = true;
            return 1;
        }

        return 0; //si falla
    }

    public int getNumeroOcuto (){
        return secreto;
    }
    
}
