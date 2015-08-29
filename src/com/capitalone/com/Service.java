package com.capitalone.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.midi.Track;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/dms")
public class Service {

	// http://localhost:8080/DmsJava/rest/dms/getInput
	@GET
	@Path("/getInput")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTrack() {

		String str = "";

		BufferedReader br = null;

		try {

			String sCurrentLine;

			
			br = new BufferedReader(new FileReader("C:\\productTypes.json"));

			while ((sCurrentLine = br.readLine()) != null) {
				// System.out.println(sCurrentLine);
				str = str + sCurrentLine;
			}
//			System.out.println(str);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		// String test="{\"items\":[{\"prod_type_cd\":\"CD\",\"prod_class_cd\":\"IM\",\"prod_type_desc\":\"Certificate of Deposi\"},{\"prod_type_cd\":\"DDA\",\"prod_class_cd\":\"IM\",\"prod_type_desc\":\"Checkig\"},{\"prod_type_cd\":\"MMA\",\"prod_class_cd\":\"IM\",\"prod_type_desc\":\"Money Market\"},{\"prod_type_cd\":\"SA\",\"prod_class_cd\":\"IM\",\"prod_type_desc\":\"Savings\"},{\"prod_type_cd\":\"RI\",\"prod_class_cd\":\"IN\",\"prod_type_desc\":\"RENTERS INSURANCE\"},{\"prod_type_cd\":\"PLI\",\"prod_class_cd\":\"IN\",\"prod_type_desc\":\"PERSONAL LIABILITY INSURANCE\"},{\"prod_type_cd\":\"TLI\",\"prod_class_cd\":\"IN\",\"prod_type_desc\":\"TERM LIFE INSURANCE\"},{\"prod_type_cd\":\"WLI \",\"prod_class_cd\":\"IN\",\"prod_type_desc\":\"WHOLE LIFE INSURANCE\"},{\"prod_type_cd\":\"ULI\",\"prod_class_cd\":\"IN\",\"prod_type_desc\":\"UNIVERSAL LIFE INSURANCE\"},{\"prod_type_cd\":\"DL\",\"prod_class_cd\":\"LN\",\"prod_type_desc\":\"Demand Loan\"},{\"prod_type_cd\":\"AL\",\"prod_class_cd\":\"LN\",\"prod_type_desc\":\"Automobile Loan\"},{\"prod_type_cd\":\"HFL\",\"prod_class_cd\":\"LN\",\"prod_type_desc\":\"Health Care Finance Loan\"},{\"prod_type_cd\":\"ML\",\"prod_class_cd\":\"LN\",\"prod_type_desc\":\"Mortgage Loan\"},{\"prod_type_cd\":\"CC\",\"prod_class_cd\":\"LN\",\"prod_type_desc\":\"Credit Card\"},{\"prod_type_cd\":\"CL\",\"prod_class_cd\":\"LN\",\"prod_type_desc\":\"Credit Line\"},{\"prod_type_cd\":\"HELC\",\"prod_class_cd\":\"LN\",\"prod_type_desc\":\"Home Equity Line of Credit\"},{\"prod_type_cd\":\"IRA\",\"prod_class_cd\":\"DP\",\"prod_type_desc\":\"Individual Retirement Account\"},{\"prod_type_cd\":\"AI\",\"prod_class_cd\":\"IN\",\"prod_type_desc\":\"Autombile Insurance\"},{\"prod_type_cd\":\"HI\",\"prod_class_cd\":\"IN\",\"prod_type_desc\":\"Homeowners Insurance\"}]}";
		return str;

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Track track) {

		String result = "Track saved : " + track;
		return Response.status(201).entity(result).build();

	}

}