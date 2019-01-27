/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author masuel
 */
public class morse {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int valor = 0;
//        System.out.println("Codigo morse a traducir");
//        mensaje = leer.nextLine();
        try {
            System.out.print("1.Texto a codigo morse\n"
                    + "2.Codigo morse a texto\n"
                    + "R: ");
            valor = leer.nextInt();

            if (valor == 1) {
                System.out.println("Codigo morse: \n" + TextoMorce());
            } else if (valor == 2) {
                System.out.println("Texto: \n" + MorceTexto());
            } else {
                System.out.println("Ingrese un numero correcto");
            }
        } catch (Exception e) {
            System.out.println("Ingrese un digito");
        }

    }

    //Este metodo traduce de texto a codigo morse
    public static String TextoMorce() {
        Scanner leer = new Scanner(System.in);
        String letras = "abcdefghijklmnopqrstuvwxyz0123456789";//Lista de carácteres
        String mensaje = "";
        System.out.println("Texto a traducir");//peticion de texto
        mensaje = leer.next();//Entrada de texto
        mensaje = mensaje.toLowerCase();//Conversión de todo el texto a minusculas

        String codigo[] = new String[36];//Arreglo de lista de codigo morse
        String morse = "";//Cadena vacía inicial para la clave morse resultante

        codigo[0] = ".-"; 	//a
        codigo[1] = "-...";	//b
        codigo[2] = "-.-.";	//c
        codigo[3] = "-..";	//d
        codigo[4] = ".";	//e
        codigo[5] = "..-.";	//f
        codigo[6] = "--.";	//g
        codigo[7] = "....";	//h
        codigo[8] = "..";	//i
        codigo[9] = ".---";	//j
        codigo[10] = "-.-";	//k
        codigo[11] = ".-..";    //l
        codigo[12] = "--";	//m
        codigo[13] = "-.";	//n
        codigo[14] = "---";	//o
        codigo[15] = ".--.";    //p
        codigo[16] = "--.-";    //q
        codigo[17] = ".-.";	//r
        codigo[18] = "...";	//s
        codigo[19] = "-";	//t
        codigo[20] = "..-";	//u
        codigo[21] = "...-";    //v
        codigo[22] = ".--";	//w
        codigo[23] = "-..-";    //x
        codigo[24] = "-.--";    //y
        codigo[25] = "--..";    //z
        codigo[26] = "-----";   //0
        codigo[27] = ".----";   //1
        codigo[28] = "..---";   //2
        codigo[29] = "...--";   //3
        codigo[30] = "....-";	//4
        codigo[31] = ".....";	//5
        codigo[32] = "-....";	//6
        codigo[33] = "--...";	//7
        codigo[34] = "---..";	//8
        codigo[35] = "----.";	//9

        for (int i = 0; i < mensaje.length(); i++) {
            if (mensaje.charAt(i) == ' ') {//busca espacios
                morse = morse + "  ";//espacio entre palabras

            } else {
                for (int j = 0; j < letras.length(); j++) {
                    if (mensaje.charAt(i) == letras.charAt(j)) {//compara la letra para saber No. de posicion
                        morse = morse + codigo[j] + " ";//espacio entre letras
                    }
                }
            }
        }
        return morse.trim();//quita espacios al inicio y al final
    }

    //Este metodo traduce el codigo morse a texto
    public static String MorceTexto() {
        Scanner leer = new Scanner(System.in);
        String letras = "abcdefghijklmnopqrstuvwxyz 0123456789";//Lista de carácteres

        String morse = " ";
        String mensaje = "";

        String codigo[] = new String[37];//Arreglo de lista de codigo morse

        codigo[0] = ".-";   //a
        codigo[1] = "-..."; //b
        codigo[2] = "-.-."; //c
        codigo[3] = "-..";  //d
        codigo[4] = ".";    //e
        codigo[5] = "..-."; //f
        codigo[6] = "--.";  //g
        codigo[7] = "...."; //h
        codigo[8] = "..";   //i
        codigo[9] = ".---"; //j
        codigo[10] = "-.-"; //k
        codigo[11] = ".-..";//l
        codigo[12] = "--";  //m
        codigo[13] = "-.";  //n
        codigo[14] = "---"; //o
        codigo[15] = ".--.";//p
        codigo[16] = "--.-";//q
        codigo[17] = ".-."; //r
        codigo[18] = "..."; //s
        codigo[19] = "-";   //t
        codigo[20] = "..-"; //u
        codigo[21] = "...-";//v
        codigo[22] = ".--"; //w
        codigo[23] = "-..-";//x
        codigo[24] = "-.--";//y
        codigo[25] = "--..";//z
        codigo[26] = " ";   //espacio
        codigo[27] = "-----";//0
        codigo[28] = ".----";//1
        codigo[29] = "..---";//2
        codigo[30] = "...--";//3
        codigo[31] = "....-";//4
        codigo[32] = ".....";//5
        codigo[33] = "-....";//6
        codigo[34] = "--...";//7
        codigo[35] = "---..";//8
        codigo[36] = "----.";//9
        System.out.println(
                "|-----------------------------------Lista de codigo morse-----------------------------------|");
        for (int i = 0; i < 13; i++) {
            System.out.print("[" + letras.charAt(i) + "]" + codigo[i] + " ");
        }
        System.out.println("");
        for (int i = 13; i < 26; i++) {
            System.out.print("[" + letras.charAt(i) + "]" + codigo[i] + " ");
        }
        System.out.println("");
        for (int i = 26; i < 37; i++) {
            System.out.print("[" + letras.charAt(i) + "]" + codigo[i] + " ");
        }
        System.out.println(
                "\n|-------------------------------------------------------------------------------------------|");
        System.out.println("Codigo morse a traducir");//peticion de codigo morse
        mensaje = leer.nextLine();//Entrada de texto
        String oracion[] = mensaje.split(" ");
        int max = oracion.length;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 37; j++) {
                if (oracion[i].equals(codigo[j])) {
                    morse = morse + letras.charAt(j);
                    break;
                }
            }
        }

        return morse.trim();
    }
}
