import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer implements Runnable
{
    private static final int PORT = 8080;


    @Override
    public void run() {

        try {
            // Создаю экземпляр сервера
            ServerSocket srv = new ServerSocket(PORT);
            System.out.println("Ожидаю соединения: ");
            try {

                while (true) {
                    Socket socket = srv.accept();
                    System.out.println("Соединение произошло: " + socket);
                    MyConnect c= new MyConnect(socket);
                    c.start();
                }


                // Можем создавать новый поток. Зациклить ожидание соединений и так далее

//                // Получаю поток на вход
//                BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
//                // Поток на вывод
//                PrintWriter out = new PrintWriter(new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())), true);
//
//                while (true) {
//                    // Читаю очередную строку
//                    String str = in.readLine();
//                    // Если эта строка -  команда END - выхожу из чтения потока
//                    if(str.equals("END")) {
//                        break;
//                    }
//                    out.println(str);
//                    // Вывожу входящую информацию на экран сервера
//                    System.out.println(str);
//                }



            }catch (Exception ex) {
                System.out.println(" Ошибка чтения данных");
                System.out.println(ex.getMessage());
            } finally {
                //socket.close();
                srv.close();
            }
        }
        catch (Exception ex) {
            System.out.println("Ошибка создания сервера");
            System.out.println(ex.getMessage());
        }


    }
}