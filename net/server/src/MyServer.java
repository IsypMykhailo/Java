import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer implements Runnable
{
    private static final int PORT = 8080;


    @Override
    public void run() {

        try {
            // ������ ��������� �������
            ServerSocket srv = new ServerSocket(PORT);
            System.out.println("������ ����������: ");
            try {

                while (true) {
                    Socket socket = srv.accept();
                    System.out.println("���������� ���������: " + socket);
                    MyConnect c= new MyConnect(socket);
                    c.start();
                }


                // ����� ��������� ����� �����. ��������� �������� ���������� � ��� �����

//                // ������� ����� �� ����
//                BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
//                // ����� �� �����
//                PrintWriter out = new PrintWriter(new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())), true);
//
//                while (true) {
//                    // ����� ��������� ������
//                    String str = in.readLine();
//                    // ���� ��� ������ -  ������� END - ������ �� ������ ������
//                    if(str.equals("END")) {
//                        break;
//                    }
//                    out.println(str);
//                    // ������ �������� ���������� �� ����� �������
//                    System.out.println(str);
//                }



            }catch (Exception ex) {
                System.out.println(" ������ ������ ������");
                System.out.println(ex.getMessage());
            } finally {
                //socket.close();
                srv.close();
            }
        }
        catch (Exception ex) {
            System.out.println("������ �������� �������");
            System.out.println(ex.getMessage());
        }


    }
}