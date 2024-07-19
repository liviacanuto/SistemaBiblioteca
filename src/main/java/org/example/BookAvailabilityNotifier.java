import java.util.ArrayList;
import java.util.List;

public class BookAvailabilityNotifier{
    private List<User> subscribers;

    public void BookAvailabilityNotifier(){
    this.subscribers = new ArrayList<>();
    }

    public void subscribe(User user) {
    subscribers.add(user);
    }

    public void unsubscribe(User user) {
    subscribers.remove(user);
    }

    public void notifyNewBookAdded(Book book) {
    String message = "Novo livro adicionado ao catálogo: " + book.getTitle();
    sendNotification(message);
    }

    private void sendNotification(String message) {
    for (User subscriber : subscribers) {
        System.out.println("Enviando notificação para usuário: " + subscriber.getName() + " - Mensagem: " + message);
    }

}