package www.gzhou.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import www.gzhou.domain.WordForm;
import www.gzhou.service.AnalyzerService;

import java.util.List;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AnalyzerServiceImplTest {

    @Autowired
    private AnalyzerService analyzerService;

    @Test
    public void AnalyzerServiceTest() throws Exception {

       // analyzerService.Analyzer("E:\\桌面文件路径\\编译原理\\input.txt","E:\\桌面文件路径\\编译原理\\output.txt");
       List<WordForm> l1 = analyzerService.AnalyzerService("E:\\桌面文件路径\\编译原理\\input.txt","E:\\桌面文件路径\\编译原理\\output.txt");
        System.out.println("---------------------------------------------------------------------------------------------------\n\n\n");
        for(WordForm t1 : l1){
            System.out.println("("+t1.getWord()+":"+t1.getTypeCode()+")");
        }
    }
}