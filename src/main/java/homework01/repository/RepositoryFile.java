package homework01.repository;

import java.io.*;
import java.util.List;

public class RepositoryFile implements Repository {
    String pathFile; // = pathProject.concat("/file.txt");
    File file;

    public RepositoryFile(String pathFile) {
        this.pathFile = pathFile;
        file = new File(pathFile);
    }

    @Override
    public String[] read() throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fr);
        String str;
        int sizeTextArray = 0;
        while((str = bufferedReader.readLine()) != null){
            sizeTextArray ++;
        }
        bufferedReader.close();

        String[] textArray = new String[sizeTextArray];
        int i = 0;
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(pathFile));
        while((str = bufferedReader1.readLine()) != null){
            textArray[i] = str;
            i++;
        }
        bufferedReader1.close();

        return textArray;
    }

    @Override
    public void write(List<String> lines) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        for(String line: lines){
            fileOutputStream.write(line.getBytes());
        }

        fileOutputStream.close();
    }
}
