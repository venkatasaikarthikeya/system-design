package LLD.B_design_patterns.structural.decorator.code.usecase2;

public class EmailNotifier implements Notifier {

    @Override
    public void notify(String alert) {
        System.out.println("Notifying the user via email....MESSAGE: " + alert);
    }
}
