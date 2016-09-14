package org.pr.ba.tut;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

public class OpenNLPNerLocation extends JCasAnnotator_ImplBase {

	 public void initialize(UimaContext ctx) throws ResourceInitializationException {
		super.initialize(ctx);
	
	}
	
	
	
	@Override
	public void process(JCas arg0) throws AnalysisEngineProcessException {

		
	}

}
