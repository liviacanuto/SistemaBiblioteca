package org.example;

import java.util.ArrayList;
import java.util.List;

public class BookAvailabilityNotifier {
    private List<User> subscribers;

    public BookAvailabilityNotifier() {
        this.subscribers = new ArrayList<>();
    }

    public void subscribe(User user) {
        subscribers.add(user);
    }

    public void unsubscribe(User user) {
        subscribers.remove(user);
    }

    public void notifyBookAvailable(Book book) {
        String message = "Livro '" + book.getTitle() + "' devolvido! " ;
        sendNotification(message);
    }

    private void sendNotification(String message) {
        for(User subscriber : subscribers) {
            System.out.println("Enviando notificação para usuário: " + subscriber.getName() + " - Mensagem: " + message);
        }
    }
}