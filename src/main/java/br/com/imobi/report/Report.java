/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.imobi.report;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author dglsw
 */
public class Report {

    public static void createReport(List javabeans, String jrxml_file) throws JRException, FileNotFoundException {
        Report r = new Report();

        final InputStream stream = r.getClass().getResourceAsStream("/reports/" + jrxml_file);

        final JasperReport report = JasperCompileManager.compileReport(stream);

        final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(javabeans);

        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "douglaswender");
        
        final JasperPrint print = JasperFillManager.fillReport(report, parameters, source);
        
        JasperViewer v = new JasperViewer(print, false);
        v.requestFocus();
        v.toFront();
        v.setVisible(true);
        
    }

}
