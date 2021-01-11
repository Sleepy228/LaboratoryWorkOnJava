import java.io.*;//импорт пакета, содержащего классы для
// ввода/вывода
import java.net.*;//импорт пакета, содержащего классы для
// работы в сети
public class Main {
    public static void main(String[] arg) {
        try {
            System.out.println("Соединение с сервером....");

            Socket clientSocket = new Socket("127.0.0.1",2525);//установление //соединения между локальной машиной и указанным портом узла сети
            System.out.println("Соединение выполнено....\n");
            BufferedReader stdin =
                    new BufferedReader(new InputStreamReader(System.in));//создание
//буферизированного символьного потока ввода
            ObjectOutputStream coos =
                    new ObjectOutputStream(clientSocket.getOutputStream());//создание
//потока вывода
            ObjectInputStream  cois =
                    new ObjectInputStream(clientSocket.getInputStream());//создание
//потока ввода
            System.out.println("Введите слово для поиска в тексте ('quite' − для завершения): ");
            String clientMessage = stdin.readLine();
            System.out.println("Вы ввели: "+clientMessage);
            while(!clientMessage.equals("quite"))
            {//выполнение цикла, пока строка //не будет равна «quite»
                System.out.println("\n---------------------------");
                coos.writeObject(clientMessage);//потоку вывода присваивается //значение строковой переменной (передается серверу)
                System.out.println("~сервер~:\n"+cois.readObject());//выводится на //экран содержимое потока ввода (переданное сервером)
                System.out.println("---------------------------\n");
                System.out.println("Введите слово для поиска в тексте ('quite' − для завершения): ");
                clientMessage = stdin.readLine();//ввод текста с клавиатуры
                System.out.println("Вы ввели: "+clientMessage);//вывод в
//консоль строки и значения строковой переменной
            }
            coos.close();//закрытие потока вывода
            cois.close();//закрытие потока ввода
            clientSocket.close();//закрытие сокета
        }catch(Exception e)	{
            e.printStackTrace();//выполнение метода исключения е
        }
    }
}
