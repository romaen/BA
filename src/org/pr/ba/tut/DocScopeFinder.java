package org.pr.ba.tut;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.util.Level;
import org.pr.ba.type.Document;

public class DocScopeFinder extends JCasAnnotator_ImplBase {

	private String docPattern = "\\r\\n|\\r|\\n";
	private Matcher matcher = null;
	private Pattern pattern = null;
	
	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {

		String docText = jcas.getDocumentText();
		
		pattern = Pattern.compile(docPattern);
		matcher = pattern.matcher(docText);
		
		int pos = 0;
		while (matcher.find(pos)) {
			Document annotation = new Document(jcas);
			annotation.setBegin(pos);
			annotation.setEnd(matcher.end());
			annotation.addToIndexes();
			pos = matcher.end();
			getContext().getLogger().log(Level.FINEST, "Found: " + annotation);

		}
	}

	
	
}
