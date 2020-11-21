import java.util.Scanner;
import java.util.InputMismatchException;

public class MenorPrimo {
    //Retorna true or false se o valor é primo ou não
    static boolean determinaPrimo(int n){
        int cont = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0)
                cont++;
        }
        return(cont == 2);
    }
    //Retorna o menor primo no intervalo de ]A,B[
    static int retornaMenorPrimo(int a, int b){
        int menor = b;
        if(a == b || a == b-1)
            menor = 1;
        else{
            for(int valor = a+1; valor < b; valor++){
                if(determinaPrimo(valor)){
                    if(valor < menor)
                        menor = valor;
                }
            }
        }
        return menor;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean estado = true;
        //Estrutura para validação dos valores lidos
        do{
            try{
                System.out.print("Digite o 1º valor: ");
                int a = input.nextInt();
                System.out.print("Digite o 2º valor: ");
                int b = input.nextInt();
                int result = retornaMenorPrimo(a,b);
                System.out.printf("\nO menor primo entre %d e %d é %d\n\n",a,b,result);
                estado = false;    
            }
            catch(InputMismatchException erro){
                input.nextLine();
                System.err.println("Deve inserir valores inteiros!!");
            }
        }while(estado);
    }
}
