import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author xiaoming
 * @create 2018-10-23-20:57
 */
@javax.servlet.annotation.WebServlet(name = "DownloadServlet",urlPatterns = "/download")
public class DownloadServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //获取请求参数
        String filename = request.getParameter("filename");

        //根据文件名获取文件流对象
        ServletContext servletContext = request.getServletContext();

        InputStream is = servletContext.getResourceAsStream(filename);

        //根据后缀获取文件类型
        String mimeType = servletContext.getMimeType(filename);

        //告知浏览器下载文件
        response.setHeader("content-disposition","attachment;filename="+filename);//附件
        response.setHeader("content-type",mimeType);

        //response对象获取输出流
        OutputStream os = response.getOutputStream();

        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len=is.read(bytes))!=-1){
            os.write(bytes,0,len);
        }

        os.close();
        is.close();

    }
}
