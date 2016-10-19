// 코드 7.7  Part인터페이스: 스프링의 MultipartFile의 대안

package javax.servlet.http;
import java.io.*;
import java.util.*;

public interface Part {
    public InputStream getInputStream() throws IOException;
    public String getContentType();
    public String getName();
    public String getSubmittedFileName();
    public long getSize();
    public void write(String fileName) throws IOException;
    public void delete() throws IOException;
    public String getHeader(String name);
    public Collection<String> getHeaders(String name);
    public Collection<String> getHeaderNames();
}
