package csv.util.invoices;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.zip.GZIPInputStream;

class PSConverter {

	// class global properties
	BufferedReader postScript;
	Runtime runtime;
	Process process;
	String convCmd, rootDir;
	Vector logoData, textData;

	// default constructor
	public PSConverter(String rootDir) throws IOException {
		String inLine;
		this.rootDir = rootDir;
		runtime = Runtime.getRuntime();
		process = null;
		convCmd = "C:\\gs\\gs7.00\\bin\\gswin32c -dCompatibilityLevel#1.2 -q -dSAFER "
				+ "-dNOPAUSE -dBATCH -sDEVICE#pdfwrite -sOutputFile#";
		// load up image definition and image data
		logoData = new Vector();
		BufferedReader r = new BufferedReader(new FileReader(rootDir
				+ "/mcel_med.eps"));
		while ((inLine = r.readLine()) != null) {
			logoData.addElement(inLine);
		}

		r.close();
		textData = new Vector();

		r = new BufferedReader(new FileReader(rootDir + "/text.eps"));
		while ((inLine = r.readLine()) != null)
			textData.addElement(inLine);
		r.close();
	}

	// Method to convert a GZIPed input stream into a PDF file which
	// is written to disk for further storage and transmission purposes.
	public int convert(InputStream inputStream, String psFileName,
			String pdfFileName) throws IOException {
		// declare some local properties
		int d, lineCount = 0, indx;
		String cmd, inLine, invoiceAmount, customerCode, invoiceNumber;
		PrintWriter out;
		boolean firstPage;

		// add the rootdir to the ps and pdf file names

		psFileName = rootDir + psFileName;
		pdfFileName = rootDir + pdfFileName;

		// tie the input stream to the post script handler
		postScript = new BufferedReader(new InputStreamReader(
				new GZIPInputStream(inputStream)));
		// open the PostScript output file
		out = new PrintWriter(new FileWriter(psFileName));

		firstPage = true;
		customerCode = "";
		invoiceNumber = "";
		invoiceAmount = "";
		// and process
		while ((inLine = postScript.readLine()) != null) {
			lineCount++;

			// add the barcode

			if (!firstPage) {
				out.println(inLine);
			} else {
				if (inLine.startsWith("70 737"))
					out.println("70 717 "
							+ inLine.substring(inLine.indexOf("move")));
				else if (inLine.startsWith("70 730"))
					out.println("70 710 "
							+ inLine.substring(inLine.indexOf("move")));
				else if (inLine.indexOf("/parenleft {") >= 0) {
					out.println(inLine);
					out.println("         275 0 0 0 275 250 setcachedevice");
					out
							.println("         [ 0   0  25 500    100  0  50 500   200  0  25 500 ] rectfill} bind def");
					postScript.readLine();
					postScript.readLine();
				} else if (inLine.indexOf("/equal {") >= 0) {
					out.println(inLine);
					out.println("         275 0 0 0 275 250 setcachedevice");
					out
							.println("         [ 0   0 75 500       125  0 50 500    225  0 25 500 ] rectfill} bind def");
					postScript.readLine();
					postScript.readLine();
				} else if (inLine.indexOf("/question {") >= 0) {
					out.println(inLine);
					out.println("         275 0 0 0 275 250 setcachedevice");
					out
							.println("         [ 0   0 50 500       75   0 50 500    200  0 50 500 ] rectfill} bind def");
					postScript.readLine();
					postScript.readLine();
				} else if (inLine.indexOf("/R {") >= 0) {
					out.println(inLine);
					out.println("         275 0 0 0 275 250 setcachedevice");
					out
							.println("         [   0   0  50 500   125   0  25 500   175   0  75 500 ] rectfill} bind def");
					postScript.readLine();
					postScript.readLine();
				} else if (inLine.indexOf("/bracketright {") >= 0) {
					out.println(inLine);
					out.println("         275 0 0 0 275 250 setcachedevice");
					out
							.println("         [  0   0  50 500      100   0  25 500  225   0  25 500 ] rectfill} bind def");
					postScript.readLine();
					postScript.readLine();
				} else if (inLine.indexOf("/p {") >= 0) {
					out.println(inLine);
					out.println("         275 0 0 0 275 250 setcachedevice");
					out
							.println("         [  0   0  25 500      50   0  25 500    125   0 100 500 ] rectfill} bind def");
					postScript.readLine();
					postScript.readLine();
				} else if (inLine.indexOf("/r {") >= 0) {
					out.println(inLine);
					out.println("         275 0 0 0 275 250 setcachedevice");
					out
							.println("         [  0   0  25 500      75   0  25 500  150   0 100 500 ] rectfill} bind def");
					postScript.readLine();
					postScript.readLine();
				} else if (inLine.indexOf("/FNC2 {") >= 0) {
					out.println(inLine);
					out.println("         275 0 0 0 275 250 setcachedevice");
					out
							.println("         [  0   0  100 500   125   0   25 500  175   0   25 500 ] rectfill} bind def");
					postScript.readLine();
					postScript.readLine();
				} else if ((indx = inLine
						.indexOf("275 0 0 0 275 500 setcachedevice")) >= 0) {
					out.println(inLine.substring(0, indx)
							+ "275 0 0 0 275 250 setcachedevice "
							+ inLine.substring(indx + 32));
				} else if (inLine.indexOf("525 0 0 0 525 500 setcachedevice") >= 0) {
					out.println("525 0 0 0 525 250 setcachedevice");
				} else if (inLine.indexOf("575 0 0 0 325 500 setcachedevice") >= 0) {
					out.println("575 0 0 0 325 250 setcachedevice");
				} else if (inLine.indexOf("/FontMatrix [") >= 0) {
					out
							.println("        /FontMatrix [0.001 0 0 0.001 0 0] def");
				} else if (inLine.indexOf("Edificio mCel") >= 0) {
					out
							.println("70 707 moveto (Edificio mCel - Esq. Av. 25 de Setembro & R. Belmiro O. Muianga - CP 1483 - Maputo) show");
				} else if (inLine.indexOf("N.U.I.T. 600000136") >= 0) {
					out.println("70 700 moveto (N.U.I.T. 600000136) show");
				} else {
					// output the line
					out.println(inLine);

					if (inLine.indexOf("175 639") == 0) {
						customerCode = inLine
								.substring(16, inLine.indexOf(")"));
					} else if (inLine.indexOf("175 629") == 0) {
						invoiceNumber = inLine.substring(16, inLine
								.indexOf(")"));
					} else if (inLine.indexOf("TOTAL A PAGAR") >= 0
							&& inLine.indexOf("MTn") == -1) {
						out.println(postScript.readLine());
						inLine = postScript.readLine();
						out.println(inLine);
						invoiceAmount = inLine.substring(16, inLine
								.indexOf(")"));
					} else if (inLine.startsWith("%%Page:")) {
						out
								.println("% Begin MCel logo insert - added by PSConverter");
						for (int i = 0; i < logoData.size(); i++)
							out.println((String) logoData.elementAt(i));
						out
								.println("% End MCel logo insert - added by PSConverter");
						out
								.println("% Begin MCel text insert - added by PSConverter");
						for (int i = 0; i < textData.size(); i++)
							out.println((String) textData.elementAt(i));
						out
								.println("% End MCel text insert - added by PSConverter");

					} else if (inLine.indexOf("% end of meta") == 0) {
						out
								.println("/FN50 /Barcodefont findfont 40 scalefont def");
						out
								.println("/FN51 /Helvetica findfont 4 scalefont def");
					}

					if (inLine.indexOf("anteriores") >= 0) {
						out.println("FN50 setfont");
						out.println("60 56 moveto ("
								+ convToBarCode(customerCode) + ") show");
						out.println("60 36 moveto ("
								+ convToBarCode(invoiceNumber) + ") show");
						out.println("538 36 moveto ("
								+ convToBarCode(invoiceAmount) + ") () rtext");
						out.println("FN51 setfont");
						out.println("70 52 moveto (" + customerCode + ") show");
						out
								.println("70 47 moveto (" + invoiceNumber
										+ ") show");
						out.println("528 47 moveto (" + invoiceAmount
								+ ") () rtext");

						firstPage = false;
					}
				}
			} // end else if firstpage
		}
		// and close the uncompressed PS file
		out.flush();
		out.close();

		// add in bar codes

		// built the PS to PDF conversion command line
		cmd = convCmd + pdfFileName + " -c .setpdfwrite -f " + psFileName;
		System.out.println("cmd=====" + cmd);
		// and convert to PDF
		process = runtime.exec(cmd);
		return lineCount;
	}

	// Method to convert a GZIPed input stream into a PDF file which
	// is written to disk for further storage and transmission purposes.
	// This method does not add the Mcel & TDM Logos
	public int convertNoLogo(InputStream inputStream, String psFileName,
			String pdfFileName) throws IOException {
		// declare some local properties
		int d, lineCount = 0, i;
		String cmd, inLine, invoiceNumber, invoiceAmount, customerCode;
		PrintWriter out;
		boolean firstPage;

		// add the rootdir to the ps and pdf file names
		psFileName = rootDir + "//" + psFileName;
		pdfFileName = rootDir +  "//" + pdfFileName;

		// tie the input stream to the post script handler
		postScript = new BufferedReader(new InputStreamReader(
				new GZIPInputStream(inputStream)));

		// open the PostScript output file
		out = new PrintWriter(new FileWriter(psFileName));
		firstPage = true;
		invoiceNumber = "";
		invoiceAmount = "";
		customerCode = "";

		// and process
		while ((inLine = postScript.readLine()) != null) {
			// add the barcode

			if (!firstPage) {
				out.println(inLine);
			} else {
				if (inLine.indexOf("/parenleft {") >= 0) {
					out.println(inLine);
					out.println("         275 0 0 0 275 250 setcachedevice");
					out
							.println("         [ 0   0  25 500    100  0  50 500   200  0  25 500 ] rectfill} bind def");
					postScript.readLine();
					postScript.readLine();
				} else if (inLine.indexOf("/equal {") >= 0) {
					out.println(inLine);
					out.println("         275 0 0 0 275 250 setcachedevice");
					out
							.println("         [ 0   0 75 500       125  0 50 500    225  0 25 500 ] rectfill} bind def");
					postScript.readLine();
					postScript.readLine();
				} else if (inLine.indexOf("/question {") >= 0) {
					out.println(inLine);
					out.println("         275 0 0 0 275 250 setcachedevice");
					out
							.println("         [ 0   0 50 500       75   0 50 500    200  0 50 500 ] rectfill} bind def");
					postScript.readLine();
					postScript.readLine();
				} else if (inLine.indexOf("/R {") >= 0) {
					out.println(inLine);
					out.println("         275 0 0 0 275 250 setcachedevice");
					out
							.println("         [   0   0  50 500   125   0  25 500   175   0  75 500 ] rectfill} bind def");
					postScript.readLine();
					postScript.readLine();
				} else if (inLine.indexOf("/bracketright {") >= 0) {
					out.println(inLine);
					out.println("         275 0 0 0 275 250 setcachedevice");
					out
							.println("         [  0   0  50 500      100   0  25 500  225   0  25 500 ] rectfill} bind def");
					postScript.readLine();
					postScript.readLine();
				} else if (inLine.indexOf("/p {") >= 0) {
					out.println(inLine);
					out.println("         275 0 0 0 275 250 setcachedevice");
					out
							.println("         [  0   0  25 500      50   0  25 500    125   0 100 500 ] rectfill} bind def");
					postScript.readLine();
					postScript.readLine();
				} else if (inLine.indexOf("/r {") >= 0) {
					out.println(inLine);
					out.println("         275 0 0 0 275 250 setcachedevice");
					out
							.println("         [  0   0  25 500      75   0  25 500  150   0 100 500 ] rectfill} bind def");
					postScript.readLine();
					postScript.readLine();
				} else if (inLine.indexOf("/FNC2 {") >= 0) {
					out.println(inLine);
					out.println("         275 0 0 0 275 250 setcachedevice");
					out
							.println("         [  0   0  100 500   125   0   25 500  175   0   25 500 ] rectfill} bind def");
					postScript.readLine();
					postScript.readLine();
				} else if ((i = inLine
						.indexOf("275 0 0 0 275 500 setcachedevice")) >= 0) {
					out.println(inLine.substring(0, i)
							+ "275 0 0 0 275 250 setcachedevice "
							+ inLine.substring(i + 32));
				} else if (inLine.indexOf("525 0 0 0 525 500 setcachedevice") >= 0) {
					out.println("525 0 0 0 525 250 setcachedevice");
				} else if (inLine.indexOf("575 0 0 0 325 500 setcachedevice") >= 0) {
					out.println("575 0 0 0 325 250 setcachedevice");
				} else if (inLine.indexOf("/FontMatrix [") >= 0) {
					out
							.println("        /FontMatrix [0.001 0 0 0.001 0 0] def");
				} else if (inLine.indexOf("Edificio mCel") >= 0) {
					out
							.println("70 707 moveto (Edificio mCel - Esq. Av. 25 de Setembro & R. Belmiro O. Muianga - CP 1483 - Maputo) show");
				} else if (inLine.indexOf("N.U.I.T. 600000136") >= 0) {
					out.println("70 700 moveto (N.U.I.T. 600000136) show");
				} else {
					out.println(inLine);
					if (inLine.indexOf("175 639") == 0) {
						customerCode = inLine
								.substring(16, inLine.indexOf(")"));
					} else if (inLine.indexOf("175 629") == 0) {
						invoiceNumber = inLine.substring(16, inLine
								.indexOf(")"));
					}
					// else if(inLine.indexOf("TOTAL A PAGAR") >= 0)
					else if (inLine.indexOf("TOTAL A PAGAR") >= 0
							&& inLine.indexOf("MTn") == -1) {
						out.println(postScript.readLine());
						inLine = postScript.readLine();
						out.println(inLine);
						invoiceAmount = inLine.substring(16, inLine
								.indexOf(")"));
					}

					if (inLine.indexOf("% end of meta") == 0) {
						out
								.println("/FN50 /Barcodefont findfont 40 scalefont def");
						out
								.println("/FN51 /Helvetica findfont 4 scalefont def");
					}

					if (inLine.indexOf("anteriores") >= 0) {
						out.println("FN50 setfont");
						out.println("60 52 moveto ("
								+ convToBarCode(invoiceAmount) + ") show");
						out.println("60 36 moveto ("
								+ convToBarCode(invoiceNumber) + ") show");
						out.println("538 36 moveto ("
								+ convToBarCode(customerCode) + ") () rtext");
						out.println("FN51 setfont");
						out
								.println("70 63 moveto (" + invoiceAmount
										+ ") show");
						out
								.println("70 47 moveto (" + invoiceNumber
										+ ") show");
						out.println("528 47 moveto (" + customerCode
								+ ") () rtext");
						firstPage = false;
					}
				}
			} // end else if firstpage
		}
		// and close the uncompressed PS file
		out.flush();
		out.close();

		// built the PS to PDF conversion command line
		cmd = convCmd + pdfFileName + " -c .setpdfwrite -f " + psFileName;
		// and convert to PDF
		process = runtime.exec(cmd);
		return lineCount;
	}

	public String getRootDir() {
		return rootDir;
	}

	public String convToBarCode(String s) {
		StringBuffer stringbuffer1 = new StringBuffer(s);
		StringBuffer stringbuffer = new StringBuffer();
		int j = 104;
		int l = 1;
		stringbuffer.append("\\210");
		for (int i1 = 0; i1 < stringbuffer1.length(); i1++) {
			int i = stringbuffer1.charAt(i1);
			if (i != 32) {
				j += (i - 32) * l++;
				stringbuffer.append((char) i);
			}
		}

		int k = j % 103 + 32;
		String invoiceNumber = Integer.toOctalString(k);
		if (invoiceNumber.length() == 1) {
			stringbuffer.append("\\00" + invoiceNumber);
		} else if (invoiceNumber.length() == 2) {
			stringbuffer.append("\\0" + invoiceNumber);
		} else {
			stringbuffer.append("\\" + invoiceNumber);
		}
		stringbuffer.append("\\212");
		return stringbuffer.toString();
	}

}
