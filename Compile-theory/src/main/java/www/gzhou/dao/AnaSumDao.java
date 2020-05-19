package www.gzhou.dao;

import org.springframework.stereotype.Repository;
import www.gzhou.domain.WordForm;

import java.util.ArrayList;


public interface AnaSumDao {

    /**
     * 主要的逻辑实现
     * @param fileContent
     * @return
     */
    public ArrayList<WordForm> analyzedao(String fileContent);

    /**
     * 赋值函数（两个路径）
     * @param input
     * @param output
     */
    public void Read_newFile(String input, String output);

    /**
     * 获取文本信息
     * @return
     */
    public String getContent();


}
