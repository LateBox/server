package com.latebox.server.report;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReportController {

    private final ReportRepository repository;

    public ReportController(ReportRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/reports")
    List<Report> all() {
        return repository.findAll();
    }

    @PostMapping("/reports")
    Report newReport(@RequestBody Report newReport) {
        return repository.save(newReport);
    }

    @GetMapping("/reports/{id}")
    Report one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ReportNotFoundException(id));
    }

    @PutMapping("/reports/{id}")
    Report replaceReport(@RequestBody Report newReport, @PathVariable Long id) {

        return repository.findById(id)
                .map(report -> {
                    report.setUserId(newReport.getUserId());
                    report.setRestaurantId(newReport.getRestaurantId());
                    report.setReportContent(newReport.getReportContent());
                    return repository.save(report);
                })
                .orElseGet(() -> {
                    newReport.setId(id);
                    return repository.save(newReport);
                });
    }

    @DeleteMapping("/reports/{id}")
    void deleteReport(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ReportNotFoundException(id);
        }
    }
}

