package LLD.B_design_patterns.structural.decorator.code.usecase3;

    public class FileWriter implements Writable {

        @Override
        public void writeToFile(String data) {
            System.out.println("Writing the data: " + data + " to file");
        }
    }
