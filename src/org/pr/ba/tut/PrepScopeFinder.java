package org.pr.ba.tut;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.pr.ba.type.PrepScope;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

public class PrepScopeFinder extends JCasAnnotator_ImplBase {
	private String[] prepStrings = { "Präp. I", "Präp. II", "Präp. III", "Präp. IV", "Präp. V", "Präp. VI",
			"Präparat" };
	private String[] penDepth = { "\\d\\.\\dmm", "\\d\\,\\dmm", "\\d\\.\\d\\dmm", "\\d\\,\\d\\dmm", "\\d\\.\\d mm", "\\d\\,\\d mm", "\\d\\.\\d\\d mm", "\\d\\,\\d\\d mm"  };

	private Pattern prepPattern = null;
	private Matcher matcher = null;

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		String docText = jcas.getDocumentText();
		int pos = 0;
		for (int i = 0; i < prepStrings.length; i++) {
			prepPattern = Pattern.compile(prepStrings[i]);

			matcher = prepPattern.matcher(docText);
		

			while (matcher.find(pos)) {
				PrepScope annotation = new PrepScope(jcas);
				annotation.setBegin(pos);
				annotation.setEnd(matcher.end());
				annotation.addToIndexes();
				pos = matcher.end();
			}
		}

	}

}
