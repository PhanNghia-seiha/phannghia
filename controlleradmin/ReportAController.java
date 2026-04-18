package com.example.asm2java202.controlleradmin;

import com.example.asm2java202.repository.OrderDetailRepository;
import com.example.asm2java202.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/report")
public class ReportAController {

    private final ReportService reportService;

    // 📊 DOANH THU
    @GetMapping("/revenue")
    public String revenue(Model model){
        model.addAttribute("items", reportService.getRevenue());
        return "admin/revenue";
    }

    // 👑 VIP
    @GetMapping("/vip")
    public String vip(Model model){
        model.addAttribute("items", reportService.getVip());
        return "admin/vip";
    }
}