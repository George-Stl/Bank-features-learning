package GitRepositoryVSC;
import java.util.Scanner;

public class ClientListSort {
    public static String [] surname;
    public static void main(String[]args) {
        
        double[][] clientList = clientMatrix();
        clientList = bankAccounts(clientList);
        printArray(clientList);
        System.out.print("\n\n");
        printSortedArray(clientList);
        


    }

    public static double[][] clientMatrix(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество клиентов (не более 10) и количество счетов у каждого через пробел: ");
        int numberOfClients = in.nextInt();
        int numberOfBankAccounts = in.nextInt();
        if(numberOfClients < 1 || numberOfClients > 10){
            System.out.print("Количество клиентов должно быть от 1 до 10. Введите ещё раз: ");
            numberOfClients = in.nextInt();
        }
        
        return new double [numberOfClients][numberOfBankAccounts];
    }
    public static double[][] bankAccounts(double[][] clientList){
        for(int row = 0; row < clientList.length; row++){
            for(int column = 0; column < clientList[row].length; column++){
                clientList[row][column] = (int)((1 + Math.random() * 10_001) * 100) / 100.0;  
            }
        }
        return clientList;
    }
    public static void printArray(double[][] clientList){
        Scanner in = new Scanner(System.in);
        if (clientList.length == 1){
            System.out.print("Введите " + clientList.length + " фамилию клиента: ");
        } else if(clientList.length < 5){
            System.out.print("Введите " + clientList.length + " фамилии клиентов через пробел: ");
        } else {
            System.out.print("Введите " + clientList.length + " фамилий клиентов через пробел: ");
        }
        surname = new String[clientList.length];
        for (int i = 0; i < clientList.length; i++){
            surname[i] = in.next();
        }
        System.out.println();

        


        System.out.print("Номер банковского счета клиента:\t");
        for(int i = 1; i < clientList[0].length + 1; i++){
            System.out.print(i + "\t\t");
        }
        System.out.println("\n");
        for (int i = 0; i < clientList.length; i++){
            System.out.print(surname[i] + "\r");
            System.out.print("\t\t\t\t     ");
            for (int column = 0; column < clientList[i].length; column++){
                System.out.print(clientList[i][column] + "\t     ");
            }
            System.out.println();
        }
    }
    //метод, сортирующий данные в строках по возрастанию
    // и печатающий отсортированный массив
    public static void printSortedArray(double[][]list){
        for (int row = 0; row < list.length; row++){
            
            for(int l = 0; l < list[row].length - 1; l++ ){
                double minValue = list[row][l];
                int indexMin = l;
                for(int column = l + 1; column < list[row].length; column++){
                    
                    if(minValue > list[row][column]){
                        minValue = list[row][column];
                        indexMin = column;
                    }
                }    
                if(indexMin != l){
                    list[row][indexMin] = list[row][l];
                    list[row][l] = minValue;
                }
                                        
                
                
            }
            
        }
        System.out.print("\n\n\r\t\t\t\t\t Отсортированный массив: \n\n");
        System.out.print("Номер банковского счета клиента:\t");
        for(int i = 1; i < list[0].length + 1; i++){
            System.out.print(i + "\t\t");
        }
        System.out.println("\n");
        for (int i = 0; i < list.length; i++){
            System.out.print(surname[i] + "\r");
            System.out.print("\t\t\t\t     ");
            for (int column = 0; column < list[i].length; column++){
                System.out.print(list[i][column] + "\t     ");
            }
            System.out.println();
        }

        


        

    }

}
