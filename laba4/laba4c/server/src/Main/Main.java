package Main;
import java.io.*;//импорт пакета, содержащего классы для
//ввода/вывода
import java.net.*;//импорт пакета, содержащего классы для работы в
//сети Internet

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientAccepted = null;//объявление объекта класса Socket
        InputStream sois = null;//объявление байтового потока ввода
        OutputStream soos = null;//объявление байтового потока вывода
        String resiv = "";
        while (true) {
            try {
                System.out.println("сервер запущен....\nожидаем подключение....");
                serverSocket = new ServerSocket(2525);//создание сокета сервера для //заданного порта
                clientAccepted = serverSocket.accept();//выполнение метода, который //обеспечивает реальное подключение сервера к клиенту
                System.out.println("подключение выполнено....");

                sois = clientAccepted.getInputStream(); //создание потока ввода soos = new
                soos = clientAccepted.getOutputStream();//создание потока вывода
                byte[] buf = new byte[1024];
                for (int i = 0; i < buf.length; i++) buf[i] = ' ';
                sois.read(buf);
                String clientMessageRecieved = new String(buf, "UTF-8");//объявление строки и присваивание ей данных потока ввода, представленных
//в виде строки (передано клиентом)
                while (!clientMessageRecieved.equals("quite"))//выполнение цикла: пока
//строка не будет равна «quite»
                {
                    System.out.println("Полученные слова: " + clientMessageRecieved);
                    String[] words = clientMessageRecieved.toLowerCase().split(" ");
                    if (words[0].equals(words[1])) resiv = "Истина";
                    else resiv = "Ложь";
                    soos.write(resiv.getBytes());//потоку вывода
//присваивается значение строковой переменной (передается клиенту)
                    resiv = "";
                    for (int i = 0; i < buf.length; i++) buf[i] = ' ';
                    sois.read(buf);
                    clientMessageRecieved = new String(buf, "UTF-8");
                }
            } catch (Exception e) {
            } finally {
                try {
                    sois.close();//закрытие потока ввода
                    soos.close();//закрытие потока вывода
                    clientAccepted.close();//закрытие сокета, выделенного для клиента
                    serverSocket.close();//закрытие сокета сервера
                } catch (Exception e) {
                    e.printStackTrace();//вызывается метод исключения е
                }
            }

        }
    }
}