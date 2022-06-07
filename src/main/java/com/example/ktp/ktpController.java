/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ktp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Ican
 */
@Controller
public class ktpController {

    DataktpJpaController controller = new DataktpJpaController();
    List<Dataktp> ktp = new ArrayList<>();

    @RequestMapping("/home")
    public String getAllktp(Model model) {
        try {
            ktp = controller.findDataktpEntities();
        } catch (Exception ex) {

        }
        model.addAttribute("dataktp", ktp);
        return "home";
    }

    @RequestMapping("/tambahdata")
    public String add() {
        return "tambahdata";
    }
    
    @RequestMapping("/editdata")
    public String update() {
        return "editdata";
    }

    @PostMapping(value = "/simpan", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String simpan(@RequestParam("foto") MultipartFile file, HttpServletRequest req) throws Exception {
        Dataktp ktp = new Dataktp();

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("tgllahir"));
        byte[] img = file.getBytes();

        ktp.setNama(req.getParameter("nama"));
        ktp.setNik(req.getParameter("nik"));
        ktp.setTgllahir(date);
        ktp.setAlamat(req.getParameter("alamat"));
        ktp.setJkelamin(req.getParameter("jkelamin"));
        ktp.setAgama(req.getParameter("agama"));
        ktp.setStatus(req.getParameter("status"));
        ktp.setPerkerjaan(req.getParameter("pekerjaan"));
        ktp.setWnegara(req.getParameter("wnegara"));
        ktp.setBhingga(req.getParameter("bhingga"));
        ktp.setFoto(img);

        controller.create(ktp);
        return "redirect:/home";
    }

    @RequestMapping("/detail/{id}")
    public String getAllktpDetail(Model model, @PathVariable("id") int id) {
        Dataktp ktp2 = new Dataktp();
        String imglink = "";
        try {
            ktp2 = controller.findDataktp(id);
            String base64Image = Base64.encodeBase64String(ktp2.getFoto());
            imglink = "data:image/png;base64,".concat(base64Image); 
            
        } catch (Exception ex) {

        }
        model.addAttribute("foto2",imglink);
        model.addAttribute("detaildata", ktp2);
        return "detail";
    }

    @RequestMapping("/editdata/{id}")
    public String getAllktpEdit(Model model, @PathVariable("id") int id) {
        Dataktp ktp2 = new Dataktp();
        String imglink = "";
        int id2 = 0;
        try {
            ktp2 = controller.findDataktp(id);
            String base64Image = Base64.encodeBase64String(ktp2.getFoto());
            imglink = "data:image/png;base64,".concat(base64Image);
            id2 = ktp2.getId();
        } catch (Exception ex) {
            
        }
        model.addAttribute("id2",id2);
        model.addAttribute("foto2",imglink);
        model.addAttribute("editdata", ktp2);
        return "editdata";
    }

    @PostMapping(value = "/editdata/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String edit(@PathVariable("id") int id,@RequestParam("foto") MultipartFile file, HttpServletRequest req) throws ParseException, Exception {
        Dataktp ktp = new Dataktp();

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("tgllahir"));
        byte[] img = file.getBytes();

        ktp.setId(id);
        ktp.setNama(req.getParameter("nama"));
        ktp.setNik(req.getParameter("nik"));
        ktp.setTgllahir(date);
        ktp.setAlamat(req.getParameter("alamat"));
        ktp.setJkelamin(req.getParameter("jkelamin"));
        ktp.setAgama(req.getParameter("agama"));
        ktp.setStatus(req.getParameter("status"));
        ktp.setPerkerjaan(req.getParameter("pekerjaan"));
        ktp.setWnegara(req.getParameter("wnegara"));
        ktp.setBhingga(req.getParameter("bhingga"));
        ktp.setFoto(img);

        controller.edit(ktp);
        return "redirect:/home";
    }

    @GetMapping("/hapus/{id}")
    public String hapus(@PathVariable("id") int id, Model model) throws Exception {
        controller.destroy(id);
        return "redirect:/home";
    }

}
