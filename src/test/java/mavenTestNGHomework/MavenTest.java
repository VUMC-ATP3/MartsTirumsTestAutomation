package mavenTestNGHomework;

import com.github.lalyos.jfiglet.FigletFont;

import javax.imageio.IIOException;
import java.io.IOException;

public class MavenTest {
    public static void main(String[] args) throws IOException {
        String vardsUzvards = FigletFont.convertOneLine("MARTS TĪRUMS");
        System.out.println(vardsUzvards);
    }

}
