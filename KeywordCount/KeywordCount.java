import java.io.File;
import java.io.FileInputStream;

public class KeywordCount {
    static void summerize(String[] contents) {
        
        String StringTokenizer[] = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue ",
                                    "default", "do", "double", "else", "enum", "extends", "false", "final", "finally", "float", "for",
                                    "If", "goto", "Implements", "Import", "Instanceof", "Int", "interface", "long", "native", "new", "null",
                                    "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronize",
                                    "this", "throw", "throws", "transient", "true", "try", "void", "volatile", "while"};
        int[] count = new int[StringTokenizer.length];

        for (int i = 0; i < contents.length; i++){
            for(int j = 0; j < StringTokenizer.length; j++){
                if (contents[i].equals(StringTokenizer[j])){
                    count[j]++;
                }
            }
        }

        System.out.println();
        System.out.println(StringTokenizer[36] + ": " + count[36]);
        System.out.println(StringTokenizer[8] + ": " + count[8]);
        System.out.println(StringTokenizer[39] + ": " + count[39]);
        
    }
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FileDetails FileName");
            return;
        }

        String fileName = args[0];
        File file = new File(fileName);
        String line = "";

        try (FileInputStream stream = new FileInputStream(file)) {

            char[] contents = new char[(int)file.length()];

            for (int i = 0; i < contents.length; i++) {
                contents[i] = (char)stream.read();
                line += contents[i];
            }
            
            String[] contents2 = line.split("\\s+");
    
            summerize(contents2);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
