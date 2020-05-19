package www.gzhou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.gzhou.dao.AnaSumDao;
import www.gzhou.domain.WordForm;
import www.gzhou.service.AnalyzerService;

import java.util.ArrayList;

@Service
public class AnalyzerServiceImpl implements AnalyzerService {
    /**
     * public static void main(String[] args) {
     AnalyzerDao analyzer = new AnalyzerDao("E:\\桌面文件路径\\编译原理\\input.txt","E:\\桌面文件路径\\编译原理\\output.txt");//输入输出可自己修改，文件放在当前文件夹下，刷新项目就可以看到了
     analyzer.analyze(analyzer.getContent());
     }
     */

    @Autowired
    private AnaSumDao anaSumDao;


    /**
     * 主要处理存储在磁盘中的业务
     * @param inpath
     * @param outpout
     */
    @Override
    public ArrayList<WordForm> AnalyzerService(String inpath, String outpout) {
        anaSumDao.Read_newFile(inpath,outpout);
        ArrayList<WordForm> li = anaSumDao.analyzedao(anaSumDao.getContent());
        return li;
    }

}
