import java.io.File;

/**
 * Created by huang on 2017/1/10.
 */
public class Test {
    public static void main(String args[]){
        File file=new File("F:\\workspace\\losg\\a");
        //System.out.println(file.getParentFile().exists());

        file.getParentFile().mkdirs();


    }
}
