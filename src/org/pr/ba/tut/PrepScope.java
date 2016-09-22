package org.pr.ba.tut;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

public class PrepScope extends JCasAnnotator_ImplBase {
	private String[] prepStrings = { "Präp. ", "Präparat" };
	private String[] penDepth = { "\\d\\.\\dmm", "\\d\\,\\dmm", "\\d\\.\\d\\dmm", "\\d\\,\\d\\dmm", "\\d\\.\\d mm",
			"\\d\\,\\d mm", "\\d\\.\\d\\d mm", "\\d\\,\\d\\d mm" };

	private Pattern prepPattern = null;
	private Matcher matcher = null;

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
//		String docText = jcas.getDocumentText();
//		int pos = 0, regSt = 0, regEnd = 0;
//		for (int i = 0; i < penDepth.length; i++) {
//			System.out.println(penDepth[i]);
//			prepPattern = Pattern.compile(penDepth[i]);
//
//			matcher = prepPattern.matcher(docText);
//			regSt = matcher.regionStart();
//			regEnd = matcher.regionEnd();
//			while (matcher.find(pos)) {
//				PrepScope annotation = new PrepScope(jcas);
//				annotation.setBegin(pos);
//				annotation.setEnd(matcher.start());
//				System.out.println(matcher.toString() + " " + regSt + " " + regEnd);
//				annotation.addToIndexes();
//				pos = matcher.end();
//			}
//		}

	}

}
