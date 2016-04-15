package csv.util.invoices;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

public class InvoiceConverter implements Serializable, ServletContextAware {

	private static final long serialVersionUID = -7632739718351043209L;
	
	private ServletContext servletContext;
	PSConverter psConv;
	private String from, to, subject, bodyText, fileName, period,
		attachmentName, pdfFile, psFile, customerCode;
	int customerId;
	InputStream image;
	private String rootDir;
	
	public InvoiceConverter(String rootDir) {
		this.rootDir = rootDir;
	}
	
	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	private void init() {
		try {
			PCalendar cal = new PCalendar();
			if (period != null) {
				cal.clear();
				cal.set(2001, 7, 1);
				cal.set(java.lang.Integer.parseInt(period.substring(0, 4)),
						java.lang.Integer.parseInt(period.substring(5, 7)) - 1,
						1);
			}

			from = "mCelBilling@mcel.co.mz";
			subject = "MCel - Factura de " + cal.getMonth() + " "
					+ cal.getYear();
			bodyText = "Caro(a) Cliente;\n\n" + "Anexa esta a s/a factura de "
					+ cal.getMonth() + " " + cal.getYear() + ".\n\n"
					+ "Cumprimentos\nMCel";
			attachmentName = "MCel_Factura_" + cal.getMonth() + cal.getYear()
					+ ".pdf";

			period = cal.getPeriod();
			// set ps conversion
			psConv = new PSConverter(servletContext.getRealPath(rootDir));
		} catch (Exception e) {
			System.err.println("Invoice Converter : System problem at startup " + e);
		}
	}

	public int processInvNumber(InputStream biImage,String fName, boolean includeLogo) {
		// get the bill
		try {
			// if ((image = cust.getImageOhx(customerId, ohxAct)) != null)
			if ((image = biImage) != null) {
				psFile = fName + ".ps";
				pdfFile = fName + ".pdf";
				if(new File(pdfFile).exists())return 0;

				if (includeLogo)
					psConv.convert(image, psFile, pdfFile);
				else
					psConv.convertNoLogo(image, psFile, pdfFile);

				// delay a few seconds for file to complete writing to disk
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.err.println("Interrupted");
				}

				return 0;

			} else {
				return 1;
			}
		} catch (Exception e) {
			return 2;
		}
	}
	
	// method to delete files
	public void delete(String filePrefix) {
		new File(filePrefix + ".pdf").delete();
		new File(filePrefix + ".ps").delete();
	}
}
