package www.gzhou.service;

import org.springframework.stereotype.Service;
import www.gzhou.domain.WordForm;

import java.util.ArrayList;


public interface AnalyzerService {

    /**
     * 处理磁盘业务
     * @param inpath
     * @param output
     */
    public ArrayList<WordForm> AnalyzerService(String inpath,String output);

}
