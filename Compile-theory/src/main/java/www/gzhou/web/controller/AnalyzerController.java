package www.gzhou.web.controller;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import www.gzhou.domain.WordForm;
import www.gzhou.service.AnalyzerService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



@Controller
@RequestMapping("/user")
@WebAppConfiguration("src/main/resources")
@ContextConfiguration({"classpath:springmvc.xml"})
public class AnalyzerController {

    @Autowired
    private AnalyzerService analyzerService;

    private static String inUrl = null;

    /**
     * 词法分析处理
     * @param
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping("/analyzer")
    public ModelAndView AnaltzerHandle(/*@RequestParam String input, @RequestParam String output*/)
            throws Exception{
        String input=inUrl;
        String output="F:\\编译原理\\output.txt";
      //  File output = new File("F:\\编译原理\\output.txt");

        ModelAndView mv = new ModelAndView();
//
//        List<Book> books = bookService.findBookByName(title);
//        mv.addObject("books",books);
//        mv.setViewName("bookList");
        if(input == null)
        {
            mv.setViewName("NotUrl");
            return mv;
        };
        ArrayList<WordForm> list = analyzerService.AnalyzerService(input,output);
       mv.addObject("worksList",list);
       mv.setViewName("analyResult");
        return mv;

    }

    @RequestMapping("/upload")
    public String upload()
    {
        return "fileUpload";
    }

    @RequestMapping("/doUpload")
    public String doUpload(@RequestParam("file")MultipartFile file){
        if (!file.isEmpty()){
            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File("F:\\编译原理\\"+file.getOriginalFilename()));
                inUrl = new String("F:\\编译原理\\"+file.getOriginalFilename());
              //  File file = new File("./mywork/work.txt");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }


}
