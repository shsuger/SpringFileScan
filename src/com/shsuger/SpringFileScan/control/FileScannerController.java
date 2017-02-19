package com.shsuger.SpringFileScan.control;

import com.shsuger.SpringFileScan.service.FileScannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by shsuger on 2017/2/18.
 */
@Controller
@RequestMapping(value = "/shsuger", method = RequestMethod.GET)
public class FileScannerController {

    @Autowired
    private FileScannerService tFileScannerService;

    @RequestMapping(value = "/filescanInput", method = RequestMethod.GET)
    public String printHello(Model model) {
        return "transNameInput";
    }
    @RequestMapping(value = "/searchtransName.do", method = RequestMethod.POST)
    public String searchTransName(Model model,HttpServletRequest request) {
        ArrayList result;
        String keyWord = request.getParameter("keyWord");
        String targetRootPath = request.getParameter("targetRootPath");
        String sopFilePath = request.getParameter("sopFilePath");

        result = tFileScannerService.getTransCodeList(keyWord,targetRootPath,sopFilePath);
        model.addAttribute("result",result);

        return "result";
    }
}
