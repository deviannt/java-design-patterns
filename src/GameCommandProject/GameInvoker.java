package GameCommandProject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameInvoker {
    private Command[] slots = new Command[6];
    private Command lastCommand;
    private ExecutorService executorService;

    public GameInvoker() {
        executorService = Executors.newFixedThreadPool(1); // Используем 1 поток
    }

    public void setCommand(int slot, Command command) {
        if (slot >= 0 && slot < slots.length) {
            slots[slot] = command;
        }
    }

    public void pressButton(int slot) {
        if (slots[slot] != null) {
            executorService.submit(slots[slot]::execute); // Выполнение команды в потоке
            lastCommand = slots[slot];
        } else {
            System.out.println("Команда в слоте " + slot + " не назначена");
        }
    }

    public void pressUndo() {
        if (lastCommand != null) {
            executorService.submit(lastCommand::undo); // Отмена команды в потоке
        } else {
            System.out.println("Нет команды для отмены");
        }
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
