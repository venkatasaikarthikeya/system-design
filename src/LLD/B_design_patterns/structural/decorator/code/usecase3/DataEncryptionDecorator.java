package LLD.B_design_patterns.structural.decorator.code.usecase3;

public class DataEncryptionDecorator extends DataDecorator {

    public DataEncryptionDecorator(Writable writable) {
        super(writable);
    }

    private String encrypt(String data) {
        int n = data.length();
        char[] dataChars = data.toCharArray();
        for (int lo = 0, hi = n - 1; lo < hi; lo++, hi--) {
            char temp = dataChars[lo];
            dataChars[lo] = dataChars[hi];
            dataChars[hi] = temp;
        }
        return new String(dataChars);
    }

    @Override
    public void writeToFile(String data) {
        String encryptedData = encrypt(data);
        System.out.println("Encrypted the data.... ENCRYPTED DATA: " + encryptedData);
        writable.writeToFile(encryptedData);
    }
}
