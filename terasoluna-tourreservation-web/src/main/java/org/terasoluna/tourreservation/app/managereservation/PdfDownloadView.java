package org.terasoluna.tourreservation.app.managereservation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfStamperView;

import com.lowagie.text.pdf.AcroFields;

@Component
public class PdfDownloadView extends AbstractPdfStamperView {

    @Override
    protected void mergePdfDocument(Map<String, Object> model,
            com.lowagie.text.pdf.PdfStamper stamper, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        DownloadPDFOutput downloadPDFOutput = (DownloadPDFOutput) model.get(
                "downloadPDFOutput");

        AcroFields form = stamper.getAcroFields();
        form.setField("referenceName", downloadPDFOutput.getReferenceName());
        form.setField("referenceEmail", downloadPDFOutput.getReferenceEmail());
        form.setField("referenceTel", downloadPDFOutput.getReferenceTel());
        form.setField("paymentMethod", downloadPDFOutput.getPaymentMethod());
        form.setField("paymentCompanyName", downloadPDFOutput
                .getPaymentCompanyName());
        form.setField("paymentAccount", downloadPDFOutput.getPaymentAccount());
        form.setField("childCount", String.valueOf(downloadPDFOutput
                .getChildCount()));
        form.setField("tourName", downloadPDFOutput.getTourName());
        form.setField("accomName", downloadPDFOutput.getAccomName());
        form.setField("customerKana", downloadPDFOutput.getCustomerKana());
        form.setField("customerTel", downloadPDFOutput.getCustomerTel());
        form.setField("adultUnitPrice", String.valueOf(downloadPDFOutput
                .getAdultUnitPrice()));
        form.setField("reservedDay", String.valueOf(downloadPDFOutput
                .getReservedDay()));
        form.setField("conductor", downloadPDFOutput.getConductor());
        form.setField("tourAbs", downloadPDFOutput.getTourAbs());
        form.setField("customerAdd", downloadPDFOutput.getCustomerAdd());
        form.setField("customerJob", downloadPDFOutput.getCustomerJob());
        form.setField("tourDays", downloadPDFOutput.getTourDays());
        form.setField("depDay", String.valueOf(downloadPDFOutput.getDepDay()));
        form.setField("customerName", downloadPDFOutput.getCustomerName());
        form.setField("childUnitPrice", String.valueOf(downloadPDFOutput
                .getChildUnitPrice()));
        form.setField("depName", downloadPDFOutput.getDepName());
        form.setField("customerBirth", String.valueOf(downloadPDFOutput
                .getCustomerBirth()));
        form.setField("arrName", downloadPDFOutput.getArrName());
        form.setField("customerMail", downloadPDFOutput.getCustomerMail());
        form.setField("adultCount", String.valueOf(downloadPDFOutput
                .getAdultCount()));
        form.setField("customerCode", downloadPDFOutput.getCustomerCode());
        form.setField("reserveNo", downloadPDFOutput.getReserveNo());
        form.setField("remarks", downloadPDFOutput.getRemarks());
        form.setField("accomTel", downloadPDFOutput.getAccomTel());
        form.setField("customerPost", downloadPDFOutput.getCustomerPost());
        form.setField("printDay", String.valueOf(downloadPDFOutput
                .getPrintDay()));
        form.setField("adultPrice", String.valueOf(downloadPDFOutput
                .getAdultPrice()));
        form.setField("childPrice", String.valueOf(downloadPDFOutput
                .getChildPrice()));
        form.setField("sumPrice", String.valueOf(downloadPDFOutput
                .getSumPrice()));
        form.setField("paymentTimeLimit", downloadPDFOutput
                .getPaymentTimeLimit());
        stamper.setFormFlattening(true);
        stamper.setFreeTextFlattening(true);
        stamper.close();

        response.setContentType("application/pdf");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition",
                "attachment; filename=test.pdf");
    }

    @Override
    public String getUrl() {
        return "classpath:reports/reservationReport.pdf";
    }

}
