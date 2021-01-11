package Main;
import java.io.*;//импорт пакета, содержащего классы для
//ввода/вывода
import java.net.*;//импорт пакета, содержащего классы для работы в
//сети Internet

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        String a = "Для тренировки AI применялся метод мультимодального обучения. " +
                "Разработчики сочетали текст и картинки — последние были нужны для контекста, чтобы модель могла лучше угадывать, когда в слова вложен скрытый смысл. " +
                "Акцент сделан на анализе различий между текстом и сопровождающим его изображением — противоречие считается главным признаком сарказма. " +
                "Результаты объединяются и на основе этого модель делает предположения. " +
                "Помимо этого, чтобы лучше понять посыл автора, нейросеть сравнивает хэштеги с содержанием твитов. " +
                "В тестах модель смогла идентифицировать сарказм с точностью в 86%. Материалы исследования опубликованы учёными из Китайской академии наук и Института информационной " +
                "инженерии в Пекине. Совместную работу представили на этой неделе на конференции Empirical Methods in Natural Language Processing. " +
                "Исследователи считают, что такая модель упростит анализ эмоций и понимание мнения масс по тем или иным вопросам." +
                " В этом году Facebook тоже начала применять модели на базе мультимодального обучения, чтобы отлавливать больше обидных и нарушающих правила мемов.";
        String[] strings = a.split("\\.");
        String resiv = "";

        ServerSocket serverSocket = null;
        Socket clientAccepted     = null;//объявление объекта класса Socket
        ObjectInputStream  sois   = null;//объявление байтового потока ввода
        ObjectOutputStream soos   = null;//объявление байтового потока вывода
        try 
		{
            System.out.println("сервер запущен....\nожидаем подключение....");
            serverSocket = new ServerSocket(2525);//создание сокета сервера для //заданного порта
            clientAccepted = serverSocket.accept();//выполнение метода, который //обеспечивает реальное подключение сервера к клиенту
            System.out.println("подключение выполнено....");
//создание потока ввода soos = new
            sois = new ObjectInputStream(clientAccepted.getInputStream());
            soos = new ObjectOutputStream(clientAccepted.getOutputStream());//создание потока
//вывода
            String clientMessageRecieved = (String)sois.readObject();//объявление //строки и присваивание ей данных потока ввода, представленных
//в виде строки (передано клиентом)
            while(!clientMessageRecieved.equals("quite"))//выполнение цикла: пока
//строка не будет равна «quite»
            {
                System.out.println("Полученное слово: "+clientMessageRecieved);

                for (int i = 0 ; i< strings.length; i++)
                {
                    String[] words = strings[i].split("[,\\s]+");
                    for (int j = 0; j< words.length; j++)
                        if (words[j].equals(clientMessageRecieved)) resiv += "Предложение " + (i+1) + ": " + strings[i] +"\n" ;
                }
                if (resiv.equals("")) resiv = "Такого слова нет в тексте";
                soos.writeObject(resiv);//потоку вывода
//присваивается значение строковой переменной (передается клиенту)
                resiv = "";
                clientMessageRecieved = (String)sois.readObject();//строке
//присваиваются данные потока ввода, представленные в виде строки
//(передано клиентом)
            }   
		}catch(Exception e)	
		{
        } finally {
            try {
                sois.close();//закрытие потока ввода
                soos.close();//закрытие потока вывода
                clientAccepted.close();//закрытие сокета, выделенного для клиента
                serverSocket.close();//закрытие сокета сервера
            } catch(Exception e) {
                e.printStackTrace();//вызывается метод исключения е
            }
        }

    }
}
