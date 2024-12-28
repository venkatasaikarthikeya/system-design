package LLD.B_design_patterns.structural.decorator.code.usecase3;

public class WritableMain {

    public static void main(String[] args) {

        // Base
        FileWriter fileWriter = new FileWriter();

        // Decorator - Compress
        DataCompressionDecorator compressed = new DataCompressionDecorator(fileWriter);

        // Decorator - Encrypt
        DataEncryptionDecorator encrypted = new DataEncryptionDecorator(compressed);

        // Operation
        encrypted.writeToFile("eddcbbbbaa");
    }
}
