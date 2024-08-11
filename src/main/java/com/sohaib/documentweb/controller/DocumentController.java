package com.sohaib.documentweb.controller;

import com.sohaib.documentweb.entities.Document;
import com.sohaib.documentweb.repos.DocumentRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class DocumentController {

    @Autowired
    private DocumentRepository documentRepository;


    @RequestMapping("/displayUpload")
    public String displayUpload(ModelMap modelMap) {
        List<Document> documents = documentRepository.findAll();
        modelMap.addAttribute("documents", documents);
        return "documentUpload";
    }

    @PostMapping("/upload")
    public String uploadDocument(@RequestParam("document") MultipartFile file, @RequestParam("id") Long id, ModelMap modelMap
    ) throws IOException {
        Document document = new Document();
        document.setId(id);
        document.setName(file.getOriginalFilename());
        document.setData(file.getBytes());
        documentRepository.save(document);
        List<Document> documents = documentRepository.findAll();
        modelMap.addAttribute("documents", documents);
        return "documentUpload";
    }

    @RequestMapping("/download")
    public StreamingResponseBody download(@RequestParam("id") Long id, HttpServletResponse response) {
        Document document = documentRepository.findById(id).get();
        byte[] data = document.getData();
        response.setHeader("Content-Disposition", "attachment; filename=\"" + document.getName() + "\"");
        return outputStream -> {
            outputStream.write(data);
        };
    }
}
