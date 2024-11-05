package homework01.repository;

import java.io.IOException;
import java.util.List;

public interface Repository {
    String[] read() throws IOException;
    void write(List<String> lines) throws IOException;

}
