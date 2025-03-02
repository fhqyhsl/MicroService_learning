package zyx.requestservice.Crawler;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

/**
 * @author mqxu
 * @date 2025/2/28
 * @description NewsCrawler
 **/
public class NewsCrawler {
    private static final String TARGET_URL = "https://www.sohu.com/a/864908082_120849665?edtsign=CEF4D3E6CA1E4C415E9B057EA39F6CC52ECA769F&edtcode=xW5WLWm834RlWgB9uxAiFw%3D%3D&scm=thor.282_14-200000.0.0.&ace=F1E2EE24567F9AC564C083A6441555BB670B85AC&spm=smpc.home.top-news1.1.1740707069819xP7I6kr_1467";

    public static void main(String[] args) {
        // 1. 创建 HttpClient 实例（带连接池配置）
        try (CloseableHttpClient httpClient = HttpClients.custom()
                .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36")
                .build()) {
            // 2. 构建 GET 请求
            HttpGet httpGet = new HttpGet(TARGET_URL);
            httpGet.addHeader("Accept-Language", "zh-CN,zh;q=0.9");
            // 3. 执行请求并解析响应
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String html = EntityUtils.toString(entity, "UTF-8");
                    // 4. 使用HtmlCleaner解析HTML
                    HtmlCleaner cleaner = new HtmlCleaner();
                    TagNode rootNode = cleaner.clean(html);
                    // 5. XPath 定位标题元素（需根据实际页面结构调整）
                    Object[] titleNodes = rootNode.evaluateXPath("//*[@id=\"mp-editor\"]/p");

                    System.out.println(titleNodes.length);
                    // 6. 输出结果
                    System.out.println("----- 最新新闻标题 -----");
                    for (Object node : titleNodes) {
                        if (node instanceof TagNode) {
                            System.out.println(((TagNode) node).getText());
                        } else if (node instanceof String) {
                            System.out.println(node);
                        }
                    }
                }
            }
        } catch (XPatherException e) {
            System.err.println("XPath解析失败，请检查表达式：" + e.getMessage());
        } catch (Exception e) {
            System.err.println("请求异常：" + e.getMessage());
        }
    }
}
