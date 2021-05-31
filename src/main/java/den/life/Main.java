package den.life;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        Terminal terminal = null;
        try {
            terminal = defaultTerminalFactory.createTerminal();
            terminal.enterPrivateMode();
            TerminalSize tsz = terminal.getTerminalSize();
            terminal.clearScreen();
            final String message = "Hello, world!";
            int y = tsz.getRows()/2;
            int x = (tsz.getColumns() - message.length())/2;
            terminal.setCursorPosition(x, y);
            terminal.putString(message);
            terminal.flush();
            terminal.readInput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (terminal != null) {
                try {
                    terminal.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
