package homework01;

import homework01.Controller.Controller;

import java.io.IOException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws IOException {
        // расположение файла с текстом переписки
        Controller controller = new Controller("src/main/java/homework01/ListMessage.txt");
        String[] getList = controller.open();
        ClientGUI clientGUI = new ClientGUI(getList);
        List<String> list = clientGUI.getAllMessages();

    }
}
