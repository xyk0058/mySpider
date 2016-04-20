package mySpider;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;

import org.apache.http.annotation.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.utils.FilePersistentBase;

/**
 * Store results in files.<br>
 *
 * @author code4crafter@gmail.com <br>
 * @since 0.1.0
 */
@ThreadSafe
public class FilePipeline extends FilePersistentBase implements Pipeline {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * create a FilePipeline with default path"/data/webmagic/"
     */
    public FilePipeline() {
        setPath("/Users/xyk0058/Desktop/spiderResult/");
    }

    public FilePipeline(String path) {
        setPath(path);
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        String path = this.path + "data.txt";
        try {
            PrintWriter printWriter = new PrintWriter(
            		new OutputStreamWriter(new FileOutputStream(getFile(path),true),"UTF-8"));
            printWriter.println("url:\t" + resultItems.getRequest().getUrl());
            //System.out.println("get page: " + resultItems.getRequest().getUrl());
            //遍历所有结果，输出到控制台，上面例子中的"author"、"name"、"readme"都是一个key，其结果则是对应的value
//            for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
//                System.out.println(entry.getKey() + ":\t" + entry.getValue());
//            }
            printWriter.close();
        } catch (IOException e) {
            logger.warn("write file error", e);
        }
    }
}
