package LLD.B_design_patterns.structural.decorator.code.usecase2;

public class SMSNotifier extends NotificationDecorator {

    public SMSNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void notify(String alert) {
        super.notify(alert);
        System.out.println("Notifying the user via SMS....MESSAGE: " + alert);
    }
}
