package Main;

import java.net.*;
import java.io.*;

public class Main {//описание класса клиента

    public void runClient() throws IOException
    {//метод клиента runClient
        boolean flag = false;
        DatagramSocket s = null;//создание дейтаграммы
        try
        {
            byte[] buf = new byte[512]; //буфер для приема/передачи дейтаграммы
            s = new DatagramSocket();//привязка сокета к реальному объету
            System.out.println("UDPClient: Started");
            String number1 = " ";
            String number2 = " ";
            String number3 = " ";
            String numbers = "";
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));//создание

            System.out.println("Введите x: ");
            number1 = stdin.readLine();
            System.out.println("Введите y: ");
            number2 = stdin.readLine();
            System.out.println("Введите z: ");
            number3 = stdin.readLine();
            numbers = number1 + " " + number2 + " " + number3;
            DatagramPacket sendPacket = new DatagramPacket(numbers.getBytes(), numbers.getBytes().length, InetAddress.getByName("127.0.0.1"), 8001);//создание
//дейтаграммы для отсылки данных
            DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);//создание дейтаграммы для получения данных
            while(true)
            {

                s.send(sendPacket);
                s.receive(recvPacket);//получение дейтаграммы
                String result = new String(recvPacket.getData());//извлечение данных (версии сервера)
                System.out.println("UDPClient: Ответ: " + result);
                System.out.println("\nЖелаете продолжить? (0 - нет): ");

                String choos = stdin.readLine();
                if (choos.equals("0"))
                {
                    System.out.println("UDPClient: Ended");
                    numbers = "quit";
                    sendPacket.setData(numbers.getBytes());//установить массив посылаемых данных
                    sendPacket.setLength(numbers.getBytes().length);//установить длину посылаемых данных
                    s.send(sendPacket);
                    break;
                }
                else
                {
                    System.out.println("Введите x: ");
                    number1 = stdin.readLine();
                    System.out.println("Введите y: ");
                    number2 = stdin.readLine();
                    System.out.println("Введите z: ");
                    number3 = stdin.readLine();
                    numbers = number1 + " " + number2 + " " + number3;
                    sendPacket.setData(numbers.getBytes());//установить массив посылаемых данных
                    sendPacket.setLength(numbers.getBytes().length);//установить длину посылаемых данных
                }
            }

        }
        finally
        {
            if (s != null) s.close();//закрытие сокета клиента
        }
    }


    public static void main(String[] args) {//метод main
        try
        {
            Main client = new Main();//создание объекта client
            client.runClient();//вызов метода объекта client
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
