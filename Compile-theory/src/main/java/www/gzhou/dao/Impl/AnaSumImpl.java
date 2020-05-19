package www.gzhou.dao.Impl;

import org.springframework.stereotype.Repository;
import www.gzhou.dao.AnaSumDao;
import www.gzhou.domain.WordForm;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

@Repository
public class AnaSumImpl implements AnaSumDao {

    private File inputFile;
    private File outputFile;
    private String fileContent;
    private ArrayList<WordForm> list = new ArrayList<>();


    /**
     * 先将源程序中的注释和换行替换成空串
     * 然后扫描程序，在程序结束前将扫描到的词添加到list中
     * 最后把扫描结果保存到指定的文件中
     */
    @Override
    public ArrayList<WordForm> analyzedao(String fileContent) {
        int over = 1;
        WordForm word = new WordForm();
        ReadTableDao scanner = new ReadTableDao(fileContent.toCharArray());
        while (over != 0) {
            word = scanner.scan();
//			System.out.println("(" + word.getTypenum() + " ," + word.getWord() + ")"); //在控制台输出结果
            list.add(word);
            over = word.getTypeCode();
        }
        saveResult();
        return list;
    }

    @Override
    public void Read_newFile(String input, String output) {
        inputFile = new File(input);
        outputFile = new File(output);
    }


    /**
     * 从指定的文件中读取源程序文件内容
     * @return
     */
    @Override
    public String getContent() {
        StringBuilder stringBuilder = new StringBuilder();
        try(Scanner reader = new Scanner(inputFile)) {
            //
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                stringBuilder.append(line + "\n");
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return fileContent = stringBuilder.toString();
    }

    /**
     * 将结果写入到到指定文件中
     * 如果文件不存在，则创建一个新的文件
     * 用一个foreach循环将list中的项变成字符串写入到文件中
     */
    public void saveResult() {
        if (!outputFile.exists())
            try {
                outputFile.createNewFile();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        try(Writer writer = new FileWriter(outputFile)){
            for (WordForm word : list) {
                writer.write("(" + word.getTypeCode() + " ," + word.getWord() + ")\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
