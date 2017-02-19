package com.shsuger.SpringFileScan.service;

import java.util.ArrayList;

/**
 * Created by shsuger on 2017/2/18.
 */
public interface FileScannerService {
     public ArrayList<String> getTransCodeList(String keyword, String rootPath,String sopFilePath);
}
