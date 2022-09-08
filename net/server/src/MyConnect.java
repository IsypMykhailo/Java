import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyConnect extends Thread implements Runnable
{
    static List<MyConnect> connectList = new ArrayList<MyConnect>();

    Socket socket;
    BufferedReader in;
    PrintWriter out;

    /**
     * ������ ������ � ����������� �� ������ 1 ������
     * @param socket
     */
    public MyConnect(Socket socket) {
        try {
            this.socket = socket;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            connectList.add(this);
        } catch (Exception ex) {
            System.out.println(" ������ �������� ������ ������");
            System.out.println(ex.getMessage());
        }
    }

    /**
     * ����� ���������� ��������� � �����
     * @param msg
     */
    public void sendMessage(String msg) {
        out.println(msg);
    }

    /**
     * ����� ���������� ��������� � ���� ��������
     * @param msg
     */
    public void sendMessageToAll(String msg) {
        for (MyConnect c:connectList
        ) {
            c.sendMessage(msg);
        }
        System.out.println("Send: " + msg);
    }


    @Override
    public void run() {
        try {
            while (true) {
                String msg = in.readLine();
                if(msg.equals("BYE")) {
                    break;
                }
                sendMessageToAll(msg);
            }
        } catch (Exception ex) {
            System.out.println(" ������ �������� ������ ������");
            System.out.println(ex.getMessage());
        } finally {
            System.out.println(" ������ ���������� ");
            connectList.remove(this);
        }

    }

}