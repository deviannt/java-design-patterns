import java.util.LinkedList;
import java.util.Queue;

// Singleton для хранения заявок
class SupportQueue {
    private static volatile SupportQueue instance;
    private final Queue<String> requests;

    private SupportQueue() {
        requests = new LinkedList<>();
    }

    //потокобезопасный двойная проверка
    public static SupportQueue getInstance() {
        if (instance == null) {
            synchronized (SupportQueue.class) {
                if (instance == null) {
                    instance = new SupportQueue();
                }
            }
        }
        return instance;
    }

    //добавление новую заявку в очередь(FIFO)
    public synchronized void addRequest(String request) {
        requests.offer(request);
        System.out.println("Новая заявка: " + request);
    }

    public synchronized void processRequest() {
        if (!requests.isEmpty()) {
            String request = requests.poll();
            System.out.println("Обработана заявка: " + request);
        } else {
            System.out.println("Нет новых заявок для обработки.");
        }
    }
}

// поток, создающий заявки
class RequestGenerator extends Thread {
    private final SupportQueue queue;
    private int requestCount = 1;

    public RequestGenerator() {
        this.queue = SupportQueue.getInstance();
    }

    @Override
    public void run() {
        while (true) {
            queue.addRequest("Заявка #" + requestCount++);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Поток, обрабатывающий заявки
class RequestProcessor extends Thread {
    private final SupportQueue queue;

    public RequestProcessor() {
        this.queue = SupportQueue.getInstance();
    }

    @Override
    public void run() {
        while (true) {
            queue.processRequest();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Главный класс
public class Singleton {
    public static void main(String[] args) {
        RequestGenerator generator = new RequestGenerator();
        RequestProcessor processor = new RequestProcessor();

        generator.start();
        processor.start();
    }
}
