import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class MyClient implements Runnable
{
    @Override
    public void run() {
        try{
            // ������ ����� ������� (� ������ ������ localhost)
            InetAddress address = InetAddress.getByName(null);
            Socket socket = new Socket(address, 8080);

            BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())), true);

            // �������� 5 ������� �� ������
            for (int i = 0; i < 5; i++) {
                out.println("Hello " + i);
                String str = in.readLine();
                System.out.println(str);
            }

            // �������� ������� �� ��������� �����
            out.println("BYE");

            socket.close();


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}