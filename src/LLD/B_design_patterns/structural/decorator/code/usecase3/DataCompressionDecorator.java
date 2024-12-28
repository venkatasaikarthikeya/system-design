package LLD.B_design_patterns.structural.decorator.code.usecase3;

public class DataCompressionDecorator extends DataDecorator {


    public DataCompressionDecorator(Writable writable) {
        super(writable);
    }

    private String compress(String data) {
        int n = data.length();
        StringBuilder compressedData = new StringBuilder();
        int lo = 0, hi = 0, cnt = 0;
        for (; hi < n; hi++) {
            if (data.charAt(lo) == data.charAt(hi)) {
                cnt += 1;
            } else {
                compressedData.append(data.charAt(lo));
                compressedData.append(cnt);
                cnt = 1;
                lo = hi;
            }
        }
        compressedData.append(data.charAt(lo));
        compressedData.append(cnt);
        return compressedData.toString();
    }

    @Override
    public void writeToFile(String data) {
        String compressedData = compress(data);
        System.out.println("Compressed the data.... COMPRESSED DATA: " + compressedData);
        writable.writeToFile(compressedData);
    }
}
