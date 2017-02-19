package com.shsuger.SpringFileScan.service.impl;

import com.shsuger.SpringFileScan.service.FileScannerService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shsuger on 2017/2/18.
 */
@Service
public class FileScannerServiceImpl implements FileScannerService {


    private static String sop_path;
    private static String keyWord;
    private static java.util.ArrayList<String> totalFileList = new ArrayList<String>();
    private static ArrayList<String> normalTransNameList = new ArrayList<String>();
    private static ArrayList<String> normalTransCodeList = new ArrayList<String>();

    @Override
    public ArrayList<String> getTransCodeList(String keyword,String rootPath,String sopFilePath){
        sop_path = sopFilePath;
        keyWord = keyword.toString().toLowerCase();
        getTotalFile((java.lang.String) rootPath);
        try {
            for(java.lang.String transName:normalTransNameList){
                getTransCode(transName);
            }
        }catch (Exception e){

        }


        return normalTransCodeList;


    }

    private static void getTotalFile(String filePath){
        String absolutePath;
        int index;
        File root = new File(filePath);
        File[] files = root.listFiles();
        assert files != null;
        for(File file:files){
            absolutePath = file.getAbsolutePath();
            if(file.isDirectory()){
                getTotalFile(absolutePath);
            }else{
                index = absolutePath.lastIndexOf(".");
                if(index!=-1){
                    String suffix = absolutePath.substring(index);
                    if(".java".equals(suffix)){
                        totalFileList.add(absolutePath);
                        try{
                            getTransName(absolutePath);
                        }catch (Exception e){

                        }

                    }
                }
            }
        }
    }
    private static void getTransName(String filePath) throws IOException {
        BufferedReader targetFileBr = null;
        String targetFileLine;
        String[] lineArray;
        String transName;
        try {
            targetFileBr = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));

            while ((targetFileLine = targetFileBr.readLine()) != null) {
                Pattern p = Pattern.compile(keyWord);
                Matcher m = p.matcher(targetFileLine.toLowerCase().trim());
                if (m.find()) {
                    lineArray = targetFileLine.split("\"");
                    try {
                        transName = lineArray[1];
                        if (!normalTransNameList.contains(transName)) {
                            normalTransNameList.add(transName);
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {


                        //string = "";
						/*string = filterStr + "\t" + count + "\t"+ file.getAbsolutePath() + "\t" + str + "\t" ;
						basicOutputStream.write(string.getBytes());
						basicOutputStream.write("\r\n".getBytes());*/
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (targetFileBr != null) {
                    targetFileBr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    private static void getTransCode(String TransName) throws IOException{
        String sopLine;
        File sopFile;
        sopFile = new File(sop_path);
        BufferedReader sopBr = new BufferedReader(new InputStreamReader(new FileInputStream(sopFile)));

        String tranNameInSop;
        String tranCode;
        while ((sopLine = sopBr.readLine()) != null) {
            if(sopLine.contains("=")){
                String[] sopArray = sopLine.split("=");
                if(sopArray.length >= 2){
                    tranNameInSop = sopArray[0].trim();
                    tranCode = sopArray[1].trim().substring(1, 5);

                    if(tranNameInSop.equals(TransName.trim())||TransName.equals(tranCode)){
                        if(!normalTransCodeList.contains(tranCode)){
                            normalTransCodeList.add(tranCode);
                        }
                    }
                }
            }
        }
    }

}
