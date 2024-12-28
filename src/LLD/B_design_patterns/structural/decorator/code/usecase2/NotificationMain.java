package LLD.B_design_patterns.structural.decorator.code.usecase2;

public class NotificationMain {

    public static void main(String[] args) {

        // Base
        EmailNotifier emailNotifier = new EmailNotifier();

        // Decorators
        SMSNotifier smsNotifier = new SMSNotifier(emailNotifier);
        SlackNotifier slackNotifier = new SlackNotifier(smsNotifier);

        slackNotifier.notify("Today is a holiday");
    }
}
