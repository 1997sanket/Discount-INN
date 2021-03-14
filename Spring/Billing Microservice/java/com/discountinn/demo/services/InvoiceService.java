package com.discountinn.demo.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.discountinn.demo.models.Billing;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class InvoiceService {

	public String exportInvoice(Billing bill) throws FileNotFoundException, JRException {
		
		//Load file and compile it
		File file = ResourceUtils.getFile("classpath:Invoice.jrxml");
		
		JasperReport report = JasperCompileManager.compileReport(file.getAbsolutePath());
		
		List<Billing> bills = new ArrayList<Billing>();
		
		bills.add(bill);
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(bills);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Created by " , "Discount INN");
		
		JasperPrint print = JasperFillManager.fillReport(report, map, dataSource);
		
		JasperExportManager.exportReportToPdfFile(print, "Invoice.pdf");
		//JasperExportManager.exportReportToPdfFile(print, "../../../../../resources/static/Invoice.pdf");
		
		//System.out.println("Invoice generated in path : " + "../../../../../resources/static");
		 	
		return "Invoice.pdf";
		
		//return "../../../../../resources/static/Invoice.pdf";
	}
}
