package uk.ac.ucl.panda.retrieval.models;

import java.util.HashMap;
import java.util.Vector;

public class PNW implements Model {

	/**
	 *  PNW parameter
	 */
	private float b = 0.1f;
	/**
	 *  PNW parameter
	 */
	//	    private float k1 = 1.6f;

	/**
	 *  PNW - See Table 1 in 'Modern Information Retrieval: A Brief Overview' 
	 *  by Amit Singhal
	 *  http://singhal.info/ieee2001.pdf
	 *  for more information on how this formula is derived
	 *  
	 *  @param tf - Term Frequency, number of times term appears in the document
	 *  @param df - Document Frequency, number of documents the term appears in
	 *  @param idf - Inverse Document Frequency
	 *  @param DL - number of terms in document
	 *  @param avgDL - average number of terms in all documents
	 *  @param DocNum - number of documents in the collection
	 *  @param CL - Collection Length, number of terms in document collection
	 *  @param CTF - Collection Term Frequency, number of times the term appears in the collection
	 *  @param qTF - Query Term Frequency, number of times the term appears in the query
	 */
	public double getscore(double tf, double df, double idf, double DL, double avgDL, int DocNum, double CL, int CTF, int qTF) {

//		double numerator = 1.0d + (Math.log(1 + (Math.log(tf) / Math.log(2.0d))) / Math.log(2.0d));
//		double denominator = (1.0d - b) + b * DL / avgDL;
//		double firstTerm = numerator / denominator;
//		double score = firstTerm * qTF * (Math.log((DocNum + 1.0d) / df) / Math.log(2.0d));
		
//		double score = ((1.0d + (Math.log(1 + (Math.log(tf) / Math.log(2.0d))) / Math.log(2.0d))) / ((1.0d - b) + b * DL / avgDL)) * qTF * (Math.log((DocNum + 1.0d) / df) / Math.log(2.0d));

//				double temp1 = Math.log(1.0f + Math.log(tf));
//			   	double temp2 = Math.log((DocNum + 1.0f) / df);
//			   	double score = temp2 * qTF * (1.0f + temp1) / ((1.0f - b) + b * DL / avgDL);	//PNW function
			   	
//		double temp = (1.0f + Math.log(Math.log(tf))) / ((1.0f - b) + b * DL / avgDL);
//		double score = temp * qTF * Math.log((DocNum + 1.0f) / df);
		double score = qTF * Math.log((DocNum + 1.0f) / df) * (1.0f + Math.log(1.0f + Math.log(tf))) / (1.0f - b +b* DL / avgDL);
		return score;

	}

	/**
	 *  The following functions are not needed for Text Retrieval assignment
	 */

	@Override
	public double getVSMscore(Vector<String> query, HashMap<String, Integer> TermVector) {
		return 0;
	}

	@Override
	public
	double defaultScore(double tf, double df, double idf, double DL, double avgDL, int DocNum, double CL, int CTF, int qTF) {
		return 0.0d;
	}


	public double defaultScore(double tf, double df, double idf, double DL, double avgDL, int DocNum, double CL, int CTF, int qTF, double a) {
		b = (float)a;
		return defaultScore(tf,df, idf, DL, avgDL, DocNum, CL, CTF, qTF);
	}


	public double getscore(double tf, double df, double idf, double DL, double avgDL, int DocNum, double CL, int CTF, int qTF, double a) {
		b = (float) a;
		return getscore(tf, df, idf, DL, avgDL, DocNum, CL, CTF, qTF);
	}

	@Override
	public
	double getmean(double tf, double df, double idf, double DL, double avgDL, int DocNum, double CL, int CTF, int qTF, double a) {

//		double numerator = 1.0d + (Math.log(1 + (Math.log(tf) / Math.log(2.0d))) / Math.log(2.0d));
//		double denominator = (1.0d - b) + b * DL / avgDL;
//		double firstTerm = numerator / denominator;
//		double score = firstTerm * qTF * (Math.log((DocNum + 1.0d) / df) / Math.log(2.0d));
//		double score = ((1.0d + (Math.log(1 + (Math.log(tf) / Math.log(2.0d))) / Math.log(2.0d))) / ((1.0d - b) + b * DL / avgDL)) * qTF * (Math.log((DocNum + 1.0d) / df) / Math.log(2.0d));

//				double temp1 = Math.log(1.0f + Math.log(tf));
//				double temp2 = Math.log((DocNum + 1.0f) / df);
//				double score = temp2 * qTF * (1.0f + temp1) / ((1.0f - b) + b * DL / avgDL);
		
//		double temp = (1.0f + Math.log(Math.log(tf))) / (1.0f - b +b* DL / avgDL);
//		double score = temp * qTF * Math.log((DocNum + 1.0f) / df);
		
		double score = qTF * Math.log((DocNum + 1.0f) / df) * (1.0f + Math.log(1.0f + Math.log(tf))) / (1.0f - b +b* DL / avgDL);
		return score;
		
		//PNW function

	}

	@Override
	public
	double getvar(double tf, double df, double idf, double DL, double avgDL, int DocNum, double CL, int CTF, int qTF, double a) {
		return 0.0;
	}

	@Override
	public
	double defaultmean(double tf, double df, double idf, double DL, double avgDL, int DocNum, double CL, int CTF, int qTF, double a) {
		b = (float) a;
		return defaultScore(tf,df, idf, DL, avgDL, DocNum, CL, CTF, qTF);
	}

	@Override
	public
	double defaultvar(double tf, double df, double idf, double DL, double avgDL, int DocNum, double CL, int CTF, int qTF, double a) {
		return 0.0;
	}





}
