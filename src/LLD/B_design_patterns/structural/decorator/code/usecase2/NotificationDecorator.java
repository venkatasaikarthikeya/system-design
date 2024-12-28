package LLD.B_design_patterns.structural.decorator.code.usecase2;

public abstract class NotificationDecorator implements Notifier {
    protected Notifier notifier;

    public NotificationDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void notify(String alert) {
        notifier.notify(alert);
    }
}
