import java.net.*;
import java.io.*;
import java.util.Arrays;

public class Main

{
    public final static int DEFAULT_PORT = 8001;//определение порта
    public final String QUIT_CMD = "quit";//определение команды «выход»
    File file = new File("D:\\java\\laba4\\laba4b\\server\\src\\data.txt");
    StringBuilder sb = new StringBuilder();

    public void runServer() throws IOException
    {//метод сервера runServer
        DatagramSocket s = null;//создание объекта DatagramSocket
        try {
            boolean stopFlag = false;//создание флага stopFlag и его инициализация
//значением false
            byte[] buf = new byte[512];//буфер для приема/передачи дейтаграммы
            s = new DatagramSocket(DEFAULT_PORT);//привязка сокета к реальному объекту с портом DEFAULT_PORT
            System.out.println("UDPServer: Сервер запущен " + s.getLocalAddress() + ":"
                    + s.getLocalPort());//вывод к консоль сообщения

            while(!stopFlag)
            {//цикл до тех пор, пока флаг не примет значение true
                DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);//создание объекта дейтаграммы для получения данных
                s.receive(recvPacket);//помещение полученного содержимого в объект дейтаграммы
                String cmd = new String(recvPacket.getData()).trim();//извлечение команды из пакета
                if (cmd.equals(QUIT_CMD))
                {
                    stopFlag = true;//остановка сервера
                    continue;
                }
                System.out.println("UDPServer: числа: " + cmd);
                DatagramPacket sendPacket = new DatagramPacket(buf, 0, recvPacket.getAddress(), recvPacket.getPort());//формирование объекта                                                                  // дейтаграммы для отсылки данных
                int n = 0;//количество байт в ответе
                String [] numbers = cmd.split(" ");
                cmd = "";
                int x = Integer.parseInt(numbers[0]);
                int y = Integer.parseInt(numbers[1]);
                int z = Integer.parseInt(numbers[2]);
                double result = Math.pow(Math.exp(1), Math.abs(x+y)) * Math.pow(Math.abs(x-y), x+y) / (Math.atan(x) + Math.tan(z)) + Math.pow(Math.pow(x,6) + Math.pow(Math.log(y),2), 1./2);
                String str = String.format("%.9f", result);
                n = str.getBytes().length;
                System.arraycopy(str.getBytes(), 0, buf, 0, str.getBytes().length);
                sendPacket.setData(buf);//установить массив посылаемых данных
                sendPacket.setLength(n);//установить длину посылаемых данных
                s.send(sendPacket);//послать сами данные
                FileRead();
                FileWrite(str, x, y, z);
                for (int j=0; j<buf.length; j++) buf[j] = ' ';
                result = 0;
                sb.delete(0, sb.length());
            } // while(server is not stopped)
            System.out.println("UDPServer: остановлен");
        }
        finally {
            if (s != null) {
                s.close();//закрытие сокета сервера
            }
        }
    }

    public void FileWrite(String result, int x, int y, int z)
    {
        try {
            //проверяем, что если файл не существует то создаем его
            if(!file.exists()){
                file.createNewFile();
            }

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Записываем текст у файл
                if (sb.toString().equals(""))
                    out.print("При х=" + Integer.toString(x) + " при у=" +Integer.toString(y) + " при z=" +
                            Integer.toString(z) + " Ответ=" + result);
                else out.print(sb.toString() + "При х=" + Integer.toString(x) + " при у=" +Integer.toString(y) + " при z=" +
                        Integer.toString(z) + " Ответ=" + result);
            } finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void  FileRead()
    {
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {//метод main
        try
        {
            Main udpSvr = new Main();//создание объекта udpSvr
            udpSvr.runServer();//вызов метода объекта runServer
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
