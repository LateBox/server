package com.latebox.server.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {


//    List<Report> findByName(String name);

    Report findById(long id);
}



